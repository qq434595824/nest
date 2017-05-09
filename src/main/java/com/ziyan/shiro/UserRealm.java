package com.ziyan.shiro;

import com.ziyan.entity.SysUserEntity;
import com.ziyan.errors.ErrorCode;
import com.ziyan.errors.NestException;
import com.ziyan.service.SysUserService;
import com.ziyan.utils.SpringContextUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 认证
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

//    @Autowired
//    private SysMenuService sysMenuService;

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUserEntity user = (SysUserEntity) principals.getPrimaryPrincipal();
//		Long userId = user.getUserId();

        List<String> permsList = null;

        //系统管理员，拥有最高权限
//		if(userId == 1){
//			List<SysMenuEntity> menuList = sysMenuService.queryList(new HashMap<String, Object>());
//			permsList = new ArrayList<SysMenuEntity>(menuList.size());
//			for(SysMenuEntity menu : menuList){
//				permsList.add(menu.getPerms());
//			}
//		}else{
//			permsList = sysUserService.queryAllPerms(userId);
//		}

        //用户权限列表
        Set<String> permsSet = new HashSet<String>();
        for (String perms : permsList) {
            if (StringUtils.isBlank(perms)) {
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        //查询用户信息
        SysUserEntity user = sysUserService.findByUserName(username);

        //账号不存在
        if (user == null) {
            throw new NestException(ErrorCode.pwd_check_failed);
        }

        //密码错误
        if (!password.equals(user.getPassword())) {
            throw new NestException(ErrorCode.pwd_check_failed);
        }

        //账号锁定
        if (user.getStatus() == 1) {
            throw new NestException(ErrorCode.locked_user);
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }

}
