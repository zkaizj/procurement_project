package com.zk.subClass.controller;

import com.zk.subClass.bean.AddBigSpare;
import com.zk.subClass.bean.BigSpare;
import com.zk.subClass.bean.PageVo;
import com.zk.subClass.service.BigSpareService;
import com.zk.subClass.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author ZK
 * @date 2023/4/25 12:20
 * @description BigSpareController
 */
@RestController
@CrossOrigin()
@RequestMapping("/planCategory")
public class BigSpareController {
    @Autowired
    private BigSpareService bigSpareService;
    //分页条件查询
    @PostMapping("/queryPage")
    public ResultVo queryPage(@RequestBody Map<String,Object> map){
        PageVo<BigSpare> bigSparePageVo = bigSpareService.queryAllBigSpares(map);

        return ResultVo.success(bigSparePageVo);
    }
    //添加备件大类
    @PostMapping("/add")
    public ResultVo addPlanCategory(@RequestBody @Valid AddBigSpare addBigSpare, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        if (addBigSpare.getStatus()){
            ResultVo resultVo = bigSpareService.addBigSpare(addBigSpare);
            return resultVo;
        }else {
            return ResultVo.error("初次添加请设置为启用状态!");
        }
    }

    //修改状态启用或禁用
    @PostMapping("/updateStatus")
    public ResultVo updateStatus(@RequestBody Map<String,Object> map){
        boolean tag=bigSpareService.updateStatus(map);
        if (tag){
            return ResultVo.success(tag);
        }
        return ResultVo.error("修改失败，请重试!");
    }
}
