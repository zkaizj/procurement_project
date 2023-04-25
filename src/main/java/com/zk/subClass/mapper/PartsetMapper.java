package com.zk.subClass.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zk.subClass.bean.AddSubClassVo;
import com.zk.subClass.bean.Partset;
import com.zk.subClass.bean.PartsetVo;
import com.zk.subClass.bean.UpDateSubClassVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PartsetMapper extends BaseMapper<Partset> {

   // List<PartsetVo> selectAllPageset(PartsetVo partsetVo);
   // int selectAllPagesetNum(PartsetVo partsetVo);

    int addPartset(AddSubClassVo addSubClassVo);

    List<Partset> selectAllPageset(PartsetVo partsetVo);

    int selectAllPagesetCount(PartsetVo partsetVo);

    int updateStatusById(Partset partset);

    int modifySubClass(UpDateSubClassVo upDateSubClassVo);

    Partset selectCode(String code);

    Partset selectName(String code);


//    int selectPartCode(String partCode);
//
//    int selectPartName(String partName);
//
//
//    int updatePartSet(Partset partset);
//
//    Partset selectPartsetById(Integer partId);
//
//    int updatePartStateById(Partset partset);
}