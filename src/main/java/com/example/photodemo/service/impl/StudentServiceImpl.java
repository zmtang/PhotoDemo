package com.example.photodemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.photodemo.dao.StudentMapper;
import com.example.photodemo.entity.Student;
import com.example.photodemo.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 创建service实现类，实现service接口，继承ServiceImpl实现类
 *
 * @author zmt
 * @date 2019-03-15 15:31
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {


    /**
     * 根据 name 获取个人信息
     * baseMapper ？？？
     *
     * @param name
     * @return
     */
    @Override
    public Student getByName(String name) {
        return baseMapper.getByName(name);
    }

    /**
     * 添加事物
     * 模拟回滚
     *
     * @param Student1
     * @param Student2
     * @return
     */
    @Transactional  // 加入事务控制
    @Override
    public Boolean insertTwoStudent(Student Student1, Student Student2) {
        this.save(Student1);
        System.out.println("模拟异常" + 5 / 0);
        this.save(Student2);
        return null;
    }
}
