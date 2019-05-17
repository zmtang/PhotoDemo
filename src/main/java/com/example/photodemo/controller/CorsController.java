package com.example.photodemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 跨域请求的一个控制类
 * @author zmt
 * @date 2019-05-15 17:11
 */
@RestController
@RequestMapping("/cors")
public class CorsController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String corsTest(){
        return "这是一个跨域请求测试";
    }
}
