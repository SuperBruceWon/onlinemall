package com.om.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.om.common.vo.JsonResult;
import com.om.web.entity.Goods;
import com.om.web.service.CartService;

@RestController
@RequestMapping("/cart/")
public class CatController {
	@Autowired
	private CartService cartService;
	
	@RequestMapping("listGoodsByUserId")
	public JsonResult listGoodsByUserId(Integer user_id){
		System.out.println(user_id);
		List<Goods> list = cartService.listGoodsByUserId(user_id);
		return new JsonResult(list);
	}
	
	@RequestMapping("delGoodsByGoodsIds")
	public JsonResult delGoodsByGoodsIds(String[] goods_ids){
		int rows = cartService.delGoodsByGoodsIds(goods_ids);
		return new JsonResult(rows,"list goods ok");
	}
	
	@RequestMapping("insertGoodToCart")
	public JsonResult insertGoodToCart(Integer user_id,Integer good_id){
		int row = cartService.insertGoodToCart(user_id, good_id);
		return new JsonResult(row,"list goods ok");
	}
	
	@RequestMapping("incGoodsNumByGoodsId")
	public JsonResult incGoodsNumByGoodsId(Integer goods_id){
		int row = cartService.incGoodsNum(goods_id);
		return new JsonResult(row,"list goods ok");
	}
	
	@RequestMapping("decGoodsNumByGoodsId")
	public JsonResult decGoodsNumByGoodsId(Integer goods_id){
		int row = cartService.decGoodsNum(goods_id);
		return new JsonResult(row,"list goods ok");
	}
}
