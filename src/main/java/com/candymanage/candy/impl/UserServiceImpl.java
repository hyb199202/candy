package com.candymanage.candy.impl;

import com.candymanage.candy.bean.User;
import com.candymanage.candy.dao.UserDAO;
import com.candymanage.candy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;
    @Override
    public List<User> userList() {
        return userDAO.userList();
    }
}
