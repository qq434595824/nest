package com.ziyan.config;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@SuppressWarnings("unused")
@Configuration
public class RedisCacheConfiguration {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private int port;
    @Value("${redis.password}")
    private String password;
    @Value("${redis.pool.max-idle}")
    private int maxIdle;
    @Value("${redis.pool.min-idle}")
    private int minIdle;
    @Value("${redis.pool.max-active}")
    private int maxActive;
    @Value("${redis.pool.max-wait}")
    private int maxWait;

    @Bean
    public RedisConnectionFactory jedisConnectionFactory(JedisPoolConfig config) {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        log.warn("redis connect---" + host + " : " + port);
        factory.setHostName(host);
        factory.setPort(port);
        if (StringUtils.isNotEmpty(password))
            factory.setPassword(password);
        factory.setPoolConfig(config);
        factory.afterPropertiesSet();
        return factory;
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxTotal(10);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setMaxWaitMillis(maxWait);
        return poolConfig;
    }


    @Bean(name = "redisTemplate")
    public RedisTemplate redisTemplate(
        RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        JdkSerializationRedisSerializer jdkSerializationRedisSerializer =
            new JdkSerializationRedisSerializer(this.getClass().getClassLoader());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(jdkSerializationRedisSerializer);
        return redisTemplate;
    }

//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
//        /**
//         * 如果不将 cacheName 设置前缀 ,需要自定义KeyGenerator 来解决 默认key太简单导致的问题
//         */
//        cacheManager.setUsePrefix(true);
//        return cacheManager;
//    }


//暂时不需要

//    @Bean
//    public KeyGenerator keyGenerator() {
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object o, Method method, Object... objects) {
//                StringBuilder sb = new StringBuilder();
//                sb.append(o.getClass().getName());
//                sb.append(method.getName());
//                for (Object obj : objects) {
//                    sb.append(obj.toString());
//                }
//                return sb.toString();
//            }
//        };
//    }

}
