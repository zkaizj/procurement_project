package com.zk.beijian.bean;

import lombok.Data;

/**
 * @author ZK
 * @date 2023/5/16 18:11
 * @description QueryBeiVo
 */
@Data
public class QueryBeiVo {
    private String name;
    private String code;
    private Boolean status;
    private Integer pageIndex;
    private Integer pageSize;
    private Integer offset;
}
