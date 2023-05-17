package com.zk.beijian.controller;

import com.zk.beijian.bean.AddBeiVo;
import com.zk.beijian.bean.QueryBeiVo;
import com.zk.beijian.bean.UpdateSpareVo;
import com.zk.beijian.bean.UpdateStatusVo;
import com.zk.beijian.service.BeijianService;
import com.zk.commen.util.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author ZK
 * @date 2023/5/15 18:10
 * @description BeiJianController
 */
@RestController
@CrossOrigin
@Slf4j
public class BeiJianController {
    @Autowired
    private BeijianService beijianService;
    //查询
    @PostMapping("/spare/queryPage")
    public ResultVo queryAll(@RequestBody QueryBeiVo queryBeiVo){
        ResultVo resultVo= beijianService.queryAll(queryBeiVo);
        return resultVo;
    }
    //添加
    @PostMapping("/spare/addSpare")
    public ResultVo addSpare(@RequestBody @Valid AddBeiVo addBeiVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultVo.error(bindingResult.getFieldError().getDefaultMessage());
        }

        ResultVo resultVo=beijianService.addSpare(addBeiVo);
        return resultVo;
    }
    //修改状态码
    @PostMapping("/spare/updateStatus")
    public ResultVo updateStatus(@RequestBody UpdateStatusVo updateStatusVo){

        ResultVo resultVo=beijianService.updateStatus(updateStatusVo);
        return resultVo;
    }

    //修改备件设置
    @PostMapping("/spare/updateSpare")
    public ResultVo updateSpare(@RequestBody @Valid UpdateSpareVo updateSpareVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultVo.error(bindingResult.getFieldError().getDefaultMessage());
        }


        ResultVo resultVo=beijianService.updateSpare(updateSpareVo);
        return resultVo;
    }
}
