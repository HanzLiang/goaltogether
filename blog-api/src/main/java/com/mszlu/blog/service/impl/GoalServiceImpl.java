package com.mszlu.blog.service.impl;


import com.mszlu.blog.dao.mapper.GoalMapper;
import com.mszlu.blog.dao.pojo.Goal;
import com.mszlu.blog.dao.pojo.SysUser;
import com.mszlu.blog.service.GoalService;
import com.mszlu.blog.utils.UserThreadLocal;
import com.mszlu.blog.vo.GoalVo;
import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.GoalParam;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class GoalServiceImpl implements GoalService {

    @Autowired
    private GoalMapper goalMapper;

//    @Autowired
//    private SysUserService sysUserService;

    @Override
    public Result listGoals(String userName) {

        List<Goal> goalList = goalMapper.listGoals(userName);
        return Result.success(copyList(goalList));
    }

    @Override
    public Result createGoals(GoalParam goalParam){
        // SysUser sysUser = UserThreadLocal.get();
        Goal goal = new Goal();
        goal.setName(goalParam.getName());
        goal.setDescription(goalParam.getDescription());
        goal.setCreateDate(System.currentTimeMillis());
        goal.setUserName(goalParam.getUserName());
        goal.setReward(goalParam.getReward());
        goal.setStatus("ongoing");
        System.out.println("success now");
        // goal.setUserName(sysUser.getAccount());
        this.goalMapper.insert(goal);
        Map<String,String> map = new HashMap<>();
        map.put("id",goal.getId().toString());
        return Result.success(map);

    }
//
//    @Override
//    public Result deleteGoals(GoalParam goalParam){
//
//    }
//

//    @Override
//    public Result completeGoals(GoalParam goalParam){
//
//    }


    private GoalVo copy(Goal goal){
        GoalVo goalVo = new GoalVo();
        goalVo.setId(String.valueOf(goal.getId()));
        BeanUtils.copyProperties(goal,goalVo);
        goalVo.setCreateDate(new DateTime(goal.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        return goalVo;
    }

    private List<GoalVo> copyList(List<Goal> goalList) {
        List<GoalVo> goalVoList = new ArrayList<>();
        for (Goal goal : goalList) {
            goalVoList.add(copy(goal));
        }
        return goalVoList;
    }

}
