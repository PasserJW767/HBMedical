package com.lanqiao.zzy.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 * 医院和专科关联关系表
 * @TableName tb_culpro_hosp_specialty_ref
 */
@Data
@ToString
public class CulproHospSpecialtyRef implements Serializable {
    /**
     * 自增id
     */
    private Integer itemid;

    /**
     * UUID
     */
    private String itemcode;

    /**
     * 医院code(hosp中itemCode)
     */
    private String hospitalCode;

    /**
     * 专科code
     */
    private String specialtyCode;

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

    private CulproSpecialty culproSpecialty;

    private static final long serialVersionUID = 1L;
}