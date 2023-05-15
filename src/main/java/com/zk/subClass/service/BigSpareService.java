package com.zk.subClass.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.subClass.bean.*;
import com.zk.commen.util.ResultVo;

import java.util.Map;

/**
* @author zk
* @description 针对表【big_spare】的数据库操作Service
* @createDate 2023-04-25 12:16:21
*/
public interface BigSpareService extends IService<BigSpare> {
    public ResultVo addBigSpare(AddBigSpare addBigSpare);
    public PageVo<BigSpare> queryAllBigSpares(BigSpareVo bigSpareVo);

    boolean updateStatus(Map<String, Object> map);

    ResultVo updateBigSpare(UpdateBigSpareVo updateBigSpare);
}
