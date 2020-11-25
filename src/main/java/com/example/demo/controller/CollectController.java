package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.Collect;
import com.example.demo.pojo.Song;
import com.example.demo.pojo.SongList;
import com.example.demo.pojo.User;
import com.example.demo.service.CollectService;
import com.example.demo.utils.JsonResponseUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.RecursiveTask;

@RestController
@Controller
public class CollectController {
    private final CollectService service;

    public CollectController(CollectService service) {
        this.service = service;
    }

    // 添加收藏的歌曲
    @ResponseBody
    @RequestMapping(value = "/collect/add", method = RequestMethod.POST)
    public Object addCollect(HttpServletRequest request) throws IOException {
        JSONObject body = JSON.parseObject(IOUtils.toString(request.getReader()));
        String userId = body.get("userId").toString();
        String type = body.get("type").toString();
        Object songId = body.get("songId");
        Object songListId = body.get("songListId");

        if (songId == null){
            return JsonResponseUtil.error("收藏歌曲为空");
        } else  if (service.existSongId(Integer.parseInt(userId), Integer.parseInt(songId.toString()))){
            return JsonResponseUtil.error("已收藏");
        }
        Collect collect = new Collect();
        User user = new User();
        user.setId(Integer.parseInt(userId));
        collect.setUser(user);
        collect.setType(Byte.valueOf(type));
        if (type.equals("0")){
            Song song = new Song();
            song.setId(Integer.parseInt(songId.toString()));
            collect.setSong(song);
        } else if (type.equals("1")){
            SongList songList = new SongList();
            songList.setId(Integer.parseInt(songListId.toString()));
            collect.setSongList(songList);
        }
        collect.setCreateTime(new Date());
        boolean res = service.addCollection(collect);
        if (res){
            return JsonResponseUtil.success("收藏成功");
        } else{
            return JsonResponseUtil.error("收藏失败");
        }
    }

    // 全部收藏列表
    @ResponseBody
    @RequestMapping(value = "/collection", method = RequestMethod.GET)
    public Object allCollection(){
        return service.allCollect();
    }

    // 指定用户的收藏列表
    @ResponseBody
    @RequestMapping(value = "/collection/detail", method = RequestMethod.GET)
    public Object collectionOfUser(HttpServletRequest request){
        String userId = request.getParameter("userId");
        return service.collectOfUser(Integer.parseInt(userId));
    }

    // 删除收藏的歌曲
    @ResponseBody
    @RequestMapping(value = "/collection/delete", method = RequestMethod.GET)
    public Object deleteCollect(HttpServletRequest request){
        String userId = request.getParameter("userId");
        String songId = request.getParameter("songId");
        return service.deleteCollect(Integer.parseInt(userId), Integer.parseInt(songId));
    }

}
