package com.mszlu.blog.vo.params;

import com.mszlu.blog.vo.TagVo;
import lombok.Data;

import java.util.List;

@Data
public class GoalParam {

    private String name;

    private String description;

    private Integer reward;

    private String userName;


}
