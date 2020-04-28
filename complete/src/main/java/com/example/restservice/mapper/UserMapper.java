package com.example.restservice.mapper;

import java.util.List;

import com.example.restservice.pojo.Category;
import com.example.restservice.pojo.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("select username, usertype, credit from user_ where username= #{username} ")
    User getUser(String username);

}