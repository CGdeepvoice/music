package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.Comment;
import com.example.demo.pojo.Song;
import com.example.demo.pojo.SongList;
import com.example.demo.pojo.User;
import com.example.demo.service.CommentService;
import com.example.demo.utils.JsonResponseUtil;
import org.apache.catalina.util.IOTools;
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
public class CommentController {
    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    // 提交评论
    @ResponseBody
    @RequestMapping(value = "/comment/add", method = RequestMethod.POST)
    public Object addComment(HttpServletRequest request) throws IOException {
        JSONObject body = JSON.parseObject(IOUtils.toString(request.getReader()));
        String userId = body.get("userId").toString();
        String type = body.get("type").toString();
        String content = body.get("content").toString();
        String songId = body.get("songId").toString();
        String songListId = body.get("songListId").toString();
        Comment comment = new Comment();
        User user = new User();
        user.setId(Integer.parseInt(userId));
        comment.setUser(user);
        Song song = new Song();
        song.setId(Integer.parseInt(songId));
        comment.setSong(song);
        SongList songList = new SongList();
        songList.setId(Integer.parseInt(songListId));
        comment.setSongList(songList);
        comment.setType(Byte.valueOf(type));
        comment.setContext(content);

        if (service.addComment(comment)){
            return JsonResponseUtil.success("评论成功");
        } else{
            return JsonResponseUtil.error("评论失败");
        }
    }

    // 获取全部评论
    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    public Object allComment(){
        return service.allComment();
    }

    // 获得指定歌曲id的评论
    @ResponseBody
    @RequestMapping(value = "/comment/song/detail", method = RequestMethod.GET)
    public Object commentOfSongId(HttpServletRequest request){
        String songId = request.getParameter("songId");
        return service.commentOfSongId(Integer.parseInt(songId));
    }


    // 获得指定歌单的评论
    @ResponseBody
    @RequestMapping(value = "/comment/songList/detail", method = RequestMethod.GET)
    public Object commentOfSongListId(HttpServletRequest request){
        String songListId = request.getParameter("songListId");
        return service.commentOfSongListId(Integer.parseInt(songListId));
    }

    // 点赞
    @ResponseBody
    @RequestMapping(value = "/comment/up", method = RequestMethod.POST)
    public Object commentOfLike(HttpServletRequest request) throws IOException {
        JSONObject jsonObject = JSON.parseObject(IOUtils.toString(request.getReader()));
        Integer id = jsonObject.getInteger("id");
        Integer up = jsonObject.getInteger("up");
        Comment comment = new Comment();
        comment.setId(id);
        comment.setUp(up);
        if (service.updateComment(comment)){
            return JsonResponseUtil.success("点赞成功");
        } else  {
            return JsonResponseUtil.error("点赞失败");
        }
    }

    // 删除评论
    @ResponseBody
    @RequestMapping(value = "/comment/delete", method = RequestMethod.GET)
    public Object deleteComment(HttpServletRequest request){
        String id = request.getParameter("id");
        return service.deleteComment(Integer.parseInt(id));
    }
    // 更新评论
    @ResponseBody
    @RequestMapping(value = "/comment/update", method = RequestMethod.GET)
    public Object updateCommentMsg(HttpServletRequest request) throws IOException {
        JSONObject body = JSON.parseObject(IOUtils.toString(request.getReader()));
        String userId = body.get("userId").toString();
        String type = body.get("type").toString();
        String content = body.get("content").toString();
        String songId = body.get("songId").toString();
        String songListId = body.get("songListId").toString();
        Comment comment = new Comment();
        User user = new User();
        user.setId(Integer.parseInt(userId));
        comment.setUser(user);
        Song song = new Song();
        song.setId(Integer.parseInt(songId));
        comment.setSong(song);
        SongList songList = new SongList();
        songList.setId(Integer.parseInt(songListId));
        comment.setSongList(songList);
        comment.setType(Byte.valueOf(type));
        comment.setContext(content);

        if (service.updateComment(comment)){
            return JsonResponseUtil.success("评论成功");
        } else{
            return JsonResponseUtil.error("评论失败");
        }
    }
}
