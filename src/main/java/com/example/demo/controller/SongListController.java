package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.SongList;
import com.example.demo.service.impl.SongListServiceImpl;
import com.example.demo.utils.JsonResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@Controller
public class SongListController {
    private final SongListServiceImpl service;

    public SongListController(SongListServiceImpl service) {
        this.service = service;
    }

    // 新增歌单
    @ResponseBody
    @RequestMapping(value = "/songList/add", method = RequestMethod.POST)
    public Object addSongList(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        String title = req.getParameter("title").trim();
        String pic = req.getParameter("pic").trim();
        String introduction = req.getParameter("introduction").trim();
        String style = req.getParameter("style").trim();

        SongList songList = new SongList();
        songList.setTitle(title);
        songList.setPic(pic);
        songList.setIntroduction(introduction);
        songList.setStyle(style);
        if (service.addSongList(songList)){
            return JsonResponseUtil.success("添加成功");
        } else {
            return JsonResponseUtil.error("添加失败");
        }
    }

    // 返回所有歌单
    @ResponseBody
    @RequestMapping(value = "/songList", method = RequestMethod.GET)
    public Object allSongList(){
        return service.allSongList();
    }

    // 指定标题
    @ResponseBody
    @RequestMapping(value = "/songList/title/detail", method = RequestMethod.GET)
    public Object songListOfTitle(HttpServletRequest request){
        String title = request.getParameter("title");
        return service.songListOfTitle(title);
    }

    // like标题
    @ResponseBody
    @RequestMapping(value = "/songList/likeTitle/detail", method = RequestMethod.GET)
    public Object songListOfLikeTitle(HttpServletRequest request){
        String title = request.getParameter("title");
        return service.likeTitle("%" + title + "%");
    }

    // LIKE类型
    @ResponseBody
    @RequestMapping(value = "/songList/style/detail", method = RequestMethod.GET)
    public Object songListOfStyle(HttpServletRequest request){
        String style = request.getParameter("style");
        return service.likeStyle(style);
    }

    // 删除歌单
    @ResponseBody
    @RequestMapping(value = "songList/delete", method = RequestMethod.GET)
    public Object deleteSongList(HttpServletRequest request){
        String id = request.getParameter("id");
        return service.deleteSongList(Integer.parseInt(id));
    }

    // 更新歌单信息
    @ResponseBody
    @RequestMapping(value = "/songList/update", method = RequestMethod.POST)
    public Object updateSongListMsg(HttpServletRequest request){
        String id = request.getParameter("id").trim();
        String title = request.getParameter("title").trim();
        String pic = request.getParameter("pic").trim();
        String introduction = request.getParameter("introduction").trim();
        String style = request.getParameter("style").trim();

        SongList songList = new SongList();
        songList.setId(Integer.parseInt(id));
        songList.setTitle(title);
        songList.setPic(pic);
        songList.setIntroduction(introduction);
        songList.setStyle(style);
        if (service.updateSongListMsg(songList)){
            return JsonResponseUtil.success("更新成功");
        } else {
            return JsonResponseUtil.error("更新失败");
        }
    }

    // 更新歌单图片
    @ResponseBody
    @RequestMapping(value = "/songList/img/update", method = RequestMethod.POST)
    public Object updateSongListPic(@RequestParam("file")MultipartFile file, @RequestParam("id") Integer id){
        if (file.isEmpty()){
            return JsonResponseUtil.error("图片上传失败");
        }
        String fileName = System.currentTimeMillis() + file.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img" + System.getProperty("file.separator")+ "songListPic";
        File file1 = new File(filePath);
        if (!file1.exists()){
            file1.mkdir();
        }
        File dest = new File(filePath +System.getProperty("file.separator") + fileName);
        String storeAvatarPath = "/img/songListPic/" + fileName;
        try {
            file.transferTo(dest);
            SongList songList = new SongList();
            songList.setId(id);
            songList.setPic(storeAvatarPath);
            if (service.updateSongListPic(songList)){
                return JsonResponseUtil.uploadSuccess(storeAvatarPath, "上传成功");
            } else {
                return JsonResponseUtil.error("上传失败");
            }
        } catch (IOException e){
            return JsonResponseUtil.error("图片上传失败");
        }
    }
}
