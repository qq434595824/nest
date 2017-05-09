package com.ziyan.dao;

import com.ziyan.entity.SysUserEntity;

/**
 * 
 * 
 * @author ziyan
 * @email 434595824@qq.com
 * @date 2017-05-09 11:04:36
 */
public interface SysUserDao extends BaseDao<SysUserEntity> {

    SysUserEntity findByUserName(String username);
}
