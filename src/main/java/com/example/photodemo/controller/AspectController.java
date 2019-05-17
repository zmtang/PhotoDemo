package com.example.photodemo.controller;

import com.example.photodemo.aspect.annotion.Author;
import com.example.photodemo.entity.Person;
import com.example.photodemo.service.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * AOP 测试
 *
 * @author zmt
 * @date 2019-04-03 10:35
 */
@RestController
@RequestMapping("/aspect")
public class AspectController {

    @Resource
    private PersonService personService;

    /**
     * 当然，你也可以通过这种传参方式：localhost:8080/getParamDemo?param1=1或者直接表单提交参数
     * 当然，同时方法中参数声明的注释也要变成@RequestParam，代表请求参数，required属性说明了参数是否是必须的
     */
    @RequestMapping(value = "/getByName")
    @Author(name = "#param")
    public String getParamDemo(@RequestParam(value = "param", required = false) String param) {
        Person person = new Person();
        Date date = new Date();
        return  param + " 汉字乱码了吗？？";
    }

}


