package com.zk.subClass.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zk.subClass.bean.*;
import com.zk.subClass.mapper.BigSpareMapper;
import com.zk.subClass.service.BigSpareService;
import com.zk.commen.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* @author zk
* @description 针对表【big_spare】的数据库操作Service实现
* @createDate 2023-04-25 12:16:21
*/
@Service
public class BigSpareServiceImpl extends ServiceImpl<BigSpareMapper, BigSpare>
implements BigSpareService {
    @Autowired
    private BigSpareMapper bigSpareMapper;

    //添加备件大类
    public ResultVo addBigSpare(AddBigSpare addBigSpare){
        //查询编码是否重复
        LambdaQueryWrapper<BigSpare> q = new LambdaQueryWrapper<BigSpare>();
        q.eq(BigSpare::getCode,addBigSpare.getCode());
        List<BigSpare> bigSpares = bigSpareMapper.selectList(q);
        if (bigSpares.size()!=0){
            return ResultVo.error("编码重复");
        }
        //查询名称是否重复
        LambdaQueryWrapper<BigSpare> r = new LambdaQueryWrapper<BigSpare>();
        r.eq(BigSpare::getName,addBigSpare.getName());
        List<BigSpare> bigSpareList = bigSpareMapper.selectList(r);
        if (bigSpareList.size()!=0){
            return ResultVo.error("名称重复");
        }
        addBigSpare.setCreatePeople("zk");
        int i = bigSpareMapper.saveBigSpare(addBigSpare);
        return ResultVo.success(i>0);
    }

    //分页查询
    public PageVo<BigSpare> queryAllBigSpares(BigSpareVo bigSpareVo){

        //分页第一个参数
        bigSpareVo.setOffset((bigSpareVo.getPageIndex()-1)*bigSpareVo.getPageSize());
         //查询所有数据
        List<BigSpare> bigSpareList = bigSpareMapper.queryAllBigSpares(bigSpareVo);
        //查询数据量
        int count=bigSpareMapper.queryAllBigSparesCount(bigSpareVo);
        //根据状态码给状态命名
        for (BigSpare bs:bigSpareList) {
            if (bs.getStatus()){
                bs.setStatusName("启用");
            }else {
                bs.setStatusName("禁用");
            }
        }

        PageVo<BigSpare> pageVo = new PageVo<>();
        pageVo.setDataList(bigSpareList);
        pageVo.setCurrentPage(bigSpareVo.getPageIndex());
        pageVo.setTotalPage(count%bigSpareVo.getPageSize()==0?count/bigSpareVo.getPageSize():count/bigSpareVo.getPageSize()+1);
        pageVo.setTotalNumber(count);
        return pageVo;
    }


    //修改状态
    @Override
    public boolean updateStatus(Map<String, Object> map) {
        map.put("updataPeople","zk");

        return bigSpareMapper.updateStatus(map)>0;
    }

    @Override
    public ResultVo updateBigSpare(UpdateBigSpareVo updateBigSpare) {
        //查询状态是否为启用
        boolean status=bigSpareMapper.selectStatus(updateBigSpare.getId());
        if (status){
            return ResultVo.error("当前状态为启用，不能修改");
        }else {
            //查询名称是否重复
            int count = bigSpareMapper.selectNameGT0(updateBigSpare.getId(), updateBigSpare.getName());
            if (count > 0) {
                return ResultVo.error("名称重复");
            } else {
                //查询版本号是否一致

                updateBigSpare.setModifyPeople("zk");
                int tag = bigSpareMapper.updateBigSpare(updateBigSpare);
                if (tag > 0) {
                    return ResultVo.success("修改成功");
                } else {
                    return ResultVo.error("版本号不一致，请重试");
                }

            }
        }

    }
}
