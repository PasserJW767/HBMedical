package com.lanqiao.zzy.mapper;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.HealthCareSciKnow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Entity .domain.com.lanqiao.zzy.domain.HealthCareSciKnow
 */
@Mapper
public interface HealthCareSciKnowMapper {

    /*首页：科普知识*/
    Page<HealthCareSciKnow> selectHealthCareSciKnowForHome(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    public Page<HealthCareSciKnow> selectAllForSciKnow(@Param("pageNum" )int pageNum, @Param("pageSize") int pageSize);

    public HealthCareSciKnow selectSciDetailById(Integer itemId);

    public List<HealthCareSciKnow> selectSciAllDetail();

}
