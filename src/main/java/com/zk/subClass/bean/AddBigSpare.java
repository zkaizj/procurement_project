package com.zk.subClass.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;

/**
 * @author ZK
 * @date 2023/4/25 13:29
 * @description AddBigSpare
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBigSpare {
    @NotBlank(message = "计划大类编码不能为空!")
    private String code;
    @NotBlank(message = "计划大类名称不能为空!")
    private String name;
    private String remark;
    @AssertTrue(message = "初始状态请设为启用!")
    private Boolean status;
    private String createPeople;

    private String createDate;
}
