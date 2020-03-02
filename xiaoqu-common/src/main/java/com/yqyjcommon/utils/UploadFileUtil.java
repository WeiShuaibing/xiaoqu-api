package com.yqyjcommon.utils;

import com.yqyjcommon.pojo.R;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 上传文件工具类
 */
public class UploadFileUtil {

    public Map upload(MultipartFile file, String upload_path){
        try {
            if (file.isEmpty()){
                return null;
            }
            // 获取文件原始名称
            String originalFilename = file.getOriginalFilename();
            // 生成文件新的名称
            String newName = String.valueOf(new Date().getTime());

            //获取文件名称的后缀
            String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));

            //生成文件目录
            Calendar cal= Calendar.getInstance();
            int y=cal.get(Calendar.YEAR);
            int m=cal.get(Calendar.MONTH);
            int d=cal.get(Calendar.DATE);
            String today = y + "-" + (m + 1) + "-" + d;

            String filePath = upload_path+suffixName.substring(1)+"/"+today + "/";
            String complePath = filePath + newName + suffixName;
            File dest = new File(complePath);

            //检测目录是否存在
            if (!dest.getParentFile().exists()){
                dest.getParentFile().mkdirs();
            }
            file.transferTo(dest);
            HashMap<String, String> map = new HashMap<>();
            map.put("originalFileName", originalFilename);
            map.put("completePath", complePath);
            map.put("path", "/" + suffixName.substring(1) + "/" + today + "/" + newName + suffixName);
            map.put("fileType", suffixName);
            return map;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

}
