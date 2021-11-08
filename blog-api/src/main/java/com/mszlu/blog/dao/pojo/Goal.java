package com.mszlu.blog.dao.pojo;

import com.mszlu.blog.vo.TagVo;
import lombok.Data;

import java.util.List;

@Data
public class Goal {

    private Long id;

    private String userName;

    private String name;

    private String description;

    private Integer reward;

    private Long createDate;

    private String status;

    // private List<TagVo> tags;

}