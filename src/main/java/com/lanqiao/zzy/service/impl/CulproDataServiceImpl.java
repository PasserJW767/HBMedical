package com.lanqiao.zzy.service.impl;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproData;
import com.lanqiao.zzy.mapper.CulproDataMapper;
import com.lanqiao.zzy.service.ICulproDataService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 贾媛晴
 * @date
 */
@Service("culproDataService")
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class CulproDataServiceImpl implements ICulproDataService {

    @Autowired
    CulproDataMapper culproDataMapper;

    @Override
    public Page<CulproData> selectlaw(int pageNum, int pageSize) {
        return this.culproDataMapper.selectlaw(pageNum,pageSize);
    }

    //根据政策法规的类别来查
    @Override
    public Page<CulproData> selectByDatatype(String datatype, int pageNum, int pageSize) {
        return this.culproDataMapper.selectByDatatype(datatype,pageNum,pageSize);
    }

    //根据itemid找出政策法规对象
    @Override
    public CulproData selectByItemId(Integer itemid) {
        return this.culproDataMapper.selectByItemId(itemid);
    }

//    根据itemid找出对应类别的Page列表
    @Override
    public Page<CulproData> selectAllTypeByItemId(Integer itemid, int pageNum) {
        return this.culproDataMapper.selectAllTypeByItemId(itemid, pageNum, 1);
    }

//    根据itemId计算当前是Page列表的第几位，以得到PageNum
    @Override
    public Integer selectLocationByItemId(Integer itemId) {
        return this.culproDataMapper.selectLocationByItemId(itemId);
    }

//    根据所给的itemId和itemCode查询出对应的文件
    @Override
    public String selectFile(Integer itemId,String itemCode){
        return this.culproDataMapper.selectFile(itemId, itemCode);
    }


    /**
     * 新闻
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Page<CulproData> selectNews(Integer pageNum, Integer pageSize) {
        return culproDataMapper.selectNews(pageNum,pageSize);
    }

    /**
     * 通知中心
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Page<CulproData> selectNotice(Integer pageNum, Integer pageSize) {
        return culproDataMapper.selectNotice(pageNum,pageSize);

    }

    /**
     * 政策法规
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Page<CulproData> selectPolicies(Integer pageNum, Integer pageSize) {
        return culproDataMapper.selectPolicies(pageNum,pageSize);
    }

    /**
     * 办事指南
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Page<CulproData> selectServiceGuide(Integer pageNum, Integer pageSize) {
        return culproDataMapper.selectServiceGuide(pageNum,pageSize);
    }
}
