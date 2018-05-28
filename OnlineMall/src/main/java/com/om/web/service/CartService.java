package com.om.web.service;

import java.util.List;
import com.om.web.entity.Goods;

public interface CartService {
	int insertGoodToCart(Integer user_id,Integer good_id);
	List<Goods> listGoodsByUserId(Integer user_id);
	int incGoodsNum(Integer goods_id);
	int decGoodsNum(Integer goods_id);
	int delGoodsByGoodsIds(String[] goods_ids);
}
