package com.xiaoquadmin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoqucommon.entity.Car;
import com.xiaoqucommon.entity.Payorder;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PayorederDao extends BaseMapper<Payorder> {


    /**
     * 查询所有的点单信息 附带这个订单是给谁的
     */
    @Select("select pay.*, u.user_name from payorder pay, `user` u where " +
            "pay.user_id=u.id AND pay.pay_type = #{type} order by pay.id desc LIMIT #{startRow},#{pageSize}")
    public List<Map<String, Object>> getPage(int startRow, int pageSize, int type);

    @Select("select count(*) from payorder pay, `user` u where " +
            "pay.user_id=u.id AND pay.pay_type = #{type}")
    public int getPageCount(int type);

}
