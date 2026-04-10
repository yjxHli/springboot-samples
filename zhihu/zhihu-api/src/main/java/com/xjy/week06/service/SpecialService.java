package com.xjy.week06.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xjy.week06.entity.Special;
import org.springframework.stereotype.Service;

/**
 * @author yjx
 * @date 2026/4/9
 * @description
 */

public interface SpecialService {
    Page<Special> selectByTitle(String title, int pageNum, int pageSize);

    Special getById(String id);

}
