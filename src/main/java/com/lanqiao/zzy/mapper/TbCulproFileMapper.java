package com.lanqiao.zzy.mapper;

import  com.lanqiao.zzy.domain.TbCulproFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TbCulproFileMapper {
    int deleteByPrimaryKey(TbCulproFile key);

    int insert(TbCulproFile record);

    int insertSelective(TbCulproFile record);

    List<TbCulproFile> selectByOrgCode(String OrgCode);

    int updateByPrimaryKeySelective(TbCulproFile record);

    int updateByPrimaryKey(TbCulproFile record);
}