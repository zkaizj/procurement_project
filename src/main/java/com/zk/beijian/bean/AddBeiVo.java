package com.zk.beijian.bean;

import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author ZK
 * @date 2023/5/16 19:28
 * @description AddBeiVo
 */
@Data
public class AddBeiVo {

    private Integer id;

    @NotBlank(message = "名称不能为空")
    private String name;

    @NotBlank(message = "编码不能为空")
    private String code;

    @AssertTrue(message = "初始状态应为启用")
    private Boolean status;

    @NotNull(message = "备件小类不能为空")
    private Integer subClassId;

    @NotNull(message = "计划大类不能为空")
    private Integer planClassId;

    private Integer[] legalPersonIds;
    private Integer legalPersonId;
    private String createPeople;
    private String modifyPeople;
    private String legalPersonCode;

    private Integer userId;
}
