package com.itheima.controller;

import com.itheima.domain.PageBean;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    //设置允许上传的文件类型
    private String[] allowType={"image/jpeg","image/png"};

    @Autowired
    private UserService service;

    @RequestMapping("/login")
    public String login(Integer ck, HttpSession session, HttpServletResponse resp, User user) throws Exception {
        User u = service.login(user);
        int i = 10/0;
        if(u==null){//输入用户名和密码在数据库中不存在，登陆失败
            return "loginError";
        }
        Cookie cookiename = new Cookie("username",u.getUsername());
        Cookie cookieword = new Cookie("pwd",u.getPwd());

        if(ck != null && ck == 1){
            cookiename.setMaxAge(7*24*60*60);
            cookieword.setMaxAge(7*24*60*60);
        }else{
            cookiename.setMaxAge(0);
            cookieword.setMaxAge(0);
        }
            cookiename.setPath("/");
            cookieword.setPath("/");
            resp.addCookie(cookiename);
            resp.addCookie(cookieword);

        session.setAttribute("user",u);

        return "index1";
    }

    @RequestMapping("/findAll")
    public String findAll(Model model,@RequestParam(name = "currPage",required = false,defaultValue = "1") Integer currPage) throws Exception {
        PageBean pageBean = new PageBean();
        Integer pageSize = 5;
        System.out.println(currPage);
        List<User> list=service.findAll(pageBean,currPage);
        model.addAttribute("userList",list);
        model.addAttribute("pages",pageBean);
        return "list";
    }

    @RequestMapping("/saveUser")
    public String saveUser(HttpServletRequest req,MultipartFile picName,User user) throws Exception {

        System.out.println("文件的类型："+picName.getContentType());
            if (!Arrays.asList(allowType).contains(picName.getContentType())){
                throw new RuntimeException("你上传的文档类型不符合要求");
            }
       //  System.out.println("----:"+user.getPic());
//        String path = req.getSession().getServletContext().getRealPath("/pics/");
//        File file=new File(path);
//        if(!file.exists()){
//            file.mkdirs();
//        }
   //     String fileName=picName.getOriginalFilename();
      //  picName.transferTo(new File(path,fileName));
       // user.setPic(fileName);
        //调用service
        service.saveUser(user);
       return "redirect:/user/findAll";
    }
    @RequestMapping("deleteUser")
    public String deleteUser(Integer id){
        System.out.println(id);
        service.deleteUser(id);
        return "redirect:/user/findAll";
    }
    @RequestMapping("findOne")
    public String findOne(Integer id,Model model){
        User user = service.findOne(id);
        model.addAttribute("user",user);
        return "update";
    }
    @RequestMapping("updateUser")
    public String updateUser(User user){
        service.updateUser(user);
        return "redirect:/user/findAll";
    }
}
