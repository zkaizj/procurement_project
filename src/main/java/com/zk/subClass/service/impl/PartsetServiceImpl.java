package com.zk.subClass.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zk.subClass.bean.*;
import com.zk.subClass.mapper.PartsetMapper;
import com.zk.subClass.service.PartsetService;
import com.zk.subClass.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ZK
 * @date 2023/4/18 18:10
 * @description PartsetServiceImpl
 */
@Service
public class PartsetServiceImpl extends ServiceImpl<PartsetMapper, Partset> implements PartsetService {
    @Autowired
    private PartsetMapper partsetMapper;



    @Override
    public ResultVo addSubClass(AddSubClassVo addSubClassVo) {
        //添加备件小类
        addSubClassVo.setCreatePeople("zk");
        //查询编码是否重复

        Partset partset1=partsetMapper.selectCode(addSubClassVo.getCode());
        if (partset1!=null)
        {
            return ResultVo.error("编码重复，请修改！");
        }
        //查询名称是否重复
        Partset partset2=partsetMapper.selectName(addSubClassVo.getName());
        if (partset2!=null){
            return ResultVo.error("名称重复，请修改！");
        }
        //添加备件小类
        boolean tag=partsetMapper.addPartset(addSubClassVo)>0;
        return ResultVo.success(tag);
    }

    //分页条件查询
    @Override
    public PageVo<PartsetVo> selectAllPageset(PartsetVo partsetVo) {
        //计算分页查询第一个参数
        partsetVo.setOffset((partsetVo.getPageIndex()-1)* partsetVo.getPageSize());

        //条件查询所有信息
        List<Partset> partsetList=partsetMapper.selectAllPageset(partsetVo);
        //条件查询后的总记录条数
        int count=partsetMapper.selectAllPagesetCount(partsetVo);
        //返回所有信息
        PageVo pageVo=new PageVo();
        pageVo.setCurrentPage(partsetVo.getPageIndex());
        if (count%partsetVo.getPageSize()==0) {
            pageVo.setTotalPage(count/partsetVo.getPageSize());
        }else{
            pageVo.setTotalPage(count/partsetVo.getPageSize()+1);
        }

        pageVo.setTotalNumber(count);
        pageVo.setDataList(partsetList);
        return  pageVo;
    }
//更新状态码
    @Override
    public boolean updateStatus(StatusVo statusVo) {
        Partset partset = new Partset();
        partset.setId(statusVo.getId());
        partset.setStatus(statusVo.getStatus());
        partset.setModifyDate(new Date());
        partset.setModifyPeople("zk");

        //
        return partsetMapper.updateStatusById(partset)>0;
    }
//修改备件小类信息
    @Override
    public boolean modifySubClass(UpDateSubClassVo upDateSubClassVo) {
        upDateSubClassVo.setModifyDate(new Date());
        upDateSubClassVo.setModifyPeople("zk");
        return partsetMapper.modifySubClass(upDateSubClassVo)>0;

    }
}
