package com.example.photodemo.controller;

import com.example.photodemo.configuration.QinNiuConfiguration;
import com.example.photodemo.entity.Person;
import com.example.photodemo.service.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zmt
 * @date 2019-03-15 11:36
 */
@RestController // 作用是把返回值回显到页面，默认解析成Json格式。不会走视图解析器
@RequestMapping("/person")
public class PersonController {

    //@Autowired
    @Resource
    // Resource和@Autowired都是做bean的注入时使用，其实@Resource并不是Spring的注解，它的包是javax.annotation.Resource，需要导入，但是Spring支持该注解的注入。
    private QinNiuConfiguration qinNiuConfiguration;//属性封装到对象中提取

    @Resource
    private PersonService personService;

    /**
     * 新增数据
     *
     * @param name
     * @param age
     * @param job
     * @return
     */
    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    public String insert(@RequestParam("name") String name, @RequestParam("age") Integer age, @RequestParam("job") String job) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        person.setJob(job);
        personService.save(person);
        return "新增person";
    }

    /**
     * 更新产品信息
     * save()方法的使用，Put请求
     *
     * @param id
     * @param name
     * @param age
     * @param job
     * @return
     */
    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public String update(@RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("age") Integer age, @RequestParam("job") String job) {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setAge(age);
        person.setJob(job);
        System.out.println(person);
        // personService.save(person);   // 更新失败
        return "修改person";
    }

    /**
     * 查询数据
     *
     * @param name
     * @return
     */
    @RequestMapping("/getByName")
    public Person getPerson(@RequestParam("name") String name) {
        Person person = personService.getByName(name);
        System.out.println(person);
        return person;
    }

    /**
     * 路径传参数
     * 参数为汉字的时候报错
     * 不合法字符错误 ？？？？
     *
     * @param fileName
     * @return
     */
    @RequestMapping(path = "/qiniu/{id}", method = RequestMethod.GET)
    public String qiNiu(@PathVariable("id") String fileName) {
        System.out.println(qinNiuConfiguration);
        return "七牛上传" + fileName;
    }

    /**
     * 事务管理测试
     *
     * @return
     */
    @RequestMapping(path = "/transactional", method = RequestMethod.POST)
    public String transactional() {
        Person person = new Person();
        person.setName("小黑");
        person.setAge(16);
        person.setJob("第一条数据");
        Person person2 = new Person();
        person2.setName("小白");
        person2.setAge(18);
        person2.setJob("第二条数据");
        personService.insertTwoPerson(person, person2);
        return "事物管理";
    }

}
