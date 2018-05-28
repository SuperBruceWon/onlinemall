package com.om.web.dao;

import com.om.web.entity.Cart;

public interface CartDao {
	
	int insertObject(Cart cart);
	Integer findCartIdByUserId(Integer user_id);
}
