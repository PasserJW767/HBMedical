package com.lanqiao.zzy.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 * tb_industrial_develop_ser_pro
 * @author 
 */
@Data
@ToString
public class TbIndustrialDevelopSerPro  implements Serializable {
    /**
     * 自增id
     */
    private Integer itemid;

    /**
     * UUID
     */
    private String itemcode;
    /**
     * 服务项目名称
     */
    private String serviceProject;

    /**
     * 项目收费
     */
    private String projectCost;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 服务项目介绍
     */
    private String projectIntroduce;

    /**
     * 浏览次数
     */
    private Integer visitNum;

    /**
     * 数据状态
     */
    private String status;

    /**
     * 用户所在机构code
     */
    private String orgCode;

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