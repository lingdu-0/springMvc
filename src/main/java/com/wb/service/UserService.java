package com.wb.service;

import com.wb.dao.UserDao;
import com.wb.entity.User;

import java.util.List;

public class UserService {
    UserDao userDao;
    String jdbcurl;

    public String getJdbcurl() {
        return jdbcurl;
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setJdbcurl(String jdbcurl) {
        this.jdbcurl = jdbcurl;
    }
}
