package com.itheima.service;

import com.itheima.domain.PageBean;
import com.itheima.domain.User;

import java.util.List;

public interface UserService {
    public User login(User user) throws Exception;

    List<User> findAll(PageBean pageSize, Integer currPage) throws Exception;

    void saveUser(User user) throws Exception;

    void deleteUser(Integer id);

    User findOne(Integer id);

    void updateUser(User user);
}
