package com.example.photodemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.photodemo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


/**
 * 个人
 * 创建mapper并继承通用BaseMapper
 *
 * @author zmt
 * @date 2019-03-15 11:54
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 根据 name 获取个人信息
     *
     * @param name
     * @return
     */
    @Select("select * from Student where name=#{0}")
    Student getByName(String name);

   /* @Select("listStudent")
    List<Student> listStudent(Pagination page, String state);*/

}
