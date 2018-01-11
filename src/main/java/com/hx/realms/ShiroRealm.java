package com.hx.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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
        //从PrincipalCollection获取userinfo的信息
        Object primaryPrincipal = principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set roleSet=new HashSet();
        roleSet.add("user");
        if("admin".equals(primaryPrincipal)){
            roleSet.add("admin");
        }
        simpleAuthorizationInfo.setRoles(roleSet);
        // principals.
        System.out.println("ShiroRealm==============================doGetAuthorizationInfo");
        return simpleAuthorizationInfo;
    }

    /**
     * 验证用户是否可以登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("==========================ShiroRealm");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        //尽心加密计算时一定不能调用toString();
        Object password=token.getPassword();
        //Object password=token.getPassword().toString();
        //根据用户名进行查找用户的信息
        System.out.println("用户信息--------------"+username);
        if("unkonwn".equals(username)){
            throw new UnknownAccountException("用户不存在");
        //根据实际情况判断用户账号的其他状态被锁定等
        }else if ("monster".equals(username)){
            throw new LockedAccountException("账号被锁定");
        }
        //将用户的账号作为盐进行加密计算
        ByteSource credentialsSalt=ByteSource.Util.bytes(username);
        //使用MD5方式进行对密码进行加密 盐值为账号username 加密次数1024次和shiro.xml中配置的加密次数一样
        SimpleHash simpleHash = new SimpleHash("MD5", password, credentialsSalt, 1024);
        //SimpleAuthenticationInfo(Object principal, Object hashedCredentials, ByteSource credentialsSalt, String realmName)
        return new SimpleAuthenticationInfo(username,simpleHash.toHex(),credentialsSalt,ShiroRealm.class.getName());
    }

    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, "123", null, 1024);
        String s = simpleHash.toHex();
        System.out.println(s);
        int len = 3;
        int i = 3 & 5;
        System.out.println(i);
        if((len & 1) != 0) {}
        System.out.println("sueec");
        // String
    }
}
