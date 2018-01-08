package com.hx.controller.file;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: shehao
 * @Description:
 * @Date: Created in 2018/1/3  18:53
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {
    private static Logger logger= LoggerFactory.getLogger(FileUploadController.class);
    @RequestMapping("/getfile")
    public String first(){
        return "file";
    }

    @RequestMapping("/getNewFile")
    public String getNewFile(){
        return "newFile";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public void upload(HttpServletRequest request, HttpServletResponse response){
        //为上传的文件创建一个文件夹存放
       // String  savePath=request.getServletContext().getRealPath("/upload");
        String savePath="C:\\Users\\Administrator\\Desktop\\filehandle";
        logger.info("savePath================{}",savePath);
        //文件夹存在就不创建,不存在就创建
        File file=new File(savePath);
        if(!file.exists()&&!file.isDirectory()){//创建文件夹
            file.mkdir();
        }
        try{
            //使用apache上传文件的步骤
            //1.创建一个DiskFileItemFactory
            DiskFileItemFactory factory=new DiskFileItemFactory();
            //2.创建一个文件上传解析器
            ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
                //解决中文乱码问题
            servletFileUpload.setHeaderEncoding("UTF-8");
            //3.判断提交过来的数据是否是表单提交的数据
            if(!ServletFileUpload.isMultipartContent(request)){
                return;//不是直接结束
            }
            //4.使用ServletFileUpload解析上传的数据,解析的结果返回的是一个List<FileItem>,每个FileItem对应一个from表单的输入项
            List<FileItem> fileItems = servletFileUpload.parseRequest(request);
            for(FileItem fileItem:fileItems){
                //如果对应的是普通的输入项
                if(fileItem.isFormField()){
                    String name=fileItem.getFieldName();
                    logger.info("fileItem.getName========={}",name);
                    String content = fileItem.getString("UTF-8");
                    logger.info("fileItem.content========={}",content);
                }else{
                 //上传的是文件
                    String fieldName = fileItem.getName();
                    logger.info("上传的文件名========={}",fieldName);
                    if(fieldName==null||"".equals(fieldName.trim())){
                        continue;
                    }
                    //处理文件名:因为不同的浏览器获取到的文件名字不一样
                    fieldName=fieldName.substring(fieldName.lastIndexOf("\\")+1);
                    //获取fileItem中的上传文件输入流
                    InputStream inputStream = fileItem.getInputStream();
                    //创建一个文件输出流
                    FileOutputStream fileOutputStream=new FileOutputStream(savePath+"\\"+fieldName);
                    //创建缓冲区
                    byte[] buffer=new byte[1024];
                    //判断输入流中的数据是否已经读完
                    int flag=0;
                    //循环将输入流读取到缓冲区中
                    while ((flag=inputStream.read(buffer))>0){
                        //使用输出流将读取文件到指定的savePath+"\\"+fileName中
                        fileOutputStream.write(buffer,0,flag);
                    }
                    //关闭输入流
                    inputStream.close();
                    //关闭输出流
                    fileOutputStream.close();

                }
            }

        }catch (Exception e ){
            logger.info("文件上传失败{}",e);
        }



    }

}
