package com.ziyan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ziyan.entity.SysUserEntity;
import com.ziyan.service.SysUserService;
import com.ziyan.utils.PageUtils;


/**
 * 
 * 
 * @author ziyan
 * @email 434595824@qq.com
 * @date 2017-05-09 11:04:36
 */
@Controller
@RequestMapping("sysuser")
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;
	
	@GetMapping("/sysuser.html")
	public String list(){
		return "html/sysuser.html";
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sysuser:list")
	@ApiOperation(value="获取列表信息", notes="根据提交的页数跟每页的数据限制数")
	public ResponseEntity<PageUtils> list(@RequestParam(required = false) Integer page,
										  @RequestParam(required = false) Integer limit){
		Map<String, Object> map = new HashMap<String, Object>();
		if (page != null && limit != null) {
			map.put("offset", (page - 1) * limit);
			map.put("limit", limit);
		}
		
		//查询列表数据
		List<SysUserEntity> sysUserList = sysUserService.queryList(map);
		int total = sysUserService.queryTotal(map);
		if (page == null || limit == null) {
			limit = 1;
			page = total;
		}

		PageUtils pageUtil = new PageUtils(sysUserList, total, limit, page);
		
		return ResponseEntity.ok(pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@GetMapping("/info/{id}")
	@RequiresPermissions("sysuser:info")
	@ApiOperation(value="获取单个记录信息")
	public ResponseEntity<SysUserEntity> info(@PathVariable("id") Integer id){
		SysUserEntity sysUser = sysUserService.queryObject(id);

        return ResponseEntity.ok(sysUser);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sysuser:save")
	@ApiOperation(value="保存单个记录信息")
	public ResponseEntity<Void> save(@RequestBody SysUserEntity sysUser){
		sysUserService.save(sysUser);

        return ResponseEntity.ok(null);
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@PostMapping("/update")
	@RequiresPermissions("sysuser:update")
	@ApiOperation(value="更新单个记录信息")
	public ResponseEntity<Void> update(@RequestBody SysUserEntity sysUser){
		sysUserService.update(sysUser);

        return ResponseEntity.ok(null);
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@DeleteMapping("/delete")
	@RequiresPermissions("sysuser:delete")
	@ApiOperation(value="删除单个记录信息")
	public ResponseEntity<Void> delete(@RequestBody Integer[] ids){
		sysUserService.deleteBatch(ids);

        return ResponseEntity.ok(null);
	}
	
}
