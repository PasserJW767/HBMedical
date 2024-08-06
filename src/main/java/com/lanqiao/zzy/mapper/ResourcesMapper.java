package com.lanqiao.zzy.mapper;


import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.Resources;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 黄舒帆
 * @create 2021/7/23 17:52
 */

public interface ResourcesMapper {
    public List<Resources> selectResource();

    public Page<Resources> selectYsForPage(@Param("pageNum") int pageNum,
                                           @Param("pageSize") int pageSize);

    public Page<Resources> selectLpForPage(@Param("pageNum") int pageNum,
                                           @Param("pageSize") int pageSize);

    public Page<Resources> selectMjForPage(@Param("pageNum") int pageNum,
                                           @Param("pageSize") int pageSize);

    public List<Resources> selectAllDetails(String type);

    public Resources selectDetialsById(Integer itemId);
}
