package com.lanqiao.zzy.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * tb_culpro_cultural_resources
 * @author 
 */
@Data
@ToString
public class CulproCulturalResourcesKey implements Serializable {
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