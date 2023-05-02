package com.zk.subClass.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.subClass.bean.AddBigSpare;
import com.zk.subClass.bean.BigSpare;
import com.zk.subClass.bean.PageVo;
import com.zk.subClass.util.ResultVo;

import java.util.Map;

/**
* @author zk
* @description 针对表【big_spare】的数据库操作Service
* @createDate 2023-04-25 12:16:21
*/
public interface BigSpareService extends IService<BigSpare> {
    public ResultVo addBigSpare(AddBigSpare addBigSpare);
    public PageVo<BigSpare> queryAllBigSpares(Map<String, Object> map);

    boolean updateStatus(Map<String, Object> map);
}
