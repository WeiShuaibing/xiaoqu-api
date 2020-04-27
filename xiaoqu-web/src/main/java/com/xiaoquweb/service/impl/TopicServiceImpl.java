package com.xiaoquweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoqucommon.entity.Notice;
import com.xiaoqucommon.entity.Topic;
import com.xiaoqucommon.pojo.MyPage;
import com.xiaoquweb.dao.NoticeDao;
import com.xiaoquweb.dao.TopicDao;
import com.xiaoquweb.service.NoticeService;
import com.xiaoquweb.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TopicServiceImpl extends ServiceImpl<TopicDao, Topic> implements TopicService {

    @Autowired
    private TopicDao topicDao;

    @Override
    public List<Map<String, Object>> getHotTopic(int pageSize) {
        List<Map<String, Object>> hotTopic = topicDao.getHotTopic(pageSize);
        return hotTopic;
    }

    @Override
    public MyPage getAllTopic(int pageNum, int pageSize) {
        List<Map<String, Object>> allTopic = topicDao.getAllTopic((pageNum - 1) * pageSize, pageSize);
        MyPage<Map<String, Object>> mapMyPage = new MyPage<>(allTopic, this.count());
        return mapMyPage;
    }

    @Override
    public List<Map<String, Object>> getNewTopic(int pageSize) {
        return topicDao.getNewTopic(pageSize);
    }

    @Override
    public List<Map<String, Object>> search(String matchStr) {
        return topicDao.search("%" +matchStr+ "%");
    }
}
