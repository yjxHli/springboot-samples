package com.xjy.week.Article;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yjx
 * @date 2026/4/9
 * @description
 */
@Data
@TableName("article")
public class Article {
    @TableId(type = IdType.INPUT)
    private String id;
    private String title;
    private String introduction;
    private Long viewCount;
    private Integer followersCount;
    private Boolean isFollowing;
    private String banner;
    private Long updated;
}
