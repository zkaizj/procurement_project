package com.zk.subClass.bean;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @TableName big_spare
 */
@TableName(value ="big_spare")
@Data
public class BigSpare implements Serializable {
    private Integer id;
    @NotBlank(message="备件大类名称不能为空")

    private String name;
    @NotBlank(message="备件大类编码不能为空")
    private String code;

    private Boolean status;

    private String statusName;

    private Integer version;

    private Date createDate;

    private String remark;

    private String createPeople;

    private Date modifyDate;

    private String modifyPeople;

    private String detailed;

    private static final long serialVersionUID = 1L;
}