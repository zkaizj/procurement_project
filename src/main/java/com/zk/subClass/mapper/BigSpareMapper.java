package com.zk.subClass.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zk.commen.BigVo;
import com.zk.subClass.bean.AddBigSpare;
import com.zk.subClass.bean.BigSpare;
import com.zk.subClass.bean.BigSpareVo;
import com.zk.subClass.bean.UpdateBigSpareVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    List<BigSpare> queryAllBigSpares(BigSpareVo bigSpareVo);

    int queryAllBigSparesCount(BigSpareVo bigSpareVo);

    int updateStatus(Map<String, Object> map);

    Integer selectVersion(Integer id);

    int updateBigSpare(UpdateBigSpareVo updateBigSpare);

    boolean selectStatus(Integer id);

    int selectNameGT0(@Param("id") Integer id,@Param("name") String name);

    List<BigVo> selectAllByUserId(int id);
}
