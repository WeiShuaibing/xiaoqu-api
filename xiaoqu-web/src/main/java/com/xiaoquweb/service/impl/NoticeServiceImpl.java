package com.xiaoquweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoqucommon.entity.Building;
import com.xiaoqucommon.entity.Notice;
import com.xiaoquweb.dao.BuildingDao;
import com.xiaoquweb.dao.NoticeDao;
import com.xiaoquweb.service.BuildingService;
import com.xiaoquweb.service.NoticeService;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeDao, Notice> implements NoticeService {
}
