package com.ziyan.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

/**
 * @author ziyan
 * @email zhengmengyan@taoqicar.com
 * @date 2017/5/24
 */
@RestController
@RequestMapping("/redis")
public class RedisTestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/put")
    public Boolean putData(String key, String value) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set(key, value);
        return true;
    }
    @GetMapping("/get")
    public String getData(String key) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    @GetMapping("/exists")
    public Boolean isExists(String key) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        return !StringUtils.isBlank(operations.get(key));
    }

    @DeleteMapping("/remove")
    public Boolean remove(String key, String value) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set(key,null);
        return true;
    }
}
