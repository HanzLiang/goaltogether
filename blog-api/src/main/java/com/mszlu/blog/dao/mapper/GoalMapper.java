package com.mszlu.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mszlu.blog.dao.pojo.Goal;

import java.util.List;

public interface GoalMapper extends BaseMapper<Goal> {

    List<Goal> listGoals(String userName);
}
