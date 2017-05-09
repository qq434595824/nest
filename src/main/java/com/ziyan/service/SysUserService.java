package com.ziyan.service;

import com.ziyan.entity.SysUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ziyan
 * @email 434595824@qq.com
 * @date 2017-05-09 11:04:36
 */
public interface SysUserService {
	
	SysUserEntity queryObject(Integer id);
	
	List<SysUserEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysUserEntity sysUser);
	
	void update(SysUserEntity sysUser);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

    SysUserEntity findByUserName(String username);
}
