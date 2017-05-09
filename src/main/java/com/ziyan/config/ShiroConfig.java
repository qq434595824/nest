package com.ziyan.config;

import java.util.LinkedHashMap;
import java.util.Map;

import com.ziyan.shiro.UserRealm;
import com.ziyan.utils.SpringContextUtils;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;

/**
 * Shiro配置
 * @author ziyan
 */
//@Configuration
public class ShiroConfig {

    private static Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
    // Shiro缓存
    //    @Bean(name = "shiroEhcacheManager")
//    public EhCacheManager getEhCacheManager() {
//        EhCacheManager em = new EhCacheManager();
//        em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
//        return em;
//    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

    /**
     * Shiro默认会使用Servlet容器的Session,可通过sessionMode属性来指定使用Shiro原生Session -->
     * 即<property name="sessionMode" value="native"/>,详细说明见官方文档 -->
     * 这里主要是设置自定义的单Realm应用,若有多个Realm,可使用'realms'属性代替 -->
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {
        DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
        UserRealm userRealm = (UserRealm) SpringContextUtils.getBean("userRealm");
        dwsm.setRealm(userRealm);
//        dwsm.setCacheManager(getEhCacheManager());
        return dwsm;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
        aasa.setSecurityManager(getDefaultWebSecurityManager());
        return new AuthorizationAttributeSourceAdvisor();
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean
                .setSecurityManager(getDefaultWebSecurityManager());
        // 登录时的链接(默认"/login.html")
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        // 登录成功后跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index.html");
        // 用户访问未对其授权的资源时,所显示的连接
        shiroFilterFactoryBean.setUnauthorizedUrl("/");
        // Shiro连接约束配置,即过滤链的定义
        filterChainDefinitionMap.put("/statics/**", "anon");
        filterChainDefinitionMap.put("/**", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

}