package com.zk.subClass.bean;

import lombok.Data;

import java.util.List;

/**
 * @author ZK
 * @date 2023/4/18 20:32
 * @description PageVo
 */
@Data
public class PageVo<T> {

    // 总条数
    private Integer  totalPage;
    // 当前页
    private Integer  currentPage;
    //每页条数
    private Integer totalNumber;
    // 集合信息
    private List<T> dataList;
}
