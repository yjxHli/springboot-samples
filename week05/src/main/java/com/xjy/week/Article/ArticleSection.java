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
@TableName("article_section")
public class ArticleSection {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String articleId;
    private String sectionId;
    private String sectionTitle;
}