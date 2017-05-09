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
public class SysRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//角色描述
	private String name;

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
	 * 设置：角色描述
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：角色描述
	 */
	public String getName() {
		return name;
	}
}
