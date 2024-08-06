package com.lanqiao.zzy.mapper;

import com.lanqiao.zzy.domain.TbIndustrialDevelopSaleDrug;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TbIndustrialDevelopSaleDrugMapper {
    int deleteByPrimaryKey(TbIndustrialDevelopSaleDrug key);

    int insert(TbIndustrialDevelopSaleDrug record);

    int insertSelective(TbIndustrialDevelopSaleDrug record);

    TbIndustrialDevelopSaleDrug selectByPrimaryKey(TbIndustrialDevelopSaleDrug key);

    int updateByPrimaryKeySelective(TbIndustrialDevelopSaleDrug record);

    int updateByPrimaryKey(TbIndustrialDevelopSaleDrug record);

    TbIndustrialDevelopSaleDrug selectSalMedAndFile(@Param("saleDrug") TbIndustrialDevelopSaleDrug saleDrug);

    List<TbIndustrialDevelopSaleDrug> selectByOrgcode(String OrgCode);

}