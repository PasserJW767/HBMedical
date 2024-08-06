package com.lanqiao.zzy.mapper;

import com.lanqiao.zzy.domain.CulproHospSpecialtyRef;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : 莫起润
 * @date : 2021/8/1/20:55
 */
@Mapper
public interface CulproHospSpecialtyRefMapper {
    public List<CulproHospSpecialtyRef> selectCulproSpecialtyByHospCode(String itemcode);
}
