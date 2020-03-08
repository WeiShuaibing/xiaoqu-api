package com.xiaoquweb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoqucommon.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao extends BaseMapper<User> {


}
