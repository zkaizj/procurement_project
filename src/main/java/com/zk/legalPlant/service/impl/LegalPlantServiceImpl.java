package com.zk.legalPlant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zk.commen.util.ResultVo;
import com.zk.legalPlant.bean.AddLegalPlantVo;
import com.zk.legalPlant.bean.LegalPlant;
import com.zk.legalPlant.bean.QueryLegalPlantVo;
import com.zk.legalPlant.bean.UpdateLegalPlant;
import com.zk.legalPlant.mapper.LegalPlantMapper;
import com.zk.legalPlant.service.LegalPlantService;
import com.zk.subClass.bean.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author zk
* @description 针对表【legal_plant(工厂表)】的数据库操作Service实现
* @createDate 2023-05-12 12:18:31
*/
@Service
public class LegalPlantServiceImpl extends ServiceImpl<LegalPlantMapper, LegalPlant>
    implements LegalPlantService {
    @Autowired
    private LegalPlantMapper legalPlantMapper;
    //添加工厂
    @Override
    public ResultVo insertLegalPlant(AddLegalPlantVo addLegalPlantVo) {

        //判断编码是否重复
        int count=legalPlantMapper.selectLegalPlantCodeCount(addLegalPlantVo.getLegalPlantCode());
        if (count>0){
            return ResultVo.error("法人工厂编码重复，请重新输入");
        }else{
            addLegalPlantVo.setCreatePeople("赵凯");
            addLegalPlantVo.setModifyPeople("赵凯");
            int tag=legalPlantMapper.insertLegalPlant(addLegalPlantVo);
            return ResultVo.success(tag>0);
        }
    }

    @Override
    public ResultVo queryLegalPlant(QueryLegalPlantVo queryLegalPlantVo) {
        //设置分页查询第一个参数
        queryLegalPlantVo.setOffset((queryLegalPlantVo.getPageIndex()-1)*queryLegalPlantVo.getPageSize());

        //查询法人工程
        List<LegalPlant> list= legalPlantMapper.selectAllLegalPlantCondition(queryLegalPlantVo);
        int count=legalPlantMapper.selectAllLegalPlantConditionCount(queryLegalPlantVo);

        PageVo<LegalPlant> pageVo=new PageVo<>();
        pageVo.setCurrentPage(queryLegalPlantVo.getPageIndex());
        pageVo.setTotalPage(count);
        pageVo.setTotalNumber(queryLegalPlantVo.getPageSize());
        pageVo.setDataList(list);
        return ResultVo.success(pageVo);
    }

    @Override
    public ResultVo updataStatus(UpdateLegalPlant updateLegalPlant) {
        updateLegalPlant.setModifyPeople("赵凯");
        int tag=legalPlantMapper.updateStatus(updateLegalPlant);
        return ResultVo.success(tag>0);
    }

    @Override
    public ResultVo updateLegalPlant(UpdateLegalPlant updateLegalPlant) {
        updateLegalPlant.setModifyPeople("赵凯");
        int tag=legalPlantMapper.updateLegalPlant(updateLegalPlant);
        return ResultVo.success(tag>0);
    }
}




