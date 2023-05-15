package com.zk.subClass.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author ZK
 * @date 2023/5/3 14:20
 * @description UpdateBigSpareVo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBigSpareVo {
    @NotNull
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String code;

    private Boolean status;
    private String statusName;
    private String remark;

    private String createPeople;

    private Integer version;

    private String modifyPeople;
    private Date modifyDate;
    private Date createDate;


}
