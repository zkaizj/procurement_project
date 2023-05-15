package com.zk.commen;

import com.zk.commen.util.ResultVo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    //状态下拉列表
    @PostMapping("/metadata/getPullDownList")
    public ResultVo upAndDownData(){
        List<StatusVo> data =new ArrayList();
        data.add(new StatusVo(null,"全部"));
        data.add(new StatusVo(true,"启用"));

        data.add(new StatusVo(false,"禁用"));

        return ResultVo.success(data);
    }
}
