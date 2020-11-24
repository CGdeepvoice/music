package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.ListSong;
import com.example.demo.pojo.Song;
import com.example.demo.pojo.SongList;
import com.example.demo.service.impl.ListSongServiceImpl;
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

@RestController
@Controller
public class ListSongController {
    private final ListSongServiceImpl service;

    public ListSongController(ListSongServiceImpl service) {
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(value = "/listSong/add", method = RequestMethod.POST)
    public Object addListSong(HttpServletRequest request) throws IOException {
        JSONObject body = JSON.parseObject(IOUtils.toString(request.getReader()));
        String songId = body.get("songId").toString();
        String songListId = body.get("songListId").toString();
        Song song = new Song();
        song.setId(Integer.parseInt(songId));
        SongList songList = new SongList();
        songList.setId(Integer.parseInt(songListId));
        ListSong listSong = new ListSong();
        listSong.setSongList(songList);
        listSong.setSong(song);
        if (service.addListSong(listSong)){
            return JsonResponseUtil.success("添加成功");
        } else {
            return JsonResponseUtil.error("添加失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "listSong", method = RequestMethod.GET)
    public Object allListSong(){
        return service.allListSong();
    }

    // 指定歌单的歌曲
    @ResponseBody
    @RequestMapping(value = "/listSong/detail", method = RequestMethod.GET)
    public Object listSongOfSongId(HttpServletRequest request){
        String songListId = request.getParameter("songListId");
        return service.listSongOfSongListId(Integer.parseInt(songListId));
    }

    // 删除歌单里的歌曲
    @ResponseBody
    @RequestMapping(value = "/listSong/delete", method = RequestMethod.GET)
    public Object deleteListSong(HttpServletRequest req){
        String listSongId = req.getParameter("listSongId");
        return service.deleteListSong(Integer.parseInt(listSongId));
    }

    // 更新歌单里的歌曲信息
    @ResponseBody
    @RequestMapping(value = "/listSong/update", method = RequestMethod.POST)
    public Object updateListSongMsg(HttpServletRequest req){
        String id = req.getParameter("id").trim();
        String song_id = req.getParameter("songId").trim();
        String song_list_id = req.getParameter("songListId").trim();

        ListSong listsong = new ListSong();
        listsong.setId(Integer.parseInt(id));
        Song song = new Song();
        song.setId(Integer.parseInt(song_id));
        listsong.setSong(song);
        SongList songList = new SongList();
        songList.setId(Integer.parseInt(song_list_id));
        listsong.setSongList(songList);

        if (service.updateListSong(listsong)){
            return JsonResponseUtil.success("修改成功");
        }else {
            return JsonResponseUtil.error("修改失败");
        }
    }
}
