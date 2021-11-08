package com.mszlu.blog.controller;

import com.mszlu.blog.common.aop.LogAnnotation;
import com.mszlu.blog.common.cache.Cache;
import com.mszlu.blog.service.GoalService;
import com.mszlu.blog.service.SysUserService;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.GoalParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//json数据进行交互
@RestController
@RequestMapping("goals")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @PostMapping("list")
    public Result showGoals(@RequestBody GoalParam goalParam){
        System.out.println(goalParam);
        return goalService.listGoals(goalParam.getUserName());
    }

    //接口url：/articles/publish
    //
    //请求方式：POST
    @PostMapping("create")
    public Result createGoals(@RequestBody GoalParam goalParam){
        return goalService.createGoals(goalParam);
    }
}
