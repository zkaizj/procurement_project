package com.zk.subClass.bean;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author ZK
 * @date 2023/4/23 20:29
 * @description UpDateSubClassVo
 */
@Data
public class UpDateSubClassVo {
    private Integer id;
    @NotBlank(message = "备件小类名称不能为空")
    private String name;

    @NotBlank(message = "备件小类编码不能为空")
    private String code;

    private String remark;

    private boolean status;

    private String modifyPeople;

    private Date modifyDate;
}
