package com.lanqiao.zzy.service;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.HomePageSearch;
import org.apache.ibatis.annotations.Param;

public interface IHomePageSearchService {
    /**
     * 主页--关键字查询
     * @param searchInfo
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<HomePageSearch> selectBySearchInfo(String searchInfo, int pageNum, int pageSize);
}
