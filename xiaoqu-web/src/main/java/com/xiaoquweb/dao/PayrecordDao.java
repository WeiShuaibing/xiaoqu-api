package com.xiaoquweb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoqucommon.entity.Payorder;
import com.xiaoqucommon.entity.Payrecord;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PayrecordDao extends BaseMapper<Payrecord> {


    /**
     * 查询所有我已经缴费的
     */
    @Select("SELECT ord.*, record.payorder_id,record.user_id, record.create_date as record_create_date  " +
            "FROM payrecord record, payorder ord WHERE record.payorder_id = ord.id AND record.user_id = #{user_id}")
    public List<Map<String, Object>> getAllHavedPay(int user_id);

}
