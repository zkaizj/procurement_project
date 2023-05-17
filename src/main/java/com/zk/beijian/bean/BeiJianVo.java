package com.zk.beijian.bean;

import lombok.Data;

/**
 * @author ZK
 * @date 2023/5/16 19:09
 * @description BeiJianVo
 */
@Data
public class BeiJianVo {
    private Integer id;
    private String name;
    private String code;
    private Boolean status;
    private String statusName;
    private String subClassName;
    private String planClassName;
    private String legalPersonNames;
}
