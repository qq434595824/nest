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
public class SysPermissionsRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer pid;
	//
	private Integer rid;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 获取：
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * 设置：
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	/**
	 * 获取：
	 */
	public Integer getRid() {
		return rid;
	}
}
