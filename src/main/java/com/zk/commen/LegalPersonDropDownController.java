package com.zk.commen;

import com.zk.commen.util.ResultVo;
import com.zk.legalPlant.bean.LegalPerson;
import com.zk.legalPlant.mapper.LegalPlantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ZK
 * @date 2023/5/12 12:26
 * @description LegalPersonDropDownController
 */
@RestController
@CrossOrigin
public class LegalPersonDropDownController {
    @Autowired
    private LegalPlantMapper legalPlantMapper;
//通用的查询法人下拉列表
    @GetMapping("/legalPerson/ofCurrentUser")
    public ResultVo queryLegalPerson(String _){
        //由于没有userId所有用自建userid
        List<LegalPerson>  data=legalPlantMapper.queryLegalPerson(1);
        return ResultVo.success(data);
    }


}
