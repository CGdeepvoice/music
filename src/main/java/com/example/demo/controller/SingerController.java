package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.Singer;
import com.example.demo.service.impl.SingerServiceImpl;
import com.example.demo.utils.JsonResponseUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@Controller
public class SingerController {
    private final SingerServiceImpl singerService;

    public SingerController(SingerServiceImpl singerService) {
        this.singerService = singerService;
    }

    // 添加歌手
    @ResponseBody
    @RequestMapping(value="/singer/add", method = RequestMethod.POST)
    public Object addSinger(HttpServletRequest request) throws IOException {
        String string = IOUtils.toString(request.getReader());
        JSONObject body = JSON.parseObject(string);
        Singer singer = setSingerObject(body);
        if (singerService.addSinger(singer)){
            return JsonResponseUtil.success("添加成功");
        } else {
            return JsonResponseUtil.success("添加失败");
        }
    }

    // 更新歌手信息
    @ResponseBody
    @RequestMapping(value = "/singer/update", method = RequestMethod.POST)
    public Object updateSingerMsg(HttpServletRequest request) throws IOException {
        JSONObject body = JSON.parseObject(IOUtils.toString(request.getReader()));
        Singer singer = setSingerObject(body);
        if (singerService.updateSingerMsg(singer)){
            return JsonResponseUtil.success("修改成功");
        } else {
            return JsonResponseUtil.error("修改失败");
        }
    }

    // 上传歌手头像
    @ResponseBody
    @RequestMapping(value = "/singer/avatar/update", method = RequestMethod.POST)
    public Object updateSingerPic(@RequestParam("file")MultipartFile avatarFile, @RequestParam("id")int id){
        if (avatarFile.isEmpty()){
            return JsonResponseUtil.error("上传失败");
        }
        String fileName = System.currentTimeMillis() + avatarFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img" + System.getProperty("file.separator") + "singerPic" ;
        File file = new File(filePath);
        if (!file.exists()){
            file.mkdir();
        }
        System.out.println(filePath+System.getProperty("file.separator")+fileName);
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        String storeAvatarPath = "/img/singerPic/"+fileName;
        System.out.println(storeAvatarPath);
        try {
            avatarFile.transferTo(dest);
            Singer singer = new Singer();
            singer.setId(id);
            singer.setPic(storeAvatarPath);
            boolean res = singerService.updateSingerPic(singer);
            if (res){
                return JsonResponseUtil.uploadSuccess(storeAvatarPath, "上传成功");
            }else{
                return JsonResponseUtil.error("上传失败");
            }
        } catch (IOException e){
            return JsonResponseUtil.error("上传失败" + e.getMessage());
        }
    }

    // 根据姓名获取歌手
    @ResponseBody
    @RequestMapping(value = "/singer/name/detail", method = RequestMethod.GET)
    public Object singerOfName(HttpServletRequest request){
        String name = request.getParameter("name").trim();
        return singerService.singerOfName(name);
    }

    // 根据性别获取歌手
    @ResponseBody
    @RequestMapping(value = "/singer/sex/detail", method = RequestMethod.GET)
    public Object singerOfSex(HttpServletRequest request){
        String sex = request.getParameter("sex").trim();
        return singerService.singOfSex(Integer.valueOf(sex));
    }

    // 获取所有歌手
    @ResponseBody
    @RequestMapping(value = "/singer", method = RequestMethod.GET)
    public Object allSinger(HttpServletRequest request){
        return singerService.allSinger();
    }

    // 删除歌手
    @ResponseBody
    @RequestMapping(value = "/singer/delete", method = RequestMethod.GET)
    public Object deleteSinger(HttpServletRequest request){
        String id = request.getParameter("id").trim();
        return singerService.deleteSinger(Integer.valueOf(id));
    }

    private Singer setSingerObject(JSONObject body){
        Singer singer = new Singer();
        String name = body.get("name").toString().trim();
        String sex = body.get("sex").toString().trim();
        String pic = body.get("pic").toString().trim();
        String birth = body.get("birth").toString().trim();
        String location = body.get("location").toString().trim();
        String introduction = body.get("introduction").toString().trim();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myBirth = new Date();
        try {
            myBirth = dateFormat.parse(birth);
        } catch (Exception e){
            e.printStackTrace();
        }
        singer.setName(name);
        singer.setSex(Byte.valueOf(sex));
        singer.setPic(pic);
        singer.setBirth(myBirth);
        singer.setLocation(location);
        singer.setIntroduction(introduction);
        return singer;
    }
}
