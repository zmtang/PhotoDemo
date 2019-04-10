package com.example.photodemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.photodemo.entity.Student;
import com.example.photodemo.entity.Student;

/**
 * 创建service接口，继承IService
 *
 */
public interface StudentService extends IService<Student> {

    /**
     * 根据 name 获取个人信息
     * @param name
     * @return
     */
    Student getByName(String name);

    /**
     * 添加事物
     * 模拟回滚
     * @param student1
     * @param student2
     * @return
     */
    Boolean insertTwoStudent(Student student1, Student student2);



}
