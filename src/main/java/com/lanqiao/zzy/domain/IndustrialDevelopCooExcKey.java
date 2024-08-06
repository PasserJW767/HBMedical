package com.lanqiao.zzy.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * tb_industrial_develop_coo_exc
 * @author 
 */
@Data
@ToString
public class IndustrialDevelopCooExcKey implements Serializable {
    /**
     * 自增id
     */
    private Integer itemid;

    /**
     * UUID
     */
    private String itemcode;

    private static final long serialVersionUID = 1L;
}