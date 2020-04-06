package com.xiaoqucommon.utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 数据库备份与还原
 *
 * linux下：
 *
 * String[] command = { "/bin/sh", "-c", command };
 *
 * Process ps = Runtime.getRuntime().exec(command );
 *
 * windows下：
 *
 * String[] command = { "cmd", "/c", command};
 *
 * Process ps = Runtime.getRuntime().exec(command );
 */
public class DbOperate {

    public static void dbBackUpOfLinux(String host, String root,String pwd,String dbName,String backPath,String backName) throws Exception {
        String pathSql = backPath+backName;
        File fileSql = new File(pathSql);
        //创建备份sql文件
        if (!fileSql.exists()){
            fileSql.createNewFile();
        }
        //mysqldump -hlocalhost -uroot -p123456 db > /home/back.sql
        StringBuffer sb = new StringBuffer();
        sb.append("mysqldump");
        sb.append(" -h"+host);
        sb.append(" -u"+root);
        sb.append(" -p"+pwd);
        sb.append(" "+dbName+" >");
        sb.append(pathSql);
        System.out.println("cmd命令为："+sb.toString());
        Runtime runtime = Runtime.getRuntime();
        System.out.println("开始备份："+dbName);
//        Process process = runtime.exec("/bin/sh -c"+sb.toString());
        Process process = runtime.exec(new String[]{"/bin/sh","-c", sb.toString()});
        System.out.println("备份成功!");
    }

    public static String dbBackUpOfWin(String host, String user,String pwd,String dbName,String backPath,String backName, String mysqlBinPath) throws Exception {
        String pathSql = backPath+backName;
        File fileSql = new File(pathSql);
        //创建备份sql文件
        if (!fileSql.exists()){
            fileSql.createNewFile();
        }
        //mysqldump -hlocalhost -uroot -p123456 db > /home/back.sql
        StringBuffer sb = new StringBuffer();
        sb.append(mysqlBinPath +"mysqldump");
        sb.append(" -h"+host);
        sb.append(" -u"+user);
        sb.append(" -p"+pwd);
        sb.append(" "+dbName+">");
        sb.append(pathSql);
        System.out.println("cmd命令为："+sb.toString());
        Runtime runtime = Runtime.getRuntime();
        System.out.println("开始备份："+dbName);
        Process process = runtime.exec(new String[]{"cmd", "/c", sb.toString()});
        return pathSql;
    }

    /**
     * 恢复数据库
     * @param root
     * @param pwd
     * @param dbName
     * @param filePath
     * mysql -hlocalhost -uroot -p123456 db < /home/back.sql
     */
    public static void dbRestore(String host, String root,String pwd,String dbName,String filePath, String mysqlBinPath){
        StringBuilder sb = new StringBuilder();
        sb.append(mysqlBinPath + "mysql");
        sb.append(" -h"+host);
        sb.append(" -u"+root);
        sb.append(" -p"+pwd);
        sb.append(" "+dbName+" <");
        sb.append(filePath);
        System.out.println("cmd命令为："+sb.toString());
        Runtime runtime = Runtime.getRuntime();
        System.out.println("开始还原数据");
        try {
            Process process = runtime.exec(new String[]{"cmd", "/c", sb.toString()});
            InputStream is = process.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(is,"utf8"));
            String line = null;
            while ((line=bf.readLine())!=null){
                System.out.println(line);
            }
            is.close();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("还原成功！");
    }



    public static void main(String[] args) throws Exception {

    }

}