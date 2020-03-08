package com.xiaoquadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoquadmin.dao.BuildingDao;
import com.xiaoquadmin.dao.SuggestionDao;
import com.xiaoquadmin.service.BuildingService;
import com.xiaoquadmin.service.SuggestionService;
import com.xiaoqucommon.entity.Building;
import com.xiaoqucommon.entity.Suggestion;
import com.xiaoqucommon.pojo.MyPage;
import com.xiaoqucommon.pojo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SuggestionServiceImpl extends ServiceImpl<SuggestionDao, Suggestion> implements SuggestionService {

    @Autowired
    private SuggestionDao suggestionDao;

    @Override
    public MyPage<Map<String, Object>> getPage(int pageNum, int pageSize, int status) {

        List<Map<String, Object>> page = suggestionDao.getPage((pageNum - 1) * pageSize, pageSize, status);
        MyPage<Map<String, Object>> mapMyPage = new MyPage<>(page,
                suggestionDao.selectCount(Wrappers.<Suggestion>query().eq("su_status", status)));
        return mapMyPage;
    }
}
