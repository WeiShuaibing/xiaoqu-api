package com.xiaoquweb.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xiaoqucommon.entity.Comment;
import com.xiaoqucommon.pojo.R;
import com.xiaoquweb.service.CommentService;
import com.xiaoquweb.service.TopicService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/comment")
@Api(value = "/comment", tags = {"评论相关接口"})
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public R add(@RequestBody Comment comment){
        boolean save = commentService.save(comment);
        if (save) return new R();
        else return new R(20001,"服务异常，点赞失败！");
    }

    @GetMapping("/delete")
    public R delete(int id) {
        boolean b = commentService.removeById(id);
        if (b) return new R();
        else return new R(20001,"服务异常，点赞失败！");
    }

    @GetMapping("/love")
    public R love(int id){
        Comment byId = commentService.getById(id);
        byId.setCommentLove(byId.getCommentLove() + 1);
        boolean b = commentService.updateById(byId);
        if (b) return new R();
        else return new R(20001,"服务异常，点赞失败！");
    }

    @GetMapping("/getPageComment")
    public R getPageComment(int pageNum, int pageSize, int topicId) {
        return new R(commentService.getPageComment(pageNum, pageSize, topicId));
    }

    @GetMapping("/getParentCommTotalNum")
    public R getParentCommTotalNum(int topicId) {
        QueryWrapper<Comment> query = Wrappers.<Comment>query();
        query.eq("comment_parent_id", 0).eq("topic_id", topicId);
        int count = commentService.count(query);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("totalNum", count);
        return new R(map);
    }

    /**
     * 获取某个话题的总评论数和总点赞数
     */
    @GetMapping("/getTotalOfTopic")
    public R getTotalOfTopic(int topicId){
        QueryWrapper<Comment> query = Wrappers.<Comment>query();
        query.eq("topic_id", topicId);
        int count = commentService.count(query);
        int sumOfLove = commentService.getSumOfLove(topicId);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("totalComment", count);
        map.put("totalLove", sumOfLove);
        map.put("parentComment", commentService.count(Wrappers.<Comment>query().eq("comment_parent_id", 0).eq("topic_id", topicId)));
        return new R(map);
    }

}
