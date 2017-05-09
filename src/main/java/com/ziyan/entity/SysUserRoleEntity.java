package com.ziyan.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author ziyan
 * @email 434595824@qq.com
 * @date 2017-05-09 11:04:36
 */
public class SysUserRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户ID
	private Integer id;
	//
	private Integer userid;
	//角色id
	private Integer roleid;

	/**
	 * 设置：用户ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：用户ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	/**
	 * 获取：
	 */
	public Integer getUserid() {
		return userid;
	}
	/**
	 * 设置：角色id
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	/**
	 * 获取：角色id
	 */
	public Integer getRoleid() {
		return roleid;
	}
}
