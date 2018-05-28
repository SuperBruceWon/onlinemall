package com.om.web.service;

import com.om.common.vo.PageObject;
import com.om.web.entity.Good;

public interface CollService {
	int insertGoodsToCollByGoodsIds(Integer user_id, String goods_ids);
	int insertGoodsToCollByGoodIds(Integer user_id, String[] good_ids);
	PageObject<Good>  listPageGoodsByUserId(Integer user_id, Integer pageCurrent);
	int delGoodsByGoodIds(Integer user_id, String good_ids);
}
