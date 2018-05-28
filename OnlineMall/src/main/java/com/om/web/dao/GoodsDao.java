package com.om.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.om.web.entity.Goods;

public interface GoodsDao {

	int insertGoods(Goods goods);
	int delGoodsByGoodsIds(
			@Param("goods_ids")String[] goods_ids);
	int updateGoods(Goods goods);
	List<Goods> listGoodsByCartId(Integer cart_id);
	List<Goods> listGoodsByOrderId(Integer order_id);
	List<Integer> listGoodIdsByGoodsIds(
			@Param("goods_ids")String[] goods_ids);
	Goods findGoodsByGoodsId(Integer goods_id);
	Goods alreadyHaveGood(@Param("cart_id")Integer cart_id, 
			@Param("good_id")Integer good_id);
}
