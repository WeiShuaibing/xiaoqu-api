package com.xiaoquweb.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoqucommon.entity.Notice;
import com.xiaoqucommon.entity.Topic;
import com.xiaoqucommon.pojo.MyPage;
import com.xiaoqucommon.pojo.R;
import com.xiaoquweb.service.NoticeService;
import com.xiaoquweb.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/topic")
@Api(value = "/topic", tags = {"话题相关接口"})
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping("/add")
    public R add(@RequestBody Topic topic) {
        boolean save = topicService.save(topic);
        if (save) return new R();
        else return new R(20001, "保存失败！");
    }

    @GetMapping("/getHotTopic")
    public R getHotTopic(int pageSize) {
        List<Map<String, Object>> hotTopic = topicService.getHotTopic(pageSize);
        return new R(hotTopic);
    }

    @GetMapping("/getNewTopic")
    public R getNewTopic(int pageSize) {
        List<Map<String, Object>> hotTopic = topicService.getNewTopic(pageSize);
        return new R(hotTopic);
    }

    @GetMapping("/getAllTopic")
    public R getAllTopic(int pageNum, int pageSize) {
        MyPage allTopic = topicService.getAllTopic(pageNum, pageSize);
        return new R(allTopic);
    }
    // 点赞话题
    @GetMapping("/love")
    public R love(int id) {
        Topic byId = topicService.getById(id);
        byId.setTopicLove(byId.getTopicLove() + 1);
        boolean b = topicService.updateById(byId);
        if (b) return new R();
        else return new R(20001,"服务异常，点赞失败！");
    }

    @GetMapping("/delete")
    public R delete(int id){
        boolean b = topicService.removeById(id);
        if (b) return new R();
        else return new R(20001,"服务异常，删除失败！");
    }

    /**
     * 总话题数
     */
    @GetMapping("/count")
    public R count(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("totalTopic", topicService.count());
        return new R(map);
    }

    /**
     * 搜索话题
     */
    @GetMapping("/search")
    public R search(String matchStr) {
        return new R(topicService.search(matchStr));
    }
}