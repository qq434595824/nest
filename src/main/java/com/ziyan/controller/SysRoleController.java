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

import com.ziyan.entity.SysRoleEntity;
import com.ziyan.service.SysRoleService;
import com.ziyan.utils.PageUtils;


/**
 * 
 * 
 * @author ziyan
 * @email 434595824@qq.com
 * @date 2017-05-09 11:04:36
 */
@Controller
@RequestMapping("sysrole")
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;
	
	@GetMapping("/sysrole.html")
	public String list(){
		return "sysrole/sysrole.html";
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sysrole:list")
	@ApiOperation(value="获取列表信息", notes="根据提交的页数跟每页的数据限制数")
	public ResponseEntity<PageUtils> list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		
		//查询列表数据
		List<SysRoleEntity> sysRoleList = sysRoleService.queryList(map);
		int total = sysRoleService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(sysRoleList, total, limit, page);
		
		return ResponseEntity.ok(pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@GetMapping("/info/{id}")
	@RequiresPermissions("sysrole:info")
	@ApiOperation(value="获取单个记录信息")
	public ResponseEntity<SysRoleEntity> info(@PathVariable("id") Integer id){
		SysRoleEntity sysRole = sysRoleService.queryObject(id);

        return ResponseEntity.ok(sysRole);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sysrole:save")
	@ApiOperation(value="保存单个记录信息")
	public ResponseEntity<Void> save(@RequestBody SysRoleEntity sysRole){
		sysRoleService.save(sysRole);

        return ResponseEntity.ok(null);
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@PostMapping("/update")
	@RequiresPermissions("sysrole:update")
	@ApiOperation(value="更新单个记录信息")
	public ResponseEntity<Void> update(@RequestBody SysRoleEntity sysRole){
		sysRoleService.update(sysRole);

        return ResponseEntity.ok(null);
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@DeleteMapping("/delete")
	@RequiresPermissions("sysrole:delete")
	@ApiOperation(value="删除单个记录信息")
	public ResponseEntity<Void> delete(@RequestBody Integer[] ids){
		sysRoleService.deleteBatch(ids);

        return ResponseEntity.ok(null);
	}
	
}
