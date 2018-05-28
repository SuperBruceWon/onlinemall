package com.om.web.dao;

import com.om.web.entity.Coll;

public interface CollDao {
	int insertObject(Coll coll);
	Integer findCollIdByUserId(Integer user_id);
}
