package com.om.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.om.common.vo.JsonResult;
import com.om.common.vo.PageObject;
import com.om.web.entity.Good;
import com.om.web.service.CollService;

@RestController
@RequestMapping("/coll/")
public class CollController {
	@Autowired
	private CollService collService;
	
	@RequestMapping("listPageGoodsByUserId")
	public JsonResult listPageGoodsByUserId(Integer user_id, Integer pageCurrent){
		System.out.println(user_id+" "+pageCurrent);
		PageObject<Good> list = collService.listPageGoodsByUserId(user_id,pageCurrent);
		return new JsonResult(list);
	}
	
	@RequestMapping("delGoodsByGoodIds")
	public JsonResult delGoodsByGoodIds(Integer user_id, String good_ids){
		System.out.println(user_id+":"+good_ids);
		int rows = collService.delGoodsByGoodIds(user_id, good_ids);
		return new JsonResult(rows,"del goods ok");
	}
	
	@RequestMapping("insertGoodToColl")
	public JsonResult insertGoodToColl(Integer user_id,String[] good_ids){
		int row = 
				collService.insertGoodsToCollByGoodIds(user_id, good_ids);
		return new JsonResult(row,"insert goods ok");
	}
	
	@RequestMapping("insertGoodsToColl")
	public JsonResult insertGoodsToColl(Integer user_id,String goods_ids){
		System.out.println(user_id+":"+goods_ids);
		int row = 
				collService.insertGoodsToCollByGoodsIds(user_id, goods_ids);
		return new JsonResult(row,"insert goods ok");
	}
}
