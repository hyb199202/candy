package com.candymanage.candy.dao;

import com.candymanage.candy.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDAO {
    @Select("select * from user")
    List<User> userList();
}
