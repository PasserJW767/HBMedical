package com.lanqiao.zzy.domain;

import lombok.Data;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * organization
 * @author 
 */
@Data
@ToString
public class Organization implements Serializable {
    private Integer itemid;

    /**
     * 唯一标识UUID
     */
    private String itemcode;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 机构编码
     */
    private String orgCode;

    /**
     * 描述
     */
    private String orgDescription;

    /**
     * 标识符(用来标识机构类型)
     */
    private String orgIdentify;

    /**
     * 所在地市
     */
    private String orgLocate;

    /**
     * 审核状态，登录时查询此状态，0不通过，1通过
     */
    private String auditStatus;

    /**
     * 备用字段
     */
    private String backup2;

    /**
     * 左值
     */
    private Integer left;

    /**
     * 右值
     */
    private Integer right;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 创建人
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

    private String  areaCoverd;
    private String address;
    private String contacts;
    private String phone;
    //统计地区机构数量
    private int num;


    //医院
    TbCulproHosp tbCulproHosp;

    //企业
    TbIndustrialDevelopChiMed tbIndustrialDevelopChiMed;

    //学校
    TbIndustrialDevelopSchool tbIndustrialDevelopSchool;

    //科研院所、技术服务机构、旅游养生机构
    TbIndustrialDevelopTecSerOrg tbIndustrialDevelopTecSerOrg;
    private static final long serialVersionUID = 1L;
}