package com.zk.subClass.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.subClass.bean.*;
import com.zk.commen.util.ResultVo;

/**
 * @author ZK
 * @date 2023/4/18 18:09
 * @description PartsetService
 */
public interface PartsetService extends IService<Partset> {


    ResultVo addSubClass(AddSubClassVo addSubClassVo);

    PageVo<PartsetVo> selectAllPageset(PartsetVo partsetVo);

    boolean updateStatus(StatusVo statusVo);

    ResultVo modifySubClass(UpDateSubClassVo upDateSubClassVo);
}
