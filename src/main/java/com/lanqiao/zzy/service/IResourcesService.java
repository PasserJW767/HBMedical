package com.lanqiao.zzy.service;


import com.github.pagehelper.Page;
import com.lanqiao.zzy.domain.Resources;

import java.util.List;

/**
 * @Author 黄舒帆
 * @create 2021/7/23 16:23
 */
public interface IResourcesService {

    public Page<Resources> selectYsForPage(int pageNum, int pageSize);
    public Page<Resources> selectLpForPage(int pageNum, int pageSize);
    public Page<Resources> selectMjForPage(int pageNum, int pageSize);
    public List<Resources> selectAllDetails(String type);
    public Resources selectDetialsById(Integer itemId);
}
