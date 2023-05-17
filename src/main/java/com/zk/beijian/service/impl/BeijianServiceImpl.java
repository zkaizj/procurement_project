package com.zk.beijian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zk.beijian.bean.*;
import com.zk.beijian.mapper.BeijianMapper;
import com.zk.beijian.service.BeijianService;
import com.zk.commen.util.ResultVo;
import com.zk.subClass.bean.PageVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author zk
* @description 针对表【beijian】的数据库操作Service实现
* @createDate 2023-05-15 18:08:14
*/
@Service
@Slf4j
public class BeijianServiceImpl extends ServiceImpl<BeijianMapper, Beijian>
    implements BeijianService {
    @Autowired
    private BeijianMapper beijianMapper;

    @Override
    public ResultVo queryAll(QueryBeiVo queryBeiVo) {
        queryBeiVo.setOffset((queryBeiVo.getPageIndex() - 1) * queryBeiVo.getPageSize());
        List<BeiJianVo> list = beijianMapper.queryAllBeiJian(queryBeiVo);
        for (BeiJianVo vo : list) {
            if (vo.getStatus()) {
                vo.setStatusName("启用");
            } else {
                vo.setStatusName("禁用");
            }
        }
        int count = beijianMapper.queryAllCount(queryBeiVo);

        PageVo page = new PageVo();
        page.setTotalPage(count);
        page.setCurrentPage(queryBeiVo.getPageIndex());
        page.setTotalNumber(queryBeiVo.getPageSize());
        page.setDataList(list);
        return ResultVo.success(page);
    }

    @Override
    @Transactional
    public ResultVo addSpare(AddBeiVo addBeiVo) {
        //查询编码是否重复
        int codeNum=beijianMapper.selectCodeNum(addBeiVo.getCode());
        if (codeNum>0){
            return  ResultVo.error("编码重复，请重试");
        }
        int nameNum=beijianMapper.selectNameNum(addBeiVo.getName());
        if (nameNum>0){
            return  ResultVo.error("名称重复，请重试");
        }
        addBeiVo.setCreatePeople("赵凯");
        addBeiVo.setModifyPeople("赵凯");
        addBeiVo.setUserId(1);
        //添加数据
        int tag=beijianMapper.addBeiJian(addBeiVo);
        //添加关系
        int relate=beijianMapper.addRelations(addBeiVo.getId(),addBeiVo.getLegalPersonIds());
        if (tag>0 && relate>0){
            return ResultVo.success("添加成功");
        }
        return ResultVo.error("添加失败");

    }

    @Override
    public ResultVo updateStatus(UpdateStatusVo updateStatusVo) {
        updateStatusVo.setModifyPeople("赵凯");
        int tag=beijianMapper.updateBeiStatus(updateStatusVo);
        return ResultVo.success(tag>0);
    }

    @Override
    @Transactional
    public ResultVo updateSpare(UpdateSpareVo updateSpareVo) {
        //查询名称是否重复
        int nameNum=beijianMapper.selectNameNumById(updateSpareVo.getName(),updateSpareVo.getId());
        if(nameNum>0){
            return ResultVo.error("名称重复，请重试");
        }
        updateSpareVo.setModifyPeople("赵凯");
        //如果修改法人 先删除再添加
        int upNum=beijianMapper.deleteRelationsById(updateSpareVo.getId());
        //修改信息
        int tag=beijianMapper.updateBeiJian(updateSpareVo);
        //添加关系
        int relationships=beijianMapper.addRelations(updateSpareVo.getId(),updateSpareVo.getLegalPersonId());
        if (tag>0 && relationships>0){
            return ResultVo.success("修改成功");
        }
        return ResultVo.error("修改失败");

    }
}



