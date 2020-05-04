package com.example.restservice.mapper;

import java.util.List;

import com.example.restservice.pojo.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("select username, usertype, credit, coin from user_ where username= #{username} ")
    User getUser(String username);

//    @Insert("insert into action_ ( username, actionname, actiontime, creditchange, actiondetail ) " +
//            "values ( #{username}, #{actionname}, #{actiontime}, #{creditchange}, #{actiondetail} ) ")
//    int save(UserAction userAction);

    @Insert("insert into user_ ( username, password, usertype, credit, email ) " +
            "values ( #{username}, #{password}, #{usertype}, #{credit}, #{email} )")
    int addUser(User user);

    @Select("select * from user_ order by coin desc limit #{k}")
    List<User> getTopKUsers(int k);

    @Select("select username, credit, coin from user_")
    List<User> ranklist();

    @Update("update user_ set coin=coin+floor(LOG(2,credit+1))")
    void payUser();

    @Update("update user_ set credit=credit-1 where credit!=0")
    void spendUser();

    @Select("SELECT username FROM user_ where usertype='ai' order by rand() limit #{k}")
    List<String> randuser(int k);

    @Update("update user_ set credit=credit+1 where username=#{username}")
    void aiAddCredit (String username);

}