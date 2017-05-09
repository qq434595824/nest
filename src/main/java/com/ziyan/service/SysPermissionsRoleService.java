package com.ziyan.service;

import com.ziyan.entity.SysPermissionsRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ziyan
 * @email 434595824@qq.com
 * @date 2017-05-09 11:04:36
 */
public interface SysPermissionsRoleService {
	
	SysPermissionsRoleEntity queryObject(Integer id);
	
	List<SysPermissionsRoleEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysPermissionsRoleEntity sysPermissionsRole);
	
	void update(SysPermissionsRoleEntity sysPermissionsRole);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
