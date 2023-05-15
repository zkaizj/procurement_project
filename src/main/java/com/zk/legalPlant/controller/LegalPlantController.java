package com.zk.legalPlant.controller;

import com.zk.commen.util.ResultVo;
import com.zk.legalPlant.bean.AddLegalPlantVo;
import com.zk.legalPlant.bean.QueryLegalPlantVo;
import com.zk.legalPlant.bean.UpdateLegalPlant;
import com.zk.legalPlant.service.LegalPlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author ZK
 * @date 2023/5/12 12:21
 * @description LegalPlantController
 */
@RestController
@CrossOrigin

public class LegalPlantController {
    @Autowired
    private LegalPlantService LegalPlantService;

    //分页查询
    @PostMapping("/legalPlant/query")
    public ResultVo query(@RequestBody QueryLegalPlantVo queryLegalPlantVo){
        ResultVo resultVo=LegalPlantService.queryLegalPlant(queryLegalPlantVo);
        return resultVo;
    }

    //添加功能
    @PostMapping("/legalPlant/add")
    public ResultVo addLegalPlant(@RequestBody @Valid AddLegalPlantVo addLegalPlantVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
            ResultVo resultVo=LegalPlantService.insertLegalPlant(addLegalPlantVo);
        return ResultVo.success(resultVo);
    }
    //修改状态吗
    @PostMapping("legalPlant/updatestatus")
    public ResultVo updatestatus(@RequestBody UpdateLegalPlant updateLegalPlant){
        ResultVo resultVo=LegalPlantService.updataStatus(updateLegalPlant);
        return resultVo;
    }
    //修改法人工厂信息
    @PostMapping("/legalPlant/update")
    public ResultVo update(@RequestBody @Valid UpdateLegalPlant updateLegalPlant,BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return ResultVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        ResultVo resultVo=LegalPlantService.updateLegalPlant(updateLegalPlant);
        return resultVo;
    }

}
