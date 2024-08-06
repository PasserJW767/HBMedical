package com.lanqiao.zzy.mapper;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CulproDataMapper {
    CulproData selectByPrimaryKey(CulproData key);

    public Page<CulproData> selectlaw(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    public Page<CulproData> selectByDatatype(@Param("datatype") String datatype, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    //根据itemid找出政策法规对象
    public CulproData selectByItemId(Integer itemid);

    // 根据itemid找出对应类别的Page列表
    public Page<CulproData> selectAllTypeByItemId(Integer itemId,
                                                  @Param("pageNum") int pageNum,
                                                  @Param("pageSize") int pageSize);

//    根据itemId计算当前是Page列表的第几位，以得到PageNum
    public Integer selectLocationByItemId(Integer itemId);

//    根据所给的itemId和itemCode查询出对应的文件
    public String selectFile(@Param("itemId") Integer itemId, @Param("itemCode") String itemCode);

    //根据itemid找出政策法规对象的下一个
//    public CulproData selectByItemIdNext(Integer itemid);

    //根据itemid找出政策法规对象的上一个
//    public CulproData selectByItemIdLast(Integer itemid);

    Page<CulproData> selectNews(@Param("pageNum") Integer pageNum, @Param("pageSize")Integer pageSize);
    Page<CulproData> selectNotice(@Param("pageNum") Integer pageNum,@Param("pageSize")Integer pageSize);
    Page<CulproData> selectPolicies(@Param("pageNum") Integer pageNum,@Param("pageSize")Integer pageSize);
    Page<CulproData> selectServiceGuide(@Param("pageNum") Integer pageNum,@Param("pageSize")Integer pageSize);

}