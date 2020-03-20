package com.xiaoquadmin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.entity.Log;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDao extends BaseMapper<Log> {
}
