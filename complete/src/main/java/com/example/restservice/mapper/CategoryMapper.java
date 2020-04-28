package com.example.restservice.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.restservice.pojo.Category;

@Mapper
public interface CategoryMapper {

    @Select("select * from category_ ")
    List<Category> findAll();

    @Insert(" insert into category_ ( name ) values (#{name}) ")
    int save(Category category);

    @Delete(" delete from category_ where id= #{id} ")
    void delete(int id);

    @Select("select * from category_ where id= #{id} ")
    Category get(int id);

    @Update("update category_ set name=#{name} where id=#{id} ")
    int update(Category category);

}