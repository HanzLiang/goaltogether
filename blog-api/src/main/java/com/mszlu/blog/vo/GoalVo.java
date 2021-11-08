package com.mszlu.blog.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

@Data
public class GoalVo {

    private String id;

    private String userName;

    private String name;

    private String description;

    private Integer reward;
    /**
     * 创建时间
     */
    private String createDate;

    private String status;

    private List<TagVo> tags;

}
