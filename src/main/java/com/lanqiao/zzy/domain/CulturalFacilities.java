package com.lanqiao.zzy.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Author 黄舒帆
 * @create 2021/7/29 0:54
 */
@Data
@ToString
public class CulturalFacilities {
    private Integer itemId;
    private String itemCode;
    private String dataCode;
    private String uploader;
    private String uploadereCode;
    private String fileName;
    private String fileType;
    private Double fileSize;
    private String filePath;
    private String creater;
    private Date itemCreateAt;
}
