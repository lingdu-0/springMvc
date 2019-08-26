package com.wb.controller;

import com.wb.vo.LoginReq;
import com.wb.vo.LoginResp;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.commons.fileupload.util.mime.MimeUtility;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("login")
    @ResponseBody
    public LoginResp login(@RequestBody LoginReq loginReq, HttpSession session) {//接收前台传递的json数据和返回前台json数据
        LoginResp loginResp = new LoginResp();
        if ("admin".equals(loginReq.getName()) && "123".equals(loginReq.getPassword())) {
            loginResp.setMsgResult(true);
            loginResp.setMsg("登录成功!");
            session.setAttribute("loginReq", loginReq);
        } else {
            loginResp.setMsgResult(false);
            loginResp.setMsg("用户名或密码错误!");
        }
        return loginResp;
    }

    @RequestMapping("/login2.do")//
    public String login2() {
        return "login";
    }

    @RequestMapping("rest/{id}/order/{oid}")//路径参数restful
    public String rest(@PathVariable int id, @PathVariable String oid) {
        System.out.println(id + "--------" + oid);
        return null;
    }

    @RequestMapping("upload")//文件上传
    public String upload(@RequestParam MultipartFile[] files, HttpServletRequest request) {
        String dir = request.getServletContext().getRealPath("/upload");
        System.out.println(dir);
        for (MultipartFile multipartFile : files) {
            File file = new File(dir + "/" + multipartFile.getOriginalFilename());
            try {
                multipartFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @RequestMapping("download")//文件下载
    public String download(String filename, HttpServletRequest request, HttpServletResponse response) {
        String fileName = null;
        String dir = request.getServletContext().getRealPath("/upload/");
        response.setContentType("application/octet-stream");//浏览器弹出下载框
        try {//设置下载名字中文乱码!
            String userAgentString = request.getHeader("User-Agent");
            String browser = UserAgent.parseUserAgentString(userAgentString).getBrowser().getGroup().getName();
            if (browser.equals("Chrome") || browser.equals("Internet Exploer") || browser.equals("Safari")) {
                fileName = URLEncoder.encode(filename, "utf-8").replaceAll("\\+", "%20");
            } else {
                fileName = MimeUtility.decodeText(filename);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);// 设置下载文件名字
        try {
            IOUtils.copy(new FileInputStream(dir + filename), response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("login3")
    public String login2(HttpServletRequest request) {//国际化
        int i = 1 / 0;
        RequestContext requestContext = new RequestContext(request);
        System.out.println(requestContext.getMessage("login.msg", new String[]{"卢本伟"}));
        return "index";
    }

    @RequestMapping("cookie")
    public String cookie(HttpServletResponse response) {
        //种cookie
        Cookie cookie = new Cookie("name", "wb");
        response.addCookie(cookie);
        return null;
    }
}
