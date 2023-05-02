package com.zk.subClass.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zk.subClass.bean.AddBigSpare;
import com.zk.subClass.bean.BigSpare;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
* @author zk
* @description 针对表【big_spare】的数据库操作Mapper
* @createDate 2023-04-25 12:16:21
* @Entity generator.bean.BigSpare
*/
@Mapper
public interface BigSpareMapper extends BaseMapper<BigSpare> {
//添加备件大类
    int saveBigSpare(AddBigSpare addBigSpare);
//查询所有数据
    List<BigSpare> queryAllBigSpares(Map<String, Object> map);

    int queryAllBigSparesCount(Map<String, Object> map);

    int updateStatus(Map<String, Object> map);
}
