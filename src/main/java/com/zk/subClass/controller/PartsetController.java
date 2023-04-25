package com.zk.subClass.controller;

import com.zk.subClass.bean.*;
import com.zk.subClass.service.PartsetService;
import com.zk.subClass.util.ResultVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author ZK
 * @date 2023/4/18 18:11
 * @description PartsetController
 */
@RestController
@CrossOrigin
@RequestMapping("/subClass")
public class PartsetController {
    @Autowired
    private PartsetService partsetService;

    //分页条件查询
    @PostMapping("/queryPage")
    public ResultVo queryAllPageset(@RequestBody  PartsetVo partsetVo) {

        PageVo<PartsetVo> pageVo=partsetService.selectAllPageset(partsetVo);
        System.out.println(pageVo);
        return ResultVo.success(pageVo);
    }

    //添加备件小样设置
    @PostMapping("/addSubClass")
    public ResultVo addSubClass(@RequestBody @Valid AddSubClassVo addSubClassVo, BindingResult bindingResult) {
       if (bindingResult.hasErrors()){
           return ResultVo.error(bindingResult.getFieldError().getDefaultMessage());
       }
       ResultVo tag = partsetService.addSubClass(addSubClassVo);
        return tag;
    }
    //修改启用或禁用状态
    @PostMapping("/updateStatus")
    public ResultVo updateStatus(@RequestBody StatusVo statusVo) {
        System.out.println(statusVo+"==============================");

        boolean tag = partsetService.updateStatus(statusVo);
       return ResultVo.success(tag);

    }
    //修改备件小类信息
    @PostMapping("/modifySubClass")
    public ResultVo updateSubClass(@RequestBody UpDateSubClassVo upDateSubClassVo) {
        boolean tag = partsetService.modifySubClass(upDateSubClassVo);
        return ResultVo.success(tag);
    }
}
