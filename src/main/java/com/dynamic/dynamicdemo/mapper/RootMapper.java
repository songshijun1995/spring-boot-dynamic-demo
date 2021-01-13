package com.dynamic.dynamicdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

public interface RootMapper<T> extends BaseMapper<T> {

    /**
     * 批量新增
     */
    int insertBatchSomeColumn(Collection<T> entityList);

    /**
     * 自定义批量插入
     * 如果要自动填充，@Param(xx) xx参数名必须是 list/collection/array 3个的其中之一
     */
    int insertBatch(@Param("list") Collection<T> list);

    /**
     * 自定义批量更新，条件为主键
     * 如果要自动填充，@Param(xx) xx参数名必须是 list/collection/array 3个的其中之一
     */
    int updateBatch(@Param("list") Collection<T> list);
}
