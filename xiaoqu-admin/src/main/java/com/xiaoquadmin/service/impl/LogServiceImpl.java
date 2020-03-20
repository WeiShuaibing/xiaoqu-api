package com.xiaoquadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoquadmin.dao.AdminDao;
import com.xiaoquadmin.dao.LogDao;
import com.xiaoquadmin.service.AdminService;
import com.xiaoquadmin.service.LogService;
import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.entity.Log;
import com.xiaoqucommon.pojo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LogServiceImpl extends ServiceImpl<LogDao, Log> implements LogService {

}
