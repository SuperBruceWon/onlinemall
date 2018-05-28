package com.om.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CollGoodDao {
	List<Integer> listGoodIdsByCollId(Integer coll_id);
	int insertGoodsToColl(@Param("coll_id") Integer coll_id,
			@Param("good_ids") Integer... good_ids);
	int delGoodsByGoodIds(@Param("coll_id") Integer coll_id,
			@Param("good_ids") String[] good_ids);
	int emptyColl(Integer coll_id);
	Integer getGoodCount(Integer coll_id);
}
