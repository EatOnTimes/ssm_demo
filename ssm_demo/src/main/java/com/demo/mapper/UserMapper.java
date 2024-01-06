package com.demo.mapper;

import com.demo.domain.User;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

public interface UserMapper {

    @Select("insert into user values (#{id},#{username},#{password},#{birthday})")
    @SelectKey(keyColumn = "id",keyProperty = "id",before = false,
            resultType =Integer.class,statement = {" select last_insert_id()"})
    public void save(User user);
    @Select("select * from user where id=#{id}")
    public User findById(int id);
    @Select("select * from user ")
    public List<User> findAll();
}
