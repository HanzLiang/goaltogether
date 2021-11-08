package com.mszlu.blog.vo.params;

import com.mszlu.blog.vo.TagVo;
import lombok.Data;

import java.util.List;

@Data
public class ArticleParam {

    private Long id;

    private String summary;

    private List<TagVo> tags;

    private String title;
}
