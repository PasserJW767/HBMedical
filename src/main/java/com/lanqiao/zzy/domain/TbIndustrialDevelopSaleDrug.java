package com.lanqiao.zzy.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 * tb_industrial_develop_sale_drug
 * @author 
 */
@Data
@ToString
public class TbIndustrialDevelopSaleDrug  implements Serializable {
    /**
     * 自增id
     */
    private Integer itemid;

    /**
     * UUID
     */
    private String itemcode;
    /**
     * 药品名称
     */
    private String drugName;

    /**
     * 功能主治
     */
    private String functionIndications;

    /**
     * 用法用量
     */
    private String usage;

    /**
     * 不良反应
     */
    private String adverseReactions;

    /**
     * 禁忌
     */
    private String taboo;

    /**
     * 规格
     */
    private String specifications;

    /**
     * 注意事项
     */
    private String careful;

    /**
     * 贮藏
     */
    private String storage;

    /**
     * 包装
     */
    private String packing;

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

    //图片
    TbCulproFile tbCulproFile;

    private static final long serialVersionUID = 1L;
}