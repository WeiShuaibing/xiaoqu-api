package com.xiaoquweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoqucommon.entity.Building;
import com.xiaoqucommon.entity.Suggestion;
import com.xiaoquweb.dao.BuildingDao;
import com.xiaoquweb.dao.SuggestionDao;
import com.xiaoquweb.service.BuildingService;
import com.xiaoquweb.service.SuggestionService;
import org.springframework.stereotype.Service;

@Service
public class SuggestionServiceImpl extends ServiceImpl<SuggestionDao, Suggestion> implements SuggestionService {
}
