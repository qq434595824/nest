package com.ziyan.service;

import com.ziyan.entity.SysPermissionsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ziyan
 * @email 434595824@qq.com
 * @date 2017-05-09 11:04:36
 */
public interface SysPermissionsService {
	
	SysPermissionsEntity queryObject(Integer id);
	
	List<SysPermissionsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysPermissionsEntity sysPermissions);
	
	void update(SysPermissionsEntity sysPermissions);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
