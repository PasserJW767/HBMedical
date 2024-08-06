package com.lanqiao.zzy.mapper;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.CulproHosp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : 莫起润
 * @date : 2021/8/1/11:08
 */
@Mapper
public interface CulproHospMapper {

    /**
     * 首页医院数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<CulproHosp> selectHospitalForHome(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);



    /**
     * 根据条件分页查询“医院”
     * @param culproHosp
     * @return
     */
    Page<CulproHosp> selectHospitalByCondiction(@Param("culproHosp") CulproHosp culproHosp,
                                                @Param("pageNum") Integer pageNum,
                                                @Param("pageSize") Integer pageSize);

    /**
     * 查询医院所有的市
     * @return
     */
    List<String> selectHospitalCity();

    /**
     * 查询总记录数
     * @return
     */


    /**
     * 根据itemid查询页码
     * @param itemid
     * @return
     */
    public Integer selectPageNum(Integer itemid);


}