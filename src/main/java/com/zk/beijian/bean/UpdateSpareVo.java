package com.zk.beijian.bean;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author ZK
 * @date 2023/5/17 10:54
 * @description UpdateSpareVo
 */
@Data
public class UpdateSpareVo {
    private Integer id;

    @NotBlank(message = "名称不能为空")
    private String name;


    private String code;

    @NotNull(message="状态不能为空")
    private Boolean status;

    @NotNull(message = "备件小类不能为空")
    private Integer subClassId;

    @NotNull(message = "计划大类不能为空")
    private Integer planClassId;
    private Date modifyTime;
    private String modifyPeople;
    private Integer[] legalPersonId;
}
