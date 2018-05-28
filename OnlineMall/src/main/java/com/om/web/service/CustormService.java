package com.om.web.service;

import com.om.common.vo.PageObject;
import com.om.web.entity.Custorm;

public interface CustormService {
	PageObject<Custorm> findPageObjects(Integer admin_id,Integer pageCurrent);
	int deleteObject(Integer[] ids);
	
	
	int saveObject(Custorm entity);
}
