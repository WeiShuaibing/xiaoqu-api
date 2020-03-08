package com.xiaoquadmin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.entity.Notice;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeDao extends BaseMapper<Notice> {
}
