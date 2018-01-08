package com.hx.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Author: shehao
 * @Description:
 * @Date: Created in 2018/1/2  17:28
 */
public class ShiroRealm extends AuthorizingRealm {
    /**
     * 验证用户是否拥有某种角色
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 验证用户是否可以登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        //根据用户名进行查找用户的信息
        System.out.println("用户信息--------------"+username);
        if("unkonwn".equals(username)){
            throw new UnknownAccountException("用户不存在");
        //根据实际情况判断用户账号的其他状态被锁定等
        }else if ("monster".equals(username)){
            throw new LockedAccountException("账号被锁定");
        }
        return new SimpleAuthenticationInfo(username,token.getPassword(),ShiroRealm.class.getName());
    }
}
