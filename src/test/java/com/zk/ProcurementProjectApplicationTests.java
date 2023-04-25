package com.zk;

import com.zk.subClass.bean.PageVo;
import com.zk.subClass.bean.PartsetVo;
import com.zk.subClass.service.PartsetService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class ProcurementProjectApplicationTests {
@Autowired
private PartsetService partsetService;

    @Test
    void queryPage() {
        PartsetVo partsetVo=new PartsetVo();
        partsetVo.setPageIndex(1);
        partsetVo.setPageSize(10);
        PageVo<PartsetVo> pageVo = partsetService.selectAllPageset(partsetVo);
        List list=pageVo.getDataList();
        for (Object p :list) {
            System.out.println(p);
        }

    }
}
