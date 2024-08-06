package com.lanqiao.zzy.service.impl;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.HomePageSearch;
import com.lanqiao.zzy.mapper.HomePageSearchMapper;
import com.lanqiao.zzy.service.IHomePageSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("homePageSearchService")
//支持事务，增加、删除、更新操作单独使用propagation = Propagation.SUPPORTS
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class HomePageSearchImpl implements IHomePageSearchService {

    @Autowired
    HomePageSearchMapper homePageSearchMapper;

    /**
     * 主页--关键字查询
     *
     * @param searchInfo
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Page<HomePageSearch> selectBySearchInfo(String searchInfo, int pageNum, int pageSize) {
        return this.homePageSearchMapper.selectBySearchInfo(searchInfo,pageNum,pageSize);
    }
}
