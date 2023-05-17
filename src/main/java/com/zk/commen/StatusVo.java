package com.zk.commen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZK
 * @date 2023/5/8 11:14
 * @description StatusVo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusVo {
    private Boolean value;
    private String label;
}
