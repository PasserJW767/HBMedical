package com.lanqiao.zzy.mapper;

import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.TbIndustrialDevelopCooExc;
import com.lanqiao.zzy.domain.TbIndustrialDevelopSciAchi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TbIndustrialDevelopSciAchiMapper {
    int deleteByPrimaryKey(TbIndustrialDevelopSciAchi key);

    int insert(TbIndustrialDevelopSciAchi record);

    int insertSelective(TbIndustrialDevelopSciAchi record);

    List<TbIndustrialDevelopSciAchi> selectByorgCode(TbIndustrialDevelopSciAchi tbIndustrialDevelopSciAchi);

    int updateByPrimaryKeySelective(TbIndustrialDevelopSciAchi record);

    int updateByPrimaryKey(TbIndustrialDevelopSciAchi record);
    Page<TbIndustrialDevelopSciAchi> selectForPage(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
    TbIndustrialDevelopSciAchi selectByPrimaryKey(TbIndustrialDevelopSciAchi key);
    TbIndustrialDevelopSciAchi selectByitemId(int itemid);
    Page<TbIndustrialDevelopSciAchi> selectByTitle(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize,
                                                  @Param("sci") TbIndustrialDevelopSciAchi sci);
}