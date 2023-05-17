package com.zk.beijian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zk.beijian.bean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author zk
* @description 针对表【beijian】的数据库操作Mapper
* @createDate 2023-05-15 18:08:14
* @Entity generator.bean.Beijian
*/
@Mapper
public interface BeijianMapper extends BaseMapper<Beijian> {

    List<BeiJianVo> queryAllBeiJian(QueryBeiVo queryBeiVo);

    int queryAllCount(QueryBeiVo queryBeiVo);

    int selectCodeNum(@Param("code") String code);

    int selectNameNum(@Param("name") String name);

    String selectLegalPersonCode(Integer legalPersonId);

    int addBeiJian( AddBeiVo addBeiVo);

    int updateBeiStatus(UpdateStatusVo updateStatusVo);

    int addRelations(@Param("beiId") Integer beiId,@Param("legalPersonIds") Integer[] legalPersonIds);

    int selectNameNumById(@Param("name") String name,@Param("beiId") Integer beiId);

    int updateBeiJian(UpdateSpareVo updateSpareVo);

    int deleteRelationsById(Integer beiId);
}




