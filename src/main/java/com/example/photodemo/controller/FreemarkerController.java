package com.example.photodemo.controller;

import com.example.photodemo.configuration.QinNiuConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * freemarker 使用
 * freemarker 默认文件格式是 .ftl 也可以通过 spring.freemarker.suffix : .html  将其改为html文件
 *
 * @author zmt
 * @date 2019-04-03 10:08
 */
@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {
    private static final Logger logger = LoggerFactory.getLogger(FreemarkerController.class);

    @Resource
    private QinNiuConfiguration qinNiuConfiguration;

    /**
     * Model、ModelMap和ModelAndView的用法
     * Model
     * Model是一个接口，它的实现类ExtendModelMap继承自ModelMap类
     * ModelMap
     * ModelMap继承LinkedHashMap
     * ModelAndView
     * ModelAndView指的是模型与视图的集合，它的实例需要手动去创建
     */
    /**
     * templates的展示
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(value = {"/t", "/temp", "/template"}, method = RequestMethod.GET)
    public String showIndexHtml(ModelMap modelMap) {
        modelMap.addAttribute("msg","modelMap 方法 传个参数到前端");
        logger.info("进入 FreemarkerController 里面了");
        return "ftl/index"; // 注意在最前面不要加上/ (“/index”)，在Linux下面会报错 它默认有/ (Windows下面不会报错）
    }

    /**
     * 通过model传参
     * @param model
     * @return
     */
    @RequestMapping("byModel")
    public String showByModel(Model model){
        model.addAttribute("msg","Model 方法传个参数到前端");
        return "ftl/index";
    }

    /**
     * 通过 ModelAndView 传递参数到前端
     * @return
     */
    @RequestMapping("/say")
    public ModelAndView helloWorld() {
        /*方法一*/
        ModelAndView mav = new ModelAndView("ftl/index");
        /*方法二*/
       /* ModelAndView mav = new ModelAndView();
        mav.setViewName("ftl/index");*/

        mav.addObject("msg", "springBoot 你好啊!");
        return mav;
    }

}
