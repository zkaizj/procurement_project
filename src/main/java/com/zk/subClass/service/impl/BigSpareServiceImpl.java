package com.zk.subClass.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zk.subClass.bean.AddBigSpare;
import com.zk.subClass.bean.BigSpare;
import com.zk.subClass.bean.PageVo;
import com.zk.subClass.mapper.BigSpareMapper;
import com.zk.subClass.service.BigSpareService;
import com.zk.subClass.util.ResultVo;
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
    public PageVo<BigSpare> queryAllBigSpares(Map<String, Object> map){
        //分页第一个参数
        map.put("offset",(((int)map.get("pageIndex")-1)*(int)map.get("pageSize")));
         //查询所有数据
        List<BigSpare> bigSpareList = bigSpareMapper.queryAllBigSpares(map);
        //查询数据量
        int count=bigSpareMapper.queryAllBigSparesCount(map);

        PageVo<BigSpare> pageVo = new PageVo<>();
        pageVo.setDataList(bigSpareList);
        pageVo.setCurrentPage((int)map.get("pageIndex"));
        pageVo.setTotalPage(count%(int)map.get("pageSize")==0?count/(int)map.get("pageSize"):count/(int)map.get("pageSize")+1);
        pageVo.setTotalNumber(count);
        return pageVo;
    }


    //修改状态
    @Override
    public boolean updateStatus(Map<String, Object> map) {
        map.put("updataPeople","zk");

        return bigSpareMapper.updateStatus(map)>0;
    }
}
