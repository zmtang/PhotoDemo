package com.example.photodemo.controller;

import com.example.photodemo.config.QinNiuConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * freemarker 使用
 * @author zmt
 * @date 2019-04-03 10:08
 */
@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

    @Resource
    private QinNiuConfig qinNiuConfig;

    /**
     * freemarker 使用
     * @return
     */
    @RequestMapping("/say")
    public ModelAndView helloWorld(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("message","springBoot 你好啊!");
        mav.setViewName("HelloWorld");
        return mav;
    }


}
