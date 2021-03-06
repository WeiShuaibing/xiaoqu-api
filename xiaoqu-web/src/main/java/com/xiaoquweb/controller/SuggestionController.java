package com.xiaoquweb.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xiaoqucommon.entity.Suggestion;
import com.xiaoqucommon.pojo.R;
import com.xiaoquweb.service.SuggestionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suggestion")
@Api(value = "/suggestion", tags = {"投诉建议相关接口"})
public class SuggestionController {

    @Autowired
    private SuggestionService suggestionService;

    @GetMapping("/getById")
    public R getById(int id) {
        Suggestion byId = suggestionService.getById(id);
        return new R(byId);
    }

    @PostMapping("/add")
    public R add(@RequestBody Suggestion suggestion, @RequestHeader int XiaoQuToken) {
        suggestion.setUserId(XiaoQuToken);
        suggestion.setSuStatus(1);
        boolean save = suggestionService.saveAndFenpei(suggestion);
        if (save) return new R();
        else return new R(20001, "服务异常，保存失败！");
    }

    @GetMapping("/getAllOfMy")
    public R getAllOfMy(@RequestHeader int XiaoQuToken){
        QueryWrapper<Suggestion> query = Wrappers.<Suggestion>query();
        query.eq("user_id", XiaoQuToken).orderByDesc("id");
        return new R(suggestionService.list(query));
    }

    /**
     * 增加用户的评价
     */
    @PostMapping("/addEvaluate")
    public R addEvaluate(@RequestBody Suggestion suggestion) {
        boolean b = suggestionService.updateById(suggestion);
        if (b) {
            return new R();
        } else  {
            return new R(20001, "增加评价信息失败！");
        }
    }

}
