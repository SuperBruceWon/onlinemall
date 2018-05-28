package com.om.web.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.om.common.exception.ServiceException;
import com.om.common.vo.PageObject;
import com.om.web.dao.CustormDao;
import com.om.web.entity.Custorm;
import com.om.web.service.CustormService;


@Service
public class CustormServiceImpl implements CustormService{
	@Autowired
	private CustormDao custormDao;

	
	@Override
	public int saveObject(Custorm entity) {
		System.out.println(entity);
		//1.合法验证
		if(entity==null) throw new IllegalArgumentException("保存对象不能为空");
		int rows;
		try {
			rows=custormDao.insertObject(entity);
		}catch(Throwable e) {
			e.printStackTrace();
			throw new ServiceException("系统故障处理中....");
		}	
		return rows;
	}
	
	
	@Override
	public PageObject<Custorm> findPageObjects(Integer admin_id, Integer pageCurrent) {
		// 1.验证pageCurrent合法性（不合法抛出异常），查询总记录数
		if(pageCurrent==null||pageCurrent<1) {
			//	return null;
			throw new IllegalArgumentException("当前页面不合法");
		}		
		//1.1）执行查询，验证查询结果，假如为0不再执行如下操作
		int rowCount = custormDao.getRowCount(admin_id);
		if(rowCount==0) {
			return null;
		}
		//2.查询当前页记录（pageSize定义为2）
		int pageSize=2;		
		//2.1）计算startIndex
		int startIndex=(pageCurrent-1)*pageSize;
		//2.2）执行当前页数据的查询操作
		List<Custorm> list = custormDao.findPageObject(admin_id, startIndex, pageSize);
		//3.分页信息以及当前页记录进行封装
		//3.1）构建Object对象
		PageObject<Custorm> pageObject=new PageObject<>();
		//3.2）封装数据
		System.out.println();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setRecords(list);
		//4.返回封装结果
		return pageObject;
	}
	@Override
	public int deleteObject(Integer[] ids) {
		//1.判断参数合法性
		System.out.println(Arrays.toString(ids));
		if(StringUtils.isEmpty(ids)) { 
			throw new IllegalArgumentException("请至少选择一个进行删除");
		}
		//2.将参数装换成数组
	//	String[] idArray=ids.split(",");
		//3.执行删除操作
		int rows;
		try{
			rows = custormDao.deleteObject(ids);
		}catch(Throwable e) {
			throw new ServiceException("系统故障处理中....");
		}
		//4.对结果进行验证
		if(rows==0) throw new ServiceException("记录已经不存在");
		//5.返回结果
		return rows;
	}

}
