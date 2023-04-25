package com.zk.subClass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ZK
 * @date 2023/4/18 19:15
 * @description IndexController
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){

        return "view/partset";
    }
}
