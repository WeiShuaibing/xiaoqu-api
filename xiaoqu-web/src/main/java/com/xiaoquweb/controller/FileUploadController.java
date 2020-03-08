package com.xiaoquweb.controller;

import com.xiaoqucommon.pojo.R;
import com.xiaoqucommon.utils.UploadFileUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.Map;

/**
 * 文件上传接口类
 */
@RestController
@RequestMapping("/file")
@Api(value = "/file", tags = {"文件上传接口"})
public class FileUploadController {

    @Value("${web.file.upload.path}")
    private String upload_path;

    /**
     * 保存文件
     */
    @PostMapping("/upload")
    public R upload(@RequestParam("file") MultipartFile file){
        Map upload = new UploadFileUtil().upload(file, upload_path);
        if (upload == null){
            return new R(20001,"文件上传异常");
        }else {
            return new R(upload);
        }
    }

}
