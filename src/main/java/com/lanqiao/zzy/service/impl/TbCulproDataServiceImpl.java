package com.lanqiao.zzy.service.impl;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.TbCulproData;
import com.lanqiao.zzy.mapper.TbCulproDataMapper;
import com.lanqiao.zzy.service.ITbCulproDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tbCulproDataService")
public class TbCulproDataServiceImpl implements ITbCulproDataService {
    @Autowired
    TbCulproDataMapper tbCulproDataMapper;
    /*通知公告*/
    @Override
    public Page<TbCulproData> selectFoPages(int pageNum, int pageSize) {
        return tbCulproDataMapper.selectFoPages(pageNum, pageSize);
    }

    @Override
    public TbCulproData selectByPrimaryKey(TbCulproData tbCulproData) {
        return tbCulproDataMapper.selectByPrimaryKey(tbCulproData);
    }

    @Override
    public TbCulproData selectBefore(TbCulproData tbCulproData) {
        return tbCulproDataMapper.selectBefore(tbCulproData);
    }

    @Override
    public TbCulproData selectAfter(TbCulproData tbCulproData) {
        return tbCulproDataMapper.selectAfter(tbCulproData);
    }

    /*新闻*/
    @Override
    public TbCulproData selectByPrimaryKeyNew(TbCulproData key) {
        return tbCulproDataMapper.selectByPrimaryKeyNew(key);
    }

    @Override
    public Page<TbCulproData> selectFoPagesNew(int pageNum, int pageSize) {
        return tbCulproDataMapper.selectFoPagesNew(pageNum, pageSize);
    }

    @Override
    public TbCulproData selectBeforeNew(TbCulproData tbCulproData) {
        return tbCulproDataMapper.selectBeforeNew(tbCulproData);
    }

    @Override
    public TbCulproData selectAfterNew(TbCulproData tbCulproData) {
        return tbCulproDataMapper.selectAfterNew(tbCulproData);
    }

/*办事指南*/
    @Override
    public TbCulproData selectByPrimaryKeyServiceguide(TbCulproData key) {
        return tbCulproDataMapper.selectByPrimaryKeyServiceguide(key);
    }

    @Override
    public Page<TbCulproData> selectFoPagesServiceguide(int pageNum, int pageSize) {
        return tbCulproDataMapper.selectFoPagesServiceguide(pageNum, pageSize);
    }

    @Override
    public TbCulproData selectBeforeServiceguide(TbCulproData tbCulproData) {
        return tbCulproDataMapper.selectBeforeServiceguide(tbCulproData);
    }

    @Override
    public TbCulproData selectAfterServiceguide(TbCulproData tbCulproData) {
        return tbCulproDataMapper.selectAfterServiceguide(tbCulproData);
    }

}
