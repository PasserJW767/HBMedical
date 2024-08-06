package com.lanqiao.zzy.service;

public interface IHomePageCenterDevelopService {

    /**根据产业发展 标识符(用来标识机构类型) 得到每个种类的数量
     * @param orgidentify
     * @return
     */
    public int calCountByOrgidentify(String orgidentify);
}
