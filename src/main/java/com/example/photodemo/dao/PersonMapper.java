package com.example.photodemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.photodemo.entity.Person;
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
public interface PersonMapper extends BaseMapper<Person> {

    /**
     * 根据 name 获取个人信息
     *
     * @param name
     * @return
     */
    @Select("select * from person where name=#{0}")
    Person getByName(String name);

   /* @Select("listPerson")
    List<Person> listPerson(Pagination page, String state);*/

}
