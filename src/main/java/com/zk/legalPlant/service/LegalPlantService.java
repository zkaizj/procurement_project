package com.zk.legalPlant.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.commen.util.ResultVo;
import com.zk.legalPlant.bean.AddLegalPlantVo;
import com.zk.legalPlant.bean.LegalPlant;
import com.zk.legalPlant.bean.QueryLegalPlantVo;
import com.zk.legalPlant.bean.UpdateLegalPlant;

/**
* @author zk
* @description 针对表【legal_plant(工厂表)】的数据库操作Service
* @createDate 2023-05-12 12:18:31
*/
public interface LegalPlantService extends IService<LegalPlant> {

    ResultVo insertLegalPlant(AddLegalPlantVo addLegalPlantVo);

    ResultVo queryLegalPlant(QueryLegalPlantVo queryLegalPlantVo);

    ResultVo updataStatus(UpdateLegalPlant updateLegalPlant);

    ResultVo updateLegalPlant(UpdateLegalPlant updateLegalPlant);
}
