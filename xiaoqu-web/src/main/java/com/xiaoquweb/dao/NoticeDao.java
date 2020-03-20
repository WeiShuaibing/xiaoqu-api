package com.xiaoquweb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoqucommon.entity.Building;
import com.xiaoqucommon.entity.Notice;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeDao extends BaseMapper<Notice> {

    @Select("select * from notice")
    public List<Notice> testGetAllNotice();

}
