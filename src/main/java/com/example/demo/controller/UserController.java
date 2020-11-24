package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.User;
import com.example.demo.service.impl.UserServiceImpl;
import com.example.demo.utils.JsonResponseUtil;
import javafx.geometry.Pos;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@Controller
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    // 添加用户
    @ResponseBody
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public Object addUser(HttpServletRequest request) throws IOException {
        JSONObject body = JSON.parseObject(IOUtils.toString(request.getReader()));
        User user;
        try {
            user = setUserObject(body);
        } catch (Exception e){
            return JsonResponseUtil.error("参数错误");
        }

        user.setCreateTime(new Date());
        if(userService.addUser(user)){
            return JsonResponseUtil.success("注册成功");
        }else {
            return JsonResponseUtil.error("注册失败");
        }
    }

    // 用户登录
    @ResponseBody
    @RequestMapping(value = "/user/login/status", method = RequestMethod.POST)
    public Object loginStatus(HttpServletRequest request, HttpSession session) throws IOException {
        JSONObject body = JSON.parseObject(IOUtils.toString(request.getReader()));
        Object username = body.get("username");
        Object password = body.get("password");
        if (username == null || password == null){
            return JsonResponseUtil.error("参数错误");
        }
        if (userService.verityPassword(username.toString(), password.toString())){
            return JsonResponseUtil.success("登录成功");
        }else {
            return JsonResponseUtil.error("用户名或密码错误");
        }
    }

    // 所有用户
    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    private Object allUser(){
        return userService.allUser();
    }

    // 查找用户
    @ResponseBody
    @RequestMapping(value = "/user/detail", method = RequestMethod.GET)
    public Object userOfId(HttpServletRequest request){
        String id = request.getParameter("id");
        return userService.userOfId(Integer.valueOf(id));
    }

    // 删除用户
    @ResponseBody
    @RequestMapping(value = "/user/delete", method = RequestMethod.GET)
    public Object deleteUser(HttpServletRequest request){
        String id = request.getParameter("id");
        return userService.deleteUser(Integer.valueOf(id));
    }

    // 更新用户信息
    @ResponseBody
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public Object updateUserMsg(HttpServletRequest request) throws IOException {
        JSONObject body = JSON.parseObject(IOUtils.toString(request.getReader()));
        User user;
        try {
            user = setUserObject(body);
        } catch (Exception e){
            return JsonResponseUtil.error("参数错误");
        }
        if (userService.updateUserMsg(user)){
            return JsonResponseUtil.success("修改成功");
        }else{
            return JsonResponseUtil.error("更新失败");
        }
    }

    // 更新用户头像
    @ResponseBody
    @RequestMapping(value = "/user/avatar/update", method = RequestMethod.POST)
    public Object updateUserPic(@RequestParam("file")MultipartFile avatarFile, @RequestParam("id") int id){
        if (avatarFile.isEmpty()){
            return JsonResponseUtil.error("文件上传失败");
        }
        String fileName = System.currentTimeMillis() + avatarFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img" + System.getProperty("file.separator") + "avatarImages" + System.getProperty("file.separator");
        File file = new File(filePath);
        if (!file.exists()){
            file.mkdir();
        }
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String storeAvatarPath = "/avatarImages/"+ fileName;
        try {
            avatarFile.transferTo(dest);
            User user = new User();
            user.setId(id);
            user.setAvator(storeAvatarPath);
            if (userService.updateUserAvatar(user)){
                return JsonResponseUtil.uploadSuccess(storeAvatarPath, "上传成功");
            }else {
                return JsonResponseUtil.error("上传失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return JsonResponseUtil.error("文件上传失败");
        }
    }

    private User setUserObject(JSONObject body){
        User user = new User();
        String username = body.get("username").toString().trim();
        user.setUsername(username);
        String password = body.get("password").toString().trim();
        user.setPassword(password);

        String sex = body.get("sex").toString().trim();
        user.setSex(Byte.valueOf(sex));

        Object id = body.get("id");
        if (id != null){
            user.setId(Integer.valueOf(id.toString()));
        }

        String birth = body.get("birth").toString().trim();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myBirth = new Date();
        try {
            myBirth = dateFormat.parse(birth);
        } catch (Exception e){
            e.printStackTrace();
        }
        user.setBirth(myBirth);
        Object phoneNum = body.get("phoneNum");
        if (phoneNum != null){
            user.setPhoneNum(phoneNum.toString().trim());
        }
        Object introduction = body.get("introduction");
        if (introduction != null){
            user.setIntroduction(introduction.toString().trim());
        }
        Object location = body.get("location");
        if (location != null){
            user.setLocation(location.toString().trim());
        }
        Object avatar = body.get("avatar");
        if (avatar != null){
            user.setAvator(avatar.toString().trim());
        }
        Object email = body.get("email");
        if (email != null){
            user.setEmail(email.toString().trim());
        }
        user.setUpdateTime(new Date());
        return user;
    }

}
