package com.example.restservice.mapper;

import java.util.List;

import com.example.restservice.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.restservice.pojo.Category;

@Mapper
public interface PasswordMapper {
    // Deprecated
    @Select("select password from user_ where username= #{username} ")
    String getPassword(String username);

}

