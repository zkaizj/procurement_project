package com.zk.subClass.bean;

import lombok.Data;

/**
 * @author ZK
 * @date 2023/4/18 18:41
 * @description PartsetVo
 */
@Data
public class BigSpareVo {
    //页码
    private int pageIndex;
    //每页条数
    private int pageSize;
    //分页查询的第一个参数
    private int offset ;
    private String name;
    private String code;
    private Boolean status;



}
