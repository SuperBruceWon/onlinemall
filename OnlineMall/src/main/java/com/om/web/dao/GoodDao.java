package com.om.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.om.web.entity.Good;

public interface GoodDao {
	
	public Good findObjectsByName(String name);
	
	
	int insertGood(Good good);
	int delGoodsByGoodIds(@Param("good_ids")String[] good_ids);
	int recGoodsByGoodIds(@Param("good_ids")String[] good_ids);
	int updateGood(Good good);
	Good findGoodByGoodId(Integer good_id);
	
	
	List<Good> listGoodsByGoodIds(
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize,
			@Param("good_ids")Integer... good_ids);
	
	
}
