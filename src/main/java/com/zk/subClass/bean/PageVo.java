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

    // 总页数
    private Integer  totalPage;
    // 当前页
    private Integer  currentPage;
    //数据条数（总数据）
    private Integer totalNumber;
    // 集合信息
    private List<T> dataList;
}
