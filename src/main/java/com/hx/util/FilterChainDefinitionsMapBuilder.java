package com.hx.util;

import java.util.LinkedHashMap;

/**
 * @Author: shehao
 * @Description:
 * @Date: Created in 2018/1/11  11:27
 * 注意事项:LinkedHashMap 而且添加的顺序是有要求的
 */
public class FilterChainDefinitionsMapBuilder {
    public LinkedHashMap<String,String> buildFilterChainDefinitionsMap(){
        LinkedHashMap<String,String> hashMap=new LinkedHashMap<>();
        hashMap.put("/login.jsp","anon");
        hashMap.put(" /admin/checkLogin","anon");
        hashMap.put("/admin.jsp","roles[admin]");
        hashMap.put("/success.jsp","user,roles[admin]");
        return hashMap;
    }
}
