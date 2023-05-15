package com.zk.legalPlant.bean;

import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author ZK
 * @date 2023/5/12 12:48
 * @description AddLegalPlantVo
 */
@Data
public class AddLegalPlantVo {
    private String legalPersonName;

    @NotBlank(message="法人编码不允许为空")
    private String legalPersonCode;

    @NotBlank(message="工厂编码不允许为空")
    private String legalPlantCode;

    @NotBlank(message="工厂描述不允许为空")
    private String legalPlantDec;

    @AssertTrue(message = "新添加的法人工厂初始状态应为启用")
    private Boolean enabled;

    private Date createTime;
    private String createPeople;
    private Date modifyTime;
    private String modifyPeople;

}
