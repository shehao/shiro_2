package com.hx.controller.mail;

import java.util.LinkedList;

/**
 * @Author: shehao
 * @Description:
 * @Date: Created in 2018/1/15  10:01
 */
public class MailController {
    public static void main(String[] args) {
       /* LinkedList list=new LinkedList();
        list.add("a");
       // list.add(2,"b");
      //  String s=(String)list.get(1);
       // System.out.println(s);
        System.out.println(""+'a'+1);*/
        System.out.println(cout());
    }

    public  static  int cout(){
        try {
            return 5/0;

        }catch (Exception e){
            return  3*2;
        }finally {
            return 3;
        }
    }

}
