package com.xiaoquadmin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoquadmin.service.SuggestionService;
import com.xiaoqucommon.entity.Suggestion;
import com.xiaoqucommon.pojo.MyPage;
import com.xiaoqucommon.pojo.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/suggestion")
@Api(value = "/suggestion", tags = {"投诉/建议相关接口"})
public class SuggestionController {

    @Autowired
    private SuggestionService suggestionService;

    @GetMapping("/getPage")
    public R getPage(int pageNum, int pageSize, int status) {
        MyPage<Map<String, Object>> page = suggestionService.getPage(pageNum, pageSize, status);
        return new R(page);

    }

    @GetMapping("/getById")
    public R getById(int id){
        Suggestion byId = suggestionService.getById(id);
        return new R(byId);
    }

    @GetMapping("/delete")
    public R delete(int id){
        boolean b = suggestionService.removeById(id);
        if (b) return new R();
        else return new R(20001, "删除失败！");
    }

    @PostMapping("/update")
    public R update(@RequestBody Suggestion suggestion){
        boolean b = suggestionService.updateById(suggestion);
        if (b) return new R();
        else return new R(20001, "更新失败！");
    }


    @GetMapping("/search")
    public R search(int pageNum, int pageSize, String matchStr){
       return new R();
    }

    @GetMapping("/updateStatus")
    public R updateStatus(int id, int status) {
        Suggestion suggestion = new Suggestion();
        suggestion.setId(id);
        suggestion.setSuStatus(status);
        boolean b = suggestionService.updateById(suggestion);
        if (b) return new R();
        else return new R(20001, "更新失败！");
    }


}
