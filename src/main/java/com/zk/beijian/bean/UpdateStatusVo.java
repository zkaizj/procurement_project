package com.zk.beijian.bean;

import lombok.Data;

/**
 * @author ZK
 * @date 2023/5/17 10:50
 * @description UpdateStatusVo
 */
@Data
public class UpdateStatusVo {
    private Boolean status;
    private Integer id;
    private String modifyPeople;
}
