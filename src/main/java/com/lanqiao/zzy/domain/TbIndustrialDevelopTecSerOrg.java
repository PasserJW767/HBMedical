package com.lanqiao.zzy.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 * tb_industrial_develop_tec_ser_org
 * @author 
 */
@Data
@ToString
public class TbIndustrialDevelopTecSerOrg implements Serializable {
    /**
     * 自增id
     */
    private Integer itemid;

    /**
     * UUID
     */
    private String itemcode;
    /**
     * 企业名称、院所名称、基地名称
     */
    private String name;

    /**
     * 旅游养生机构占地面积
     */
    private String areaCoverd;

    /**
     * 旅游养生机构特色服务
     */
    private String specialService;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 地址省份
     */
    private String addressPro;

    /**
     * 地址市
     */
    private String addressCity;

    /**
     * 地址县
     */
    private String addressCountry;

    /**
     * 手动输入地址
     */
    private String address;

    /**
     * 在线地址
     */
    private String onlineAddress;

    /**
     * 简介
     */
    private String intruduce;

    /**
     * 修改以后提交信息数据状态
     */
    private String status;

    /**
     * 不通过理由
     */
    private String reason;

    /**
     * 用户所在机构code
     */
    private String orgCode;

    /**
     * 区别数据
     */
    private String type;

    /**
     * 创建者
     */
    private String creater;

    /**
     * 创建时间
     */
    private Date itemcreateat;

    /**
     * 修改人
     */
    private String updater;

    /**
     * 修改时间
     */
    private Date itemupdateat;

    private static final long serialVersionUID = 1L;
}