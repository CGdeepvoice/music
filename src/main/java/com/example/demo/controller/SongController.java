package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.Singer;
import com.example.demo.pojo.Song;
import com.example.demo.service.impl.SongServiceImpl;
import com.example.demo.utils.JsonResponseUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@RestController
@Controller
public class SongController {
    private final SongServiceImpl service;

    public SongController(SongServiceImpl service) {
        this.service = service;
    }

    // 新增歌曲
    @ResponseBody
    @RequestMapping(value = "/song/add", method = RequestMethod.POST)
    public Object addSong(HttpServletRequest request, @RequestParam("file")MultipartFile mp3file) {
        String singerId = request.getParameter("singerId");
        String name = request.getParameter("name");
        String introduction = request.getParameter("introduction");
        String lyric = request.getParameter("lyric");
        String pic = "/img/xxx.jpg";
        if (mp3file.isEmpty()){
            return JsonResponseUtil.error("上传失败");
        }

        String fileName = System.currentTimeMillis() + mp3file.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "song";
        File file = new File(filePath);
        if (!file.exists()){
            file.mkdir();
        }
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String storeUrlPath = "/song/" + fileName;
        try {
            mp3file.transferTo(dest);
            Song song = new Song();
            song.setName(name);
            song.setIntroduction(introduction);
            song.setUrl(storeUrlPath);
            song.setLyric(lyric);
            song.setCreateTime(new Date());
            song.setUpdateTime(new Date());
            song.setPic(pic);
            Singer singer = new Singer();
            singer.setId(Integer.valueOf(singerId));
            song.setSinger(singer);

            if (service.addSong(song)){
                return JsonResponseUtil.uploadSuccess(storeUrlPath, "上传成功");
            } else{
                return JsonResponseUtil.error("上传失败");
            }

        } catch (IOException e){
            e.printStackTrace();
            return JsonResponseUtil.error("文件上传失败");
        }
    }


    // 返回所有歌曲
    @ResponseBody
    @RequestMapping(value = "/song", method = RequestMethod.GET)
    public Object allSong(){
        return service.allSong();
    }

    // 返回指定id的歌曲
    @ResponseBody
    @RequestMapping(value = "/song/detail", method = RequestMethod.GET)
    public Object songOfId(HttpServletRequest request){
        String id = request.getParameter("id");
        return service.songOfId(Integer.parseInt(id));
    }

    // 指定歌手ID的名称
    @ResponseBody
    @RequestMapping(value = "/song/singer/detail", method = RequestMethod.GET)
    public Object songOfSingerId(HttpServletRequest request){
        String singerId = request.getParameter("singerId");
        return service.songOfSingerId(Integer.parseInt(singerId));
    }

    // 返回指定歌曲名的歌曲
    @ResponseBody
    @RequestMapping(value = "/song/name/detail", method = RequestMethod.GET)
    public Object songOfName(HttpServletRequest request){
        String name = request.getParameter("name");
        return service.songOfName(name);
    }

    // 删除歌曲
    @ResponseBody
    @RequestMapping(value = "/song/delete", method = RequestMethod.GET)
    public Object deleteSong(HttpServletRequest request){
        String id = request.getParameter("id");
        return service.deleteSong(Integer.parseInt(id));
    }

    // 更新歌曲信息
    @ResponseBody
    @RequestMapping(value = "/song/update", method = RequestMethod.POST)
    public Object updateSongMsg(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        String id = req.getParameter("id").trim();
        String singer_id = req.getParameter("singerId").trim();
        String name = req.getParameter("name").trim();
        String introduction = req.getParameter("introduction").trim();
        String lyric = req.getParameter("lyric").trim();

        Song song = new Song();
        song.setId(Integer.parseInt(id));
        Singer singer = new Singer();
        singer.setId(Integer.parseInt(singer_id));
        song.setSinger(singer);
        song.setName(name);
        song.setIntroduction(introduction);
        song.setUpdateTime(new Date());
        song.setLyric(lyric);
        if (service.updateSongMsg(song)){
            return JsonResponseUtil.success("修改成功");
        } else {
            return JsonResponseUtil.error("修改失败");
        }
    }

    // 更新歌曲图片
    @ResponseBody
    @RequestMapping(value = "/song/pic/update", method = RequestMethod.POST)
    public Object updateSongPic(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer id){
        if (file.isEmpty()){
            return JsonResponseUtil.error("图片上传失败");
        }
        String fileName = System.currentTimeMillis() + file.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img" + System.getProperty("file.separator") + "songPic";
        File file1 = new File(filePath);
        if (!file1.exists()){
            file1.mkdir();
        }
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String storeUrlPath = "/img/songPic/" + fileName;
        try {
            file.transferTo(dest);
            Song song = new Song();
            song.setId(id);
            song.setPic(storeUrlPath);
            if (service.updateSongPic(song)){
                return JsonResponseUtil.uploadSuccess(storeUrlPath, "上传成功");
            } else{
                return JsonResponseUtil.error("上传失败");
            }

        }catch (IOException e){
            return JsonResponseUtil.error("上传失败");
        }
    }
    // 更新歌曲
    @ResponseBody
    @RequestMapping(value = "/song/url/update", method = RequestMethod.POST)
    public Object updateSongUrl(@RequestParam("file") MultipartFile mp3file, @RequestParam("id") Integer id){
        if (mp3file.isEmpty()){
            return JsonResponseUtil.error("音乐上传失败");
        }
        String fileName = System.currentTimeMillis() + mp3file.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "song";
        File file = new File(filePath);
        if (!file.exists()){
            file.mkdir();
        }
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String storeUrlPath = "/song/" + fileName;
        try {
            mp3file.transferTo(dest);
            Song song = new Song();
            song.setUrl(storeUrlPath);
            song.setId(id);
            if (service.updateSongUrl(song)){
                return JsonResponseUtil.uploadSuccess(storeUrlPath, "上传成功");
            } else {
                return JsonResponseUtil.error("音乐上传失败");
            }

        } catch (IOException e){
            return JsonResponseUtil.error("音乐上传失败");
        }
    }
}
