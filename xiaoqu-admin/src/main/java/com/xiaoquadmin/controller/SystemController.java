package com.xiaoquadmin.controller;

import com.xiaoquadmin.service.AdminService;
import com.xiaoquadmin.service.BackupService;
import com.xiaoquadmin.service.LogService;
import com.xiaoqucommon.entity.Admin;
import com.xiaoqucommon.entity.Backup;
import com.xiaoqucommon.entity.Log;
import com.xiaoqucommon.pojo.MyPage;
import com.xiaoqucommon.pojo.R;
import com.xiaoqucommon.utils.DbOperate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    @Value("${sqlbackup.mysql.path}")
    private String mysqlBinPath;

    @Autowired
    private BackupService backupService;
    @Autowired
    private LogService logService;
    @Autowired
    private AdminService adminService;

    @PostMapping("/backup")
    public R backup(@RequestBody Backup backup, @RequestHeader int YQYJToken){
        Admin admin = adminService.getById(YQYJToken);
        try {
            String backName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date())+".sql";
            DbOperate dbOperate = new DbOperate();
            String path = dbOperate.dbBackUpOfWin(host, sqluser, pwd, dbName, backPath, backName, mysqlBinPath);
            backup.setBackupPath(path);
            backup.setAdminId(YQYJToken);
            boolean save = backupService.save(backup);
            if (save) {
                logService.save(new Log(admin.getAdminName(), "数据备份->" + backup.getBackupText(), "success"));
                return new R();
            } else {
                logService.save(new Log(admin.getAdminName(), "数据备份->" + backup.getBackupText(), "保存信息失败"));
                return new R(20000, "备份信息保存失败！");
            }
        }catch (Exception e) {
            System.out.println("数据备份异常");
            e.printStackTrace();
            logService.save(new Log(admin.getAdminName(), "数据备份->" + backup.getBackupText(), "服务异常，备份失败！"));
            return new R(20001, "服务异常，备份失败！");
        }

    }

    @GetMapping("/dbRestore")
    public R dbRestore(String backup_path){
        DbOperate dbOperate = new DbOperate();
        try {
            dbOperate.dbRestore(host, sqluser, pwd, dbName, backup_path, mysqlBinPath);
            return new R();
        }catch (Exception e){
            return new R(20000, "服务异常，数据恢复失败！");
        }
    }

    @GetMapping("/getPage")
    public R getPage(int pageNum, int pageSize) {
        List<Map<String, Object>> list = backupService.getPage(pageNum, pageSize);
        MyPage<Map<String, Object>> page = new MyPage<>(list, backupService.count());
        return new R(page);
    }
}
