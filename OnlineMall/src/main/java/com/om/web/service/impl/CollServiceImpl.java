package com.om.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import com.om.common.exception.ServiceException;
import com.om.common.vo.PageObject;
import com.om.web.dao.CollDao;
import com.om.web.dao.CollGoodDao;
import com.om.web.dao.GoodDao;
import com.om.web.dao.GoodsDao;
import com.om.web.entity.Coll;
import com.om.web.entity.Good;
import com.om.web.service.CollService;

@Transactional(isolation=Isolation.READ_COMMITTED,rollbackFor=Throwable.class)
@Service
public class CollServiceImpl implements CollService {
	@Autowired
	private CollDao collDao;
	@Autowired
	private CollGoodDao collGoodDao;
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private GoodDao goodDao;
	
	public Integer checkCollId(Integer user_id){
		//1.参数合法性验证
		if(user_id < 0 || user_id == null)
			throw new IllegalArgumentException("用户ID异常！");
		//2.根据用户ID查找购物车ID，如果存在则根据car_id查找对应对象，
		//如果不存在则创建一个该对象,并将对应关系存入中间表
		Integer coll_id = collDao.findCollIdByUserId(user_id);
		if(coll_id == null){
			Coll coll = new Coll();
			coll.setUser_id(user_id);
			int i = collDao.insertObject(coll);
			if(i<1)
				throw new ServiceException("系统故障，请稍后重试！");
			coll_id = coll.getColl_id();
		}
		return coll_id;
	}
	
	
	
	@Override
	public int insertGoodsToCollByGoodsIds(Integer user_id, String goods_ids) {
		//1.参数合法性验证
		if(goods_ids == null)
			throw new IllegalArgumentException("至少选择一件商品！");
		Integer coll_id = checkCollId(user_id);
		System.out.println("coll_id:"+coll_id);
		int rows;
		try{
			List<Integer> good_ids =
					goodsDao.listGoodIdsByGoodsIds(goods_ids.split(","));
			System.out.println("good_ids: "+good_ids);
			rows = 
					collGoodDao.insertGoodsToColl(coll_id, good_ids.toArray(new Integer[good_ids.size()]));
			goodsDao.delGoodsByGoodsIds(goods_ids.split(","));
		}catch(Throwable t){
			throw new ServiceException("系统故障，请稍后重试！");
		}
		
		return rows;
	}

	@Override
	public int insertGoodsToCollByGoodIds(Integer user_id, String[] good_ids) {
		//1.参数合法性验证
		if(good_ids == null || good_ids.length == 0)
			throw new IllegalArgumentException("至少选择一件商品！");
		Integer coll_id = checkCollId(user_id);
		Integer[] ids = new Integer[good_ids.length];
		for(int i=0;i<good_ids.length;i++){
			ids[i] = Integer.parseInt(good_ids[i]);
		}
		int rows;
		try{
			rows = 
					collGoodDao.insertGoodsToColl(coll_id, ids);
		}catch(Throwable t){
			throw new ServiceException("系统故障，请稍后重试！");
		}
		return rows;
	}

	@Override
	public PageObject<Good>  listPageGoodsByUserId(Integer user_id, Integer pageCurrent) {
		//1.参数合法性验证
		if(pageCurrent < 1 || pageCurrent == null)
			throw new IllegalArgumentException("pageCurrent异常！");
		Integer coll_id = checkCollId(user_id);
		System.out.println("coll_id:"+coll_id);
		PageObject<Good> list = new PageObject<Good>();
		list.setPageCurrent(pageCurrent);
		int pageSize = 20;
		int startIndex = (pageCurrent-1)*pageSize;
		try{
			List<Integer> good_ids = 
					collGoodDao.listGoodIdsByCollId(coll_id);
			list.setRowCount(good_ids.size());
			System.out.println("good_ids:"+good_ids);
			System.out.println(good_ids.toArray(new Integer[good_ids.size()]));
			List<Good> goods = 
					goodDao.listGoodsByGoodIds(
							startIndex,pageSize,good_ids.toArray(new Integer[good_ids.size()]));
			System.out.println("goods:"+goods);
			list.setRecodes(goods);
		}catch(Throwable t){
			throw new ServiceException("系统故障，请稍后重试！");
		}
		return list;
	}

	@Override
	public int delGoodsByGoodIds(Integer user_id, String good_ids) {
		//1.参数合法性验证
		if(StringUtils.isEmpty(good_ids))
			throw new IllegalArgumentException("至少选择一件商品！");
		Integer coll_id = checkCollId(user_id);
		System.out.println(user_id+":"+good_ids);
		int rows;
		try{
			rows =
					collGoodDao.delGoodsByGoodIds(coll_id, good_ids.split(","));
			
		}catch(Throwable t){
			throw new ServiceException("系统故障，请稍后重试！");
		}
		return rows;
	}

}
