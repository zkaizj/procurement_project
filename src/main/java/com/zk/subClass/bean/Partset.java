package com.zk.subClass.bean;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName partset
 */
@TableName(value ="partset")
@Data
public class Partset implements Serializable {
    private Integer id;

    private String name;

    private String code;

    private String remark;

    private Boolean status;

    private Integer version;

    private Date createDate;

    private String createPeople;

    private Date modifyDate;

    private String modifyPeople;


    private static final long serialVersionUID = 1L;
}