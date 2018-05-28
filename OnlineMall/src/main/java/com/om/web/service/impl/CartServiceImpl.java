package com.om.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.om.common.exception.ServiceException;
import com.om.web.dao.CartDao;
import com.om.web.dao.GoodDao;
import com.om.web.dao.GoodsDao;
import com.om.web.entity.Cart;
import com.om.web.entity.Good;
import com.om.web.entity.Goods;
import com.om.web.service.CartService;

@Transactional(isolation=Isolation.READ_COMMITTED,rollbackFor=Throwable.class)
@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDao cartDao;
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private GoodDao goodDao;
	
	public Integer checkCartId(Integer user_id){
		//1.参数合法性验证
		if(user_id < 0 || user_id == null)
			throw new IllegalArgumentException("用户ID异常！");
		//2.根据用户ID查找购物车ID，如果存在则根据car_id查找对应对象，
		//如果不存在则创建一个该对象,并将对应关系存入中间表
		Integer cart_id = cartDao.findCartIdByUserId(user_id);
		System.out.println("cart_id1:"+cart_id);
		if(cart_id == null){
			Cart cart = new Cart();
			cart.setUser_id(user_id);
			int i = cartDao.insertObject(cart);
			if(i<1)
				throw new ServiceException("系统故障，请稍后重试！");
			cart_id = cart.getCart_id();
			System.out.println("cart_id2:"+cart_id);
		}
		return cart_id;
	}
	
	@Override
	public int insertGoodToCart(Integer user_id,Integer good_id) {
		//1.参数合法性验证
		if(good_id < 0 || good_id == null)
			throw new IllegalArgumentException("商品ID异常！");
		Integer cart_id = checkCartId(user_id);
		Goods goods0 = 
				goodsDao.alreadyHaveGood(cart_id, good_id);
		if(goods0 != null){
			int row =incGoodsNum(goods0.getGoods_id());
			return row;
		}
		Good good = goodDao.findGoodByGoodId(good_id);
		Goods goods = new Goods();
		goods.setCart_id(cart_id);
		goods.setGood_id(good.getGood_id());
		goods.setGood_name(good.getGood_name());
		goods.setGood_imgsrc(good.getGood_imgsrc());
		goods.setGood_desc(good.getGood_desc());
		goods.setGood_price(good.getGood_price());
		goods.setGood_amount(1);
		int row;
		try{
			row = goodsDao.insertGoods(goods);
		}catch(Throwable t){
			throw new ServiceException("系统故障，请稍后重试！");
		}
		return row;
	}

	@Override
	public List<Goods> listGoodsByUserId(Integer user_id) {
		Integer cart_id = checkCartId(user_id);
		List<Goods> goods;
		try{
			goods = goodsDao.listGoodsByCartId(cart_id);
		}catch(Throwable t){
			throw new ServiceException("系统故障，请稍后重试！");
		}
		return goods;
	}

	@Override
	public int incGoodsNum(Integer goods_id) {
		//1.参数合法性验证
		if(goods_id < 0 || goods_id == null)
			throw new IllegalArgumentException("商品ID异常！");
		Goods goods;
		try{
			goods = 
					goodsDao.findGoodsByGoodsId(goods_id);
			if(goods == null)
				throw new ServiceException("该商品信息可能已经不存在！");
		}catch(Throwable t){
			throw new ServiceException("系统故障，请稍后重试！");
		}
		Good good;
		try{
			good = goodDao.findGoodByGoodId(goods.getGood_id());
			if(good == null)
				throw new ServiceException("该商品信息可能已经不存在！");
		}catch(Throwable t){
			throw new ServiceException("系统故障，请稍后重试！");
		}
		if(goods.getGood_amount() < good.getGood_amount()){
			goods.setGood_amount(goods.getGood_amount()+1);
		}else{
			throw new ServiceException("库存不足！");
		}
		int row;
		try{
			row = goodsDao.updateGoods(goods);
		}catch(Throwable t){
			throw new ServiceException("系统故障，请稍后重试！");
		}
		return row;
	}

	@Override
	public int decGoodsNum(Integer goods_id) {
		//1.参数合法性验证
		if(goods_id < 0 || goods_id == null)
			throw new IllegalArgumentException("商品ID异常！");
		Goods goods;
		try{
			goods = 
					goodsDao.findGoodsByGoodsId(goods_id);
			if(goods == null)
				throw new ServiceException("该商品信息可能已经不存在！");
		}catch(Throwable t){
			throw new ServiceException("系统故障，请稍后重试！");
		}
		if(goods.getGood_amount() > 1){
			goods.setGood_amount(goods.getGood_amount()-1);
		}else{
			throw new ServiceException("商品数量不能小于1！");
		}
		int row;
		try{
			row = goodsDao.updateGoods(goods);
		}catch(Throwable t){
			throw new ServiceException("系统故障，请稍后重试！");
		}
		return row;
	}

	@Override
	public int delGoodsByGoodsIds(String[] goods_ids) {
		//1.参数合法性验证
		if(goods_ids == null || goods_ids.length == 0)
			throw new IllegalArgumentException("至少选择一件商品！");
		int row;
		try{
			row = goodsDao.delGoodsByGoodsIds(goods_ids);
			if(row < goods_ids.length)
				throw new ServiceException("数据可能部分或全部不存在！");
		}catch(Throwable t){
			throw new ServiceException("系统故障，请稍后重试！");
		}
		return row;
	}
}
