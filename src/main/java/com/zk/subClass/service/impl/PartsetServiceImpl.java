package com.zk.subClass.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zk.subClass.bean.*;
import com.zk.subClass.mapper.PartsetMapper;
import com.zk.subClass.service.PartsetService;
import com.zk.commen.util.ResultVo;
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
        //给status命名为statusName
        for (Partset partset:partsetList) {
            if (partset.getStatus()){
                partset.setStatusName("启用");
            }else{
                partset.setStatusName("禁用");
            }
        }
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

            return partsetMapper.updateStatusById(partset)>0;


    }
//修改备件小类信息
    @Override
    public ResultVo modifySubClass(UpDateSubClassVo upDateSubClassVo) {
        upDateSubClassVo.setModifyDate(new Date());
        upDateSubClassVo.setModifyPeople("zk");
        //查询状态是否为禁用
        Boolean tag1=partsetMapper.selectStatusById(upDateSubClassVo.getId());
        if (tag1){
           return ResultVo.error("状态为启用，不能修改");
        }else{
            //查询修改名称是否重复
            int count=partsetMapper.selectPartNameById(upDateSubClassVo.getId(),upDateSubClassVo.getName());
            if (count>0){
                return ResultVo.error("名称重复，重新修改");
            }
            //查询备件大类版本号
            Integer version=partsetMapper.selectVersionById(upDateSubClassVo.getId());
            if (version==upDateSubClassVo.getVersion()){
                boolean tag=partsetMapper.modifySubClass(upDateSubClassVo)>0;
                return ResultVo.success(tag);
            }else
                return ResultVo.error("版本号不一致，请重试！");
        }


    }
}
