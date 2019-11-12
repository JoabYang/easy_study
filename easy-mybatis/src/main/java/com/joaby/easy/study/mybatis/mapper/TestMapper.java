package com.joaby.easy.study.mybatis.mapper;

import com.joaby.easy.study.mybatis.entity.Test;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/12 15:57
 */
public interface TestMapper {
    Test selectByPrimaryKey(Long id);
}
