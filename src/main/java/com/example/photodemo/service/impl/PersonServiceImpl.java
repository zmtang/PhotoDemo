package com.example.photodemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.photodemo.dao.PersonMapper;
import com.example.photodemo.entity.Person;
import com.example.photodemo.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 创建service实现类，实现service接口，继承ServiceImpl实现类
 * @author zmt
 * @date 2019-03-15 15:31
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {


    /**
     * 根据 name 获取个人信息
     * baseMapper ？？？
     * @param name
     * @return
     */
    @Override
    public Person getByName(String name) {
        return baseMapper.getByName(name);
    }

    /**
     * 添加事物
     * 模拟回滚
     *
     * @param person1
     * @param person2
     * @return
     */
    @Transactional  // 加入事务控制
    @Override
    public Boolean insertTwoPerson(Person person1, Person person2) {
        this.save(person1);
        System.out.println("模拟异常"+5/0);
        this.save(person2);
        return null;
    }
}
