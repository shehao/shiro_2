package com.hx.controller.page;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: shehao
 * @Description:
 * @Date: Created in 2018/1/5  10:34
 */
@Controller
@RequestMapping("/admin")
public class PageController {
    private  static Logger logger= LoggerFactory.getLogger(PageController.class);

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/checkLogin")
    public String checkLogin(@RequestParam String username,@RequestParam String password){
        logger.info("username----password:{},{}",username,password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token= new UsernamePasswordToken(username,password);
        logger.info("token:{}",token.hashCode());
        try{
            subject.login(token);
            logger.info(username+":"+password+"授权成功:{},{}",username,password);
            return "redirect:/success.jsp";
        }catch (AuthenticationException e){
            logger.info(username+":"+password+"授权失败:{},{},{}",username,password,e.getMessage());
            return "redirect:/login.jsp";
        }


    }
}
