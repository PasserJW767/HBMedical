package com.lanqiao.zzy.service.impl;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.Resources;
import com.lanqiao.zzy.mapper.ResourcesMapper;
import com.lanqiao.zzy.service.IResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author 黄舒帆
 * @create 2021/7/23 16:24
 */
@Service("resourcesService")
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class ResourcesServiceImpl implements IResourcesService {

    @Autowired
    ResourcesMapper resourcesMapper;

    @Override
    public Page<Resources> selectYsForPage(int pageNum,int pageSize) {
        return this.resourcesMapper.selectYsForPage(pageNum,pageSize);
    }

    @Override
    public Page<Resources> selectLpForPage(int pageNum,int pageSize) {
        return this.resourcesMapper.selectLpForPage(pageNum,pageSize);
    }

    @Override
    public Page<Resources> selectMjForPage(int pageNum, int pageSize) {
        return this.resourcesMapper.selectMjForPage(pageNum,pageSize);
    }

    @Override
    public List<Resources> selectAllDetails(String type) {
        return this.resourcesMapper.selectAllDetails(type);
    }

    @Override
    public Resources selectDetialsById(Integer itemId) {
        return this.resourcesMapper.selectDetialsById(itemId);
    }
}
