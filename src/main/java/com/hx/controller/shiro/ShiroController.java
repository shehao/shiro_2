package com.hx.controller.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: shehao
 * @Description:
 * @Date: Created in 2018/1/2  17:32
 */
@Controller
@RequestMapping("/shiro")
public class ShiroController {
    @RequestMapping("/login")
    public String login(@RequestParam String username,@RequestParam String password){
        Subject subject = SecurityUtils.getSubject();
        //账号密码还没有验证
        if(!subject.isAuthenticated()){
            //用户身份/凭证封装成对象进行验证
            UsernamePasswordToken token=new UsernamePasswordToken(username,password);
            token.setRememberMe(true);
            try{
                subject.login(token);
                System.out.println("账号验证成功!");
            }catch (AuthenticationException au){
                System.out.println("账号验证失败!");
            }

        }


        return "redirect:second";
    }
}
