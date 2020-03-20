package com.xiaoquadmin.controller;

import com.xiaoqucommon.pojo.R;
import com.xiaoqucommon.utils.DbOperate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/system")
public class SystemController {

    @Value("${sqlbackup.host}")
    private String host;
    @Value("${spring.datasource.username}")
    private String sqluser;
    @Value("${spring.datasource.password}")
    private String pwd;
    @Value("${sqlbackup.dbname}")
    private String dbName;
    @Value("${sqlbackup.path}")
    private String backPath;

    @GetMapping("/backup")
    public R backup(){
        try {
            String backName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date())+".sql";
            DbOperate dbOperate = new DbOperate();
            dbOperate.dbBackUpOfWin(host,sqluser, pwd, dbName, backPath, backName);
            return new R();
        }catch (Exception e) {
            System.out.println("数据备份异常");
            e.printStackTrace();
            return new R(20001, "服务异常，备份失败！");
        }

    }

}
