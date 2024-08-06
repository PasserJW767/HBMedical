package com.lanqiao.zzy.service.impl;

import com.lanqiao.zzy.mapper.HomePageCenterDevelopMapper;
import com.lanqiao.zzy.service.IHomePageCenterDevelopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("homePageCenterDevelopService")
//支持事务，增加、删除、更新操作单独使用propagation = Propagation.SUPPORTS
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class HomePageCenterDevelopImpl implements IHomePageCenterDevelopService {

    @Autowired
    HomePageCenterDevelopMapper homePageCenterDevelopMapper;


    /**
     * 根据产业发展 标识符(用来标识机构类型) 得到每个种类的数量
     *
     * @param orgidentify
     * @return
     */
    @Override
    public int calCountByOrgidentify(String orgidentify) {
        return this.homePageCenterDevelopMapper.calCountByOrgidentify(orgidentify);
    }
}
