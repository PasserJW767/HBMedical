package com.lanqiao.zzy.mapper;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.HomePageSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface HomePageSearchMapper {
    /**
     * 主页--关键字查询
     * @param searchInfo
     * @param pageNum
     * @param pageSize
     * @return
     */
    //多参数时，所有参数都要指定@Param
    public Page<HomePageSearch> selectBySearchInfo(@Param("searchInfo") String searchInfo, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}
