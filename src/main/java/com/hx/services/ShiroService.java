package com.hx.services;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import java.util.Date;

/**
 * @Author: shehao
 * @Description:
 * @Date: Created in 2018/1/11  10:50
 */
public class ShiroService {
    /*
    * 权限的值为字符串数组
    * */
    //@RequiresRoles({"admin"})
    public void testMethod(){
        Session session = SecurityUtils.getSubject().getSession();
        Object test = session.getAttribute("test");
        System.out.println("+++++++++++++++++++"+test);
        System.out.println(new Date());
    }
}
