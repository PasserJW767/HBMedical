package com.lanqiao.zzy.mapper;

import  com.lanqiao.zzy.domain.TbCulproHosp;

public interface TbCulproHospMapper {
    int deleteByPrimaryKey(TbCulproHosp key);

    int insert(TbCulproHosp record);

    int insertSelective(TbCulproHosp record);

    TbCulproHosp selectByPrimaryKey(TbCulproHosp key);

    int updateByPrimaryKeySelective(TbCulproHosp record);

    int updateByPrimaryKey(TbCulproHosp record);
}