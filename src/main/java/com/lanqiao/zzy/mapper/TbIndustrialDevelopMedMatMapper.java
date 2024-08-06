package com.lanqiao.zzy.mapper;

import com.github.pagehelper.Page;
import  com.lanqiao.zzy.domain.TbIndustrialDevelopMedMat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TbIndustrialDevelopMedMatMapper {
    int deleteByPrimaryKey(TbIndustrialDevelopMedMat key);

    int insert(TbIndustrialDevelopMedMat record);

    int insertSelective(TbIndustrialDevelopMedMat record);

    TbIndustrialDevelopMedMat selectByPrimaryKey(TbIndustrialDevelopMedMat key);

    int updateByPrimaryKeySelective(TbIndustrialDevelopMedMat record);

    int updateByPrimaryKey(TbIndustrialDevelopMedMat record);

    List<TbIndustrialDevelopMedMat> selectByplace(String placeName);
    List<TbIndustrialDevelopMedMat> selectNum();
    TbIndustrialDevelopMedMat selectByOrgCodeAndNameName(@Param("medMat") TbIndustrialDevelopMedMat medMat);
    List<TbIndustrialDevelopMedMat> selectByLocate();
    List<TbIndustrialDevelopMedMat> selectByName();
    Page<TbIndustrialDevelopMedMat> selectMedMatList(@Param("med") TbIndustrialDevelopMedMat med,
                                                                                                         @Param("pageNum") int pageNum,
                                                                                                         @Param("pageSize") int pageSize);
    List<TbIndustrialDevelopMedMat> selectByorgcode(String orgcode);
}