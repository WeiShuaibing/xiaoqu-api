package com.xiaoquweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoqucommon.entity.Building;
import com.xiaoqucommon.entity.User;
import com.xiaoqucommon.pojo.R;
import com.xiaoquweb.dao.BuildingDao;
import com.xiaoquweb.dao.UserDao;
import com.xiaoquweb.service.BuildingService;
import com.xiaoquweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BuildingServiceImpl extends ServiceImpl<BuildingDao, Building> implements BuildingService {
}
