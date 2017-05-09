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

import com.ziyan.entity.SysUserRoleEntity;
import com.ziyan.service.SysUserRoleService;
import com.ziyan.utils.PageUtils;


/**
 * @author ziyan
 * @email 434595824@qq.com
 * @date 2017-05-09 11:04:36
 */
@Controller
@RequestMapping("sysuserrole")
public class SysUserRoleController {
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @GetMapping("/sysuserrole.html")
    public String list() {
        return "html/sysuserrole.html";
    }

    /**
     * 列表
     */
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("sysuserrole:list")
    @ApiOperation(value = "获取列表信息", notes = "根据提交的页数跟每页的数据限制数")
    public ResponseEntity<PageUtils> list(@RequestParam(required = false) Integer page,
                                          @RequestParam(required = false) Integer limit) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (page != null && limit != null) {
            map.put("offset", (page - 1) * limit);
            map.put("limit", limit);
        }
        //查询列表数据
        List<SysUserRoleEntity> sysUserRoleList = sysUserRoleService.queryList(map);
        int total = sysUserRoleService.queryTotal(map);
        if (page == null || limit == null) {
            limit = 1;
            page = total;
        }

        PageUtils pageUtil = new PageUtils(sysUserRoleList, total, limit, page);

        return ResponseEntity.ok(pageUtil);
    }


    /**
     * 信息
     */
    @ResponseBody
    @GetMapping("/info/{id}")
    @RequiresPermissions("sysuserrole:info")
    @ApiOperation(value = "获取单个记录信息")
    public ResponseEntity<SysUserRoleEntity> info(@PathVariable("id") Integer id) {
        SysUserRoleEntity sysUserRole = sysUserRoleService.queryObject(id);

        return ResponseEntity.ok(sysUserRole);
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("sysuserrole:save")
    @ApiOperation(value = "保存单个记录信息")
    public ResponseEntity<Void> save(@RequestBody SysUserRoleEntity sysUserRole) {
        sysUserRoleService.save(sysUserRole);

        return ResponseEntity.ok(null);
    }

    /**
     * 修改
     */
    @ResponseBody
    @PostMapping("/update")
    @RequiresPermissions("sysuserrole:update")
    @ApiOperation(value = "更新单个记录信息")
    public ResponseEntity<Void> update(@RequestBody SysUserRoleEntity sysUserRole) {
        sysUserRoleService.update(sysUserRole);

        return ResponseEntity.ok(null);
    }

    /**
     * 删除
     */
    @ResponseBody
    @DeleteMapping("/delete")
    @RequiresPermissions("sysuserrole:delete")
    @ApiOperation(value = "删除单个记录信息")
    public ResponseEntity<Void> delete(@RequestBody Integer[] ids) {
        sysUserRoleService.deleteBatch(ids);

        return ResponseEntity.ok(null);
    }

}
