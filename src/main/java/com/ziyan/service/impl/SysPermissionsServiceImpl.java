package com.ziyan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ziyan.dao.SysPermissionsDao;
import com.ziyan.entity.SysPermissionsEntity;
import com.ziyan.service.SysPermissionsService;



@Service("sysPermissionsService")
public class SysPermissionsServiceImpl implements SysPermissionsService {
	@Autowired
	private SysPermissionsDao sysPermissionsDao;
	
	@Override
	public SysPermissionsEntity queryObject(Integer id){
		return sysPermissionsDao.queryObject(id);
	}
	
	@Override
	public List<SysPermissionsEntity> queryList(Map<String, Object> map){
		return sysPermissionsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysPermissionsDao.queryTotal(map);
	}
	
	@Override
	public void save(SysPermissionsEntity sysPermissions){
		sysPermissionsDao.save(sysPermissions);
	}
	
	@Override
	public void update(SysPermissionsEntity sysPermissions){
		sysPermissionsDao.update(sysPermissions);
	}
	
	@Override
	public void delete(Integer id){
		sysPermissionsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		sysPermissionsDao.deleteBatch(ids);
	}
	
}
