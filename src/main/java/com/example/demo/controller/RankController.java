package com.example.demo.controller;

import com.example.demo.pojo.Rank;
import com.example.demo.pojo.SongList;
import com.example.demo.pojo.User;
import com.example.demo.service.impl.RankServiceImpl;
import com.example.demo.utils.JsonResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Controller
public class RankController {
    private final RankServiceImpl service;

    public RankController(RankServiceImpl service) {
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(value = "/rank/add", method = RequestMethod.POST)
    public Object addRank(HttpServletRequest request){
        Rank rank = new Rank();
        String songListId = request.getParameter("songListId").trim();
        String userId = request.getParameter("userId").trim();
        String score = request.getParameter("score");
        User user = new User();
        user.setId(Integer.parseInt(userId));
        rank.setUser(user);
        SongList songList = new SongList();
        songList.setId(Integer.parseInt(songListId));
        rank.setSongList(songList);
        rank.setScore(Integer.parseInt(score));
        if (service.addRank(rank)){
            return JsonResponseUtil.success("评价成功");
        }else {
            return JsonResponseUtil.error("评价失败");
        }
    }

    // 歌单平均分
    @ResponseBody
    @RequestMapping(value = "/rank", method = RequestMethod.GET)
    public Object rankOfSongListId(HttpServletRequest request){
        String songListId = request.getParameter("songListId");
        return service.rankOfSongListId(Integer.parseInt(songListId));
    }
}
