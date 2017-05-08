package com.ziyan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ziyan.dao.SysUserDao;
import com.ziyan.entity.SysUserEntity;
import com.ziyan.service.SysUserService;



@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserDao sysUserDao;
	
	@Override
	public SysUserEntity queryObject(Integer id){
		return sysUserDao.queryObject(id);
	}
	
	@Override
	public List<SysUserEntity> queryList(Map<String, Object> map){
		return sysUserDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysUserDao.queryTotal(map);
	}
	
	@Override
	public void save(SysUserEntity sysUser){
		sysUserDao.save(sysUser);
	}
	
	@Override
	public void update(SysUserEntity sysUser){
		sysUserDao.update(sysUser);
	}
	
	@Override
	public void delete(Integer id){
		sysUserDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		sysUserDao.deleteBatch(ids);
	}
	
}
