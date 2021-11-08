package com.mszlu.blog.service;

import com.mszlu.blog.vo.Result;
import com.mszlu.blog.vo.params.ArticleParam;
import com.mszlu.blog.vo.params.GoalParam;

public interface GoalService {

    Result listGoals(String userName);

    Result createGoals(GoalParam goalParam);

//    Result deleteGoals(GoalParam goalParam);
//
//    Result completeGoals(GoalParam goalParam);
}

