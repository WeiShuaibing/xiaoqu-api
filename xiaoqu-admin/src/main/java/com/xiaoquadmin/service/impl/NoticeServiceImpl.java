package com.xiaoquadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoquadmin.dao.BuildingDao;
import com.xiaoquadmin.dao.NoticeDao;
import com.xiaoquadmin.service.BuildingService;
import com.xiaoquadmin.service.NoticeService;
import com.xiaoqucommon.entity.Building;
import com.xiaoqucommon.entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeDao, Notice> implements NoticeService {

}
