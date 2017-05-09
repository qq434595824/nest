package com.ziyan.service;

import com.ziyan.entity.SysUserRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ziyan
 * @email 434595824@qq.com
 * @date 2017-05-09 11:04:36
 */
public interface SysUserRoleService {
	
	SysUserRoleEntity queryObject(Integer id);
	
	List<SysUserRoleEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysUserRoleEntity sysUserRole);
	
	void update(SysUserRoleEntity sysUserRole);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
