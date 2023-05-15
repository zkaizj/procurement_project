package com.zk.legalPlant.bean;

import lombok.Data;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotBlank;

/**
 * @author ZK
 * @date 2023/5/12 21:47
 * @description UpdateLegalPlant
 */
@Data
public class UpdateLegalPlant {
    @AssertFalse(message = "当前选项未处于启用状态无法修改")
    private Boolean enabled;

    private Integer id;

    @NotBlank(message ="法人编码不能为空")
    private String legalPersonCode;


    private String legalPersonName;

    @NotBlank(message ="法人工厂编码不能为空")
    private String legalPlantCode;


    private String legalPlantDec;

    private Integer version;

    private String modifyPeople;



}
