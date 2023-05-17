package com.zk.beijian.bean;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName beijian
 */
@TableName(value ="beijian")
@Data
public class Beijian implements Serializable {
    private Integer id;

    private String name;

    private String code;

    private Integer status;

    private String remark;

    private Integer subclassId;

    private Integer planclassId;

    private String legalPersonCode;

    private Integer version;

    private Date createTime;

    private String createPeople;

    private Date modifyTime;

    private String modifyPeople;

    private Integer userId;

    private static final long serialVersionUID = 1L;
}