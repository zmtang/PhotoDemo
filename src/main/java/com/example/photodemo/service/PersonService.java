package com.example.photodemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.photodemo.entity.Person;

/**
 * 创建service接口，继承IService
 */
public interface PersonService extends IService<Person> {

    /**
     * 根据 name 获取个人信息
     *
     * @param name
     * @return
     */
    Person getByName(String name);

    /**
     * 添加事物
     * 模拟回滚
     *
     * @param person1
     * @param person2
     * @return
     */
    Boolean insertTwoPerson(Person person1, Person person2);

}
