package com.itheima.controller;

import com.itheima.service.impl.UserService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;


/**
 * @Author: tch
 * @Date: 2019/2/12 下午 09:55
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/fileUpLoad")
    public String fileUpLoad(HttpServletRequest request) throws Exception{
        //获取要上传到的目录
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        //创建文件对象
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }
        //创建磁盘工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        //解析request对象
        List<FileItem> fileItems = fileUpload.parseRequest(request);
        for (FileItem fileItem : fileItems) {
            if(fileItem.isFormField()){
                //是文本项
            }else{
                //是文件项
                String name = fileItem.getName();
                //上传文件
                fileItem.write(new File(file,name));
                //删除临时文件
                fileItem.delete();
            }
        }
        return "success";
    }
    @RequestMapping("fileUpLoad1")
    public String fileUpLoad1(HttpServletRequest req, MultipartFile upload) throws Exception{
        String realPath = req.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(realPath);

        if(!file.exists()){
            file.mkdirs();
        }
        String originalFilename = upload.getOriginalFilename();
        upload.transferTo(new File(file,originalFilename));

        return "success";
    }
    @RequestMapping("fileUpLoad2")
    public String fileUpLoad2(MultipartFile upload) throws Exception{
        //定义图片服务器请求路径
        String path = "http://localhost:8081/ssm_war_exploded/uploads/";
        String originalFilename = upload.getOriginalFilename();
        //创建客户端对象
        Client client = Client.create();
        //链接图片服务器
        WebResource resource = client.resource(path + originalFilename);
        resource.put(upload.getBytes());
        return "success";
    }
}
