package com.example.photodemo.controller;

import com.example.photodemo.entity.Student;
import com.example.photodemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zmt
 * @date 2019-04-03 13:57
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 获取信息
     *
     * @return
     */
    @RequestMapping("/get")
    private Student getStudent(@RequestParam("name") String name) {
        Student student = studentService.getByName(name);
        return student;
    }

    /**
     * @param student
     * @return
     */
    @RequestMapping("/insert")
    private Student getStudent(Student student) {
        // studentService.save(student);
        System.out.println("student = [" + student + "]");
        return student;
    }


}
