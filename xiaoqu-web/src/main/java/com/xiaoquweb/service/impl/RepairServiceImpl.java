package com.xiaoquweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoqucommon.entity.Repair;
import com.xiaoqucommon.entity.Suggestion;
import com.xiaoquweb.dao.RepairDao;
import com.xiaoquweb.dao.SuggestionDao;
import com.xiaoquweb.service.RepairService;
import com.xiaoquweb.service.SuggestionService;
import org.springframework.stereotype.Service;

@Service
public class RepairServiceImpl extends ServiceImpl<RepairDao, Repair> implements RepairService {
}
