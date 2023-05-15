package com.zk.legalPlant.bean;

import lombok.Data;

/**
 * @author ZK
 * @date 2023/5/12 19:18
 * @description QueryLegalPlantVo
 */
@Data
public class QueryLegalPlantVo {
    private Boolean enabled;

    private String legalPersonCode;

    private String legalPlantCode;

    private String legalPlantDec;

    private Integer pageIndex;

    private Integer pageSize;

    private Integer offset;
}
