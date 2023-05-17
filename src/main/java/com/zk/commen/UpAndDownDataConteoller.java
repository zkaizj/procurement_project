package com.zk.commen;

import com.zk.commen.util.ResultVo;
import com.zk.subClass.mapper.BigSpareMapper;
import com.zk.subClass.mapper.PartsetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZK
 * @date 2023/5/3 18:03
 * @description UpAndDownDataConteoller
 */
@RestController
@CrossOrigin
public class UpAndDownDataConteoller {
    @Autowired
    private PartsetMapper partsetMapper;

    @Autowired
    private BigSpareMapper bigSpareMapper;
    //状态下拉列表
    @PostMapping("/metadata/getPullDownList")
    public ResultVo upAndDownData(){
        List<StatusVo> data =new ArrayList();
        data.add(new StatusVo(true,"启用"));

        data.add(new StatusVo(false,"禁用"));

        return ResultVo.success(data);
    }

    //查询当前用户下的备件小类
    @GetMapping("/subClass/queryAll")
    public  ResultVo queryBigSpare(@RequestParam("_") String _){
        //假设当前用户为1
        List<PartVo> list=partsetMapper.selectAllByUserId(1);
        return ResultVo.success(list);
    }
    //查询当前用户下的备件小类
    @GetMapping("/subClass/planCategoryAll")
    public  ResultVo queryPartSet(@RequestParam("_") String _){
        //假设当前用户为1
        List<BigVo> list=bigSpareMapper.selectAllByUserId(1);
        return ResultVo.success(list);
    }
}
