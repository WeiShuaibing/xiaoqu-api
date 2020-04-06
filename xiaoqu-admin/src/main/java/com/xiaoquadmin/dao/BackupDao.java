package com.xiaoquadmin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.entity.Backup;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BackupDao extends BaseMapper<Backup> {

    @Select("SELECT `backup`.*, admin.admin_name FROM `backup`, `admin` WHERE `backup`.admin_id = admin.id ORDER BY `backup`.id DESC LIMIT #{startRow},#{pageSize}")
    public List<Map<String, Object>> getPage(int startRow, int pageSize);

}
