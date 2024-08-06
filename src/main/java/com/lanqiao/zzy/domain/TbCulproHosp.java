package com.lanqiao.zzy.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 * tb_culpro_hosp
 * @author 
 */
@Data
@ToString
public class TbCulproHosp  implements Serializable {
    /**
     * 自增id
     */
    private Integer itemid;

    /**
     * UUID
     */
    private String itemcode;
    /**
     * 医院名称
     */
    private String hospitalName;

    /**
     * 医院等级
     */
    private String hospitalLevel;

    /**
     * 重点专科
     */
    private String hospitalKeySpecialty;

    /**
     * 医院简介
     */
    private String hospitalBriefIntroduce;

    /**
     * 医院介绍
     */
    private String hospitalIntroduce;

    /**
     * 联系电话
     */
    private String hospitalTelephone;

    private String hospitalAddressPro;

    /**
     * 医院所在市
     */
    private String hospitalAddressCity;

    /**
     * 医院所在县
     */
    private String hospitalAddressCountry;

    /**
     * 医院地址
     */
    private String hospitalAddress;

    /**
     * 链接地址
     */
    private String hospitalLink;

    /**
     * 数据状态
     */
    private String hospitalStatus;

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

    private String orgCode;

    private static final long serialVersionUID = 1L;
}