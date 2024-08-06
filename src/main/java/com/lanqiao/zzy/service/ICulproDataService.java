package com.lanqiao.zzy.service;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 贾媛晴
 * @date
 */
public interface ICulproDataService {
    public Page<CulproData> selectlaw(int pageNum, int pageSize);

    //根据政策法规的类别来查
    public Page<CulproData> selectByDatatype(@Param("datatype") String datatype, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    //根据itemid找出政策法规对象
    public CulproData selectByItemId(Integer itemid);

    // 根据itemid找出对应类别的Page列表
    public Page<CulproData> selectAllTypeByItemId(Integer itemid,
                                                  @Param("pageNum") int pageNum);

//    根据itemId计算当前是Page列表的第几位，以得到PageNum
    public Integer selectLocationByItemId(Integer itemId);

//    根据所给的itemId和itemCode查询出对应的文件
    public String selectFile(Integer itemId, String itemCode);

    Page<CulproData> selectNews(Integer pageNum, Integer pageSize);
    Page<CulproData> selectNotice( Integer pageNum,Integer pageSize);
    Page<CulproData> selectPolicies( Integer pageNum,Integer pageSize);
    Page<CulproData> selectServiceGuide( Integer pageNum,Integer pageSize);
}
