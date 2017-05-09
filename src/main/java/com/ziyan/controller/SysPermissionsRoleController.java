package com.ziyan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ziyan.entity.SysPermissionsRoleEntity;
import com.ziyan.service.SysPermissionsRoleService;
import com.ziyan.utils.PageUtils;


/**
 * 
 * 
 * @author ziyan
 * @email 434595824@qq.com
 * @date 2017-05-09 11:04:36
 */
@Controller
@RequestMapping("syspermissionsrole")
public class SysPermissionsRoleController {
	@Autowired
	private SysPermissionsRoleService sysPermissionsRoleService;
	
	@GetMapping("/syspermissionsrole.html")
	public String list(){
		return "syspermissionsrole/syspermissionsrole.html";
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("syspermissionsrole:list")
	@ApiOperation(value="获取列表信息", notes="根据提交的页数跟每页的数据限制数")
	public ResponseEntity<PageUtils> list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		
		//查询列表数据
		List<SysPermissionsRoleEntity> sysPermissionsRoleList = sysPermissionsRoleService.queryList(map);
		int total = sysPermissionsRoleService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(sysPermissionsRoleList, total, limit, page);
		
		return ResponseEntity.ok(pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@GetMapping("/info/{id}")
	@RequiresPermissions("syspermissionsrole:info")
	@ApiOperation(value="获取单个记录信息")
	public ResponseEntity<SysPermissionsRoleEntity> info(@PathVariable("id") Integer id){
		SysPermissionsRoleEntity sysPermissionsRole = sysPermissionsRoleService.queryObject(id);

        return ResponseEntity.ok(sysPermissionsRole);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("syspermissionsrole:save")
	@ApiOperation(value="保存单个记录信息")
	public ResponseEntity<Void> save(@RequestBody SysPermissionsRoleEntity sysPermissionsRole){
		sysPermissionsRoleService.save(sysPermissionsRole);

        return ResponseEntity.ok(null);
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@PostMapping("/update")
	@RequiresPermissions("syspermissionsrole:update")
	@ApiOperation(value="更新单个记录信息")
	public ResponseEntity<Void> update(@RequestBody SysPermissionsRoleEntity sysPermissionsRole){
		sysPermissionsRoleService.update(sysPermissionsRole);

        return ResponseEntity.ok(null);
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@DeleteMapping("/delete")
	@RequiresPermissions("syspermissionsrole:delete")
	@ApiOperation(value="删除单个记录信息")
	public ResponseEntity<Void> delete(@RequestBody Integer[] ids){
		sysPermissionsRoleService.deleteBatch(ids);

        return ResponseEntity.ok(null);
	}
	
}