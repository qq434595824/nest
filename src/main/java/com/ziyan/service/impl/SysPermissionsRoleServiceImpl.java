package com.ziyan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ziyan.dao.SysPermissionsRoleDao;
import com.ziyan.entity.SysPermissionsRoleEntity;
import com.ziyan.service.SysPermissionsRoleService;



@Service("sysPermissionsRoleService")
public class SysPermissionsRoleServiceImpl implements SysPermissionsRoleService {
	@Autowired
	private SysPermissionsRoleDao sysPermissionsRoleDao;
	
	@Override
	public SysPermissionsRoleEntity queryObject(Integer id){
		return sysPermissionsRoleDao.queryObject(id);
	}
	
	@Override
	public List<SysPermissionsRoleEntity> queryList(Map<String, Object> map){
		return sysPermissionsRoleDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysPermissionsRoleDao.queryTotal(map);
	}
	
	@Override
	public void save(SysPermissionsRoleEntity sysPermissionsRole){
		sysPermissionsRoleDao.save(sysPermissionsRole);
	}
	
	@Override
	public void update(SysPermissionsRoleEntity sysPermissionsRole){
		sysPermissionsRoleDao.update(sysPermissionsRole);
	}
	
	@Override
	public void delete(Integer id){
		sysPermissionsRoleDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		sysPermissionsRoleDao.deleteBatch(ids);
	}
	
}
