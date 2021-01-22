package com.zyf.org.alertconfig.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanfengzhang
 * @description
 * @date 2021/1/21  17:48
 */
@RestController
@Slf4j
public class ZYFTestController {

    @GetMapping("/")
    public String getApp() {
        return "欢迎来到彦峰的小测试";
    }
}
