package com.ziyan.service;

import com.ziyan.entity.SysRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ziyan
 * @email 434595824@qq.com
 * @date 2017-05-09 11:04:36
 */
public interface SysRoleService {
	
	SysRoleEntity queryObject(Integer id);
	
	List<SysRoleEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysRoleEntity sysRole);
	
	void update(SysRoleEntity sysRole);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
