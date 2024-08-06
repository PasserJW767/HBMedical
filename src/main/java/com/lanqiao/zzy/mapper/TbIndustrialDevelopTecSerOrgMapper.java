package com.lanqiao.zzy.mapper;

import com.lanqiao.zzy.domain.TbIndustrialDevelopTecSerOrg;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbIndustrialDevelopTecSerOrgMapper {
    int deleteByPrimaryKey(TbIndustrialDevelopTecSerOrg key);

    int insert(TbIndustrialDevelopTecSerOrg record);

    int insertSelective(TbIndustrialDevelopTecSerOrg record);

    TbIndustrialDevelopTecSerOrg selectByPrimaryKey(TbIndustrialDevelopTecSerOrg key);

    int updateByPrimaryKeySelective(TbIndustrialDevelopTecSerOrg record);

    int updateByPrimaryKey(TbIndustrialDevelopTecSerOrg record);
}