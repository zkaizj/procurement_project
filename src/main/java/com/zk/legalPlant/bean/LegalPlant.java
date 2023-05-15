package com.zk.legalPlant.bean;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName legal_plant
 */
@TableName(value ="legal_plant")
@Data
public class LegalPlant implements Serializable {
    private Integer id;

    private String legalPlantCode;

    private String legalPlantDec;

    private Boolean enabled;


    private String legalPersonCode;

    private String legalPersonName;

    private Date createTime;

    private String createPeople;

    private String modifyPeople;

    private Date modifyTime;

    private Integer version;

    private static final long serialVersionUID = 1L;
}