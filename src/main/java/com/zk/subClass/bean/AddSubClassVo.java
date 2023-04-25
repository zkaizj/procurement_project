package com.zk.subClass.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author ZK
 * @date 2023/4/23 18:13
 * @description AddSubClassVo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddSubClassVo {

    @NotBlank(message = "备件小类名称不能为空")
    private String name;

    @NotBlank(message = "备件小类编码不能为空")
    private String code;

    private String remark;

    private boolean status;

    private String createPeople;

    private String createDate;
}
