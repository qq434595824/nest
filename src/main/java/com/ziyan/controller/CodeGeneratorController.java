package com.ziyan.controller;

import com.alibaba.fastjson.JSON;
import com.ziyan.service.CodeGeneratorService;
import com.ziyan.utils.PageUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月19日 下午9:12:58
 */
@Controller
@RequestMapping("/codegenerator")
public class CodeGeneratorController {
    @Autowired
    private CodeGeneratorService codeGeneratorService;

    /**
     * 列表
     */
    @ResponseBody
    @GetMapping("/list")
    public ResponseEntity<PageUtils> list(@RequestParam(required = false) String tableName,
                                          @RequestParam(required = false) Integer page,
                                          @RequestParam(required = false) Integer limit) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (!StringUtils.isBlank(tableName))
            map.put("tableName", tableName);
        if (page != null && limit != null) {
            map.put("offset", (page - 1) * limit);
            map.put("limit", limit);
        }

        // 查询列表数据
        List<Map<String, Object>> list = codeGeneratorService.queryList(map);
        int total = codeGeneratorService.queryTotal(map);
        if (page == null || limit == null){
            page = 0;
            limit = list.size();
        }
        PageUtils pageUtil = new PageUtils(list, total, limit, page);

        return ResponseEntity.ok(pageUtil);
    }

    /**
     * 生成代码
     */
    @GetMapping("/code")
    public void code(@RequestParam String tables, HttpServletResponse response) throws IOException {
        String[] tableNames = new String[]{};
        tableNames = JSON.parseArray(tables).toArray(tableNames);

        byte[] data = codeGeneratorService.generatorCode(tableNames);

        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"openBoot.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());
    }
}
