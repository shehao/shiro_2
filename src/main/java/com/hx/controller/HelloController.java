package com.hx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: shehao
 * @Description:
 * @Date: Created in 2018/1/2  14:46
 */
@Controller
@RequestMapping("/shiro")
public class HelloController {
    @RequestMapping("/gethello")
    public String getHello(){
        return "hello";
    }
}
