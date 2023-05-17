package com.zk.beijian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.beijian.bean.*;
import com.zk.commen.util.ResultVo;

/**
* @author zk
* @description 针对表【beijian】的数据库操作Service
* @createDate 2023-05-15 18:08:14
*/
public interface BeijianService extends IService<Beijian> {

    ResultVo queryAll(QueryBeiVo queryBeiVo);

    ResultVo addSpare(AddBeiVo addBeiVo);

    ResultVo updateStatus(UpdateStatusVo updateStatusVo);

    ResultVo updateSpare(UpdateSpareVo updateSpareVo);
}
