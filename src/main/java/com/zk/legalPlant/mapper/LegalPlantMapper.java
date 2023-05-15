package com.zk.legalPlant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zk.legalPlant.bean.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author zk
* @description 针对表【legal_plant(工厂表)】的数据库操作Mapper
* @createDate 2023-05-12 12:18:31
* @Entity generator.bean.LegalPlant
*/
@Mapper
public interface LegalPlantMapper extends BaseMapper<LegalPlant> {

    List<LegalPerson> queryLegalPerson(Integer userId);

    int selectLegalPlantCodeCount(String legalPlantCode);

    int insertLegalPlant(AddLegalPlantVo addLegalPlantVo);

    List<LegalPlant> selectAllLegalPlantCondition(QueryLegalPlantVo queryLegalPlantVo);

    int selectAllLegalPlantConditionCount(QueryLegalPlantVo queryLegalPlantVo);

    int updateStatus(UpdateLegalPlant updateLegalPlant);

    int updateLegalPlant(UpdateLegalPlant updateLegalPlant);
}




