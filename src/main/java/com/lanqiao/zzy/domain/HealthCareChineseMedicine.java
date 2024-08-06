package com.lanqiao.zzy.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 * 中药常识数据记录表
 * @TableName tb_health_care_chinese_medicine
 */
@Data
@ToString
public class HealthCareChineseMedicine implements Serializable {
    /**
     * 自增id
     */
    private Integer itemid;

    /**
     * UUID
     */
    private String itemcode;

    /**
     * 中药名称
     */
    private String chineseMedicineName;

    /**
     * 中药类别
     */
    private String chineseMedicineType;

    /**
     * 别名
     */
    private String chineseMedicineAlias;

    /**
     * 来源
     */
    private String chineseMedicineSource;

    /**
     * 采制
     */
    private String chineseMedicineHarvesting;

    /**
     * 性味
     */
    private String chineseMedicineTaste;

    /**
     * 归经
     */
    private String chineseMedicineMerTro;

    /**
     * 功效主治
     */
    private String chineseMedicineEffect;

    /**
     * 用法用量
     */
    private String chineseMedicineUsage;

    /**
     * 数据状态
     */
    private String chineseMedicineStatus;

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