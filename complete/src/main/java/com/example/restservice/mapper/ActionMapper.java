package com.example.restservice.mapper;

import java.util.List;

import com.example.restservice.pojo.UserAction;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ActionMapper {

    @Insert("insert into action_ ( username, actionname, actiontime, creditchange, actiondetail ) " +
            "values ( #{username}, #{actionname}, #{actiontime}, #{creditchange}, #{actiondetail} ) ")
    int save(UserAction userAction);

    @Select("select * from action_ where username= #{username} ")
    List<UserAction> getUserAction(String username);

}
