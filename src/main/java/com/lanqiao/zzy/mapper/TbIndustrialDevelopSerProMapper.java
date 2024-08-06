package com.lanqiao.zzy.mapper;

import com.lanqiao.zzy.domain.TbIndustrialDevelopSerPro;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbIndustrialDevelopSerProMapper {
    int deleteByPrimaryKey(TbIndustrialDevelopSerPro key);
    int insert(TbIndustrialDevelopSerPro record);
    int insertSelective(TbIndustrialDevelopSerPro record);
    List<TbIndustrialDevelopSerPro> selectByorgCode(TbIndustrialDevelopSerPro tbIndustrialDevelopSerPro);
    int updateByPrimaryKeySelective(TbIndustrialDevelopSerPro record);
    int updateByPrimaryKey(TbIndustrialDevelopSerPro record);
    TbIndustrialDevelopSerPro selectByPk(TbIndustrialDevelopSerPro tbIndustrialDevelopSerPro);
    TbIndustrialDevelopSerPro selectBefore(int itemid);
    TbIndustrialDevelopSerPro selectAfter(int itemid);
    }