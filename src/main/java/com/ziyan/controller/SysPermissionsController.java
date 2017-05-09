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

import com.ziyan.entity.SysPermissionsEntity;
import com.ziyan.service.SysPermissionsService;
import com.ziyan.utils.PageUtils;


/**
 * 
 * 
 * @author ziyan
 * @email 434595824@qq.com
 * @date 2017-05-09 11:04:36
 */
@Controller
@RequestMapping("syspermissions")
public class SysPermissionsController {
	@Autowired
	private SysPermissionsService sysPermissionsService;
	
	@GetMapping("/syspermissions.html")
	public String list(){
		return "syspermissions/syspermissions.html";
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("syspermissions:list")
	@ApiOperation(value="获取列表信息", notes="根据提交的页数跟每页的数据限制数")
	public ResponseEntity<PageUtils> list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		
		//查询列表数据
		List<SysPermissionsEntity> sysPermissionsList = sysPermissionsService.queryList(map);
		int total = sysPermissionsService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(sysPermissionsList, total, limit, page);
		
		return ResponseEntity.ok(pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@GetMapping("/info/{id}")
	@RequiresPermissions("syspermissions:info")
	@ApiOperation(value="获取单个记录信息")
	public ResponseEntity<SysPermissionsEntity> info(@PathVariable("id") Integer id){
		SysPermissionsEntity sysPermissions = sysPermissionsService.queryObject(id);

        return ResponseEntity.ok(sysPermissions);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("syspermissions:save")
	@ApiOperation(value="保存单个记录信息")
	public ResponseEntity<Void> save(@RequestBody SysPermissionsEntity sysPermissions){
		sysPermissionsService.save(sysPermissions);

        return ResponseEntity.ok(null);
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@PostMapping("/update")
	@RequiresPermissions("syspermissions:update")
	@ApiOperation(value="更新单个记录信息")
	public ResponseEntity<Void> update(@RequestBody SysPermissionsEntity sysPermissions){
		sysPermissionsService.update(sysPermissions);

        return ResponseEntity.ok(null);
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@DeleteMapping("/delete")
	@RequiresPermissions("syspermissions:delete")
	@ApiOperation(value="删除单个记录信息")
	public ResponseEntity<Void> delete(@RequestBody Integer[] ids){
		sysPermissionsService.deleteBatch(ids);

        return ResponseEntity.ok(null);
	}
	
}
