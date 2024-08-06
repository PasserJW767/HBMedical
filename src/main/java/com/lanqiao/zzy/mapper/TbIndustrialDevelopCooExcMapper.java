package com.lanqiao.zzy.mapper;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.TbIndustrialDevelopCooExc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TbIndustrialDevelopCooExcMapper {
    int deleteByPrimaryKey(TbIndustrialDevelopCooExc key);

    int insert(TbIndustrialDevelopCooExc record);

    int insertSelective(TbIndustrialDevelopCooExc record);



    int updateByPrimaryKeySelective(TbIndustrialDevelopCooExc record);

    int updateByPrimaryKey(TbIndustrialDevelopCooExc record);

    Page<TbIndustrialDevelopCooExc> selectForPage(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
    TbIndustrialDevelopCooExc selectByPrimaryKey(TbIndustrialDevelopCooExc key);
    TbIndustrialDevelopCooExc selectByitemid(int itemid);
    Page<TbIndustrialDevelopCooExc> selectByTitle(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize,
                                                                                          @Param("cooexc") TbIndustrialDevelopCooExc cooexc);
}