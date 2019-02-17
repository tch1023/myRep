package com.itheima.mapper;

import com.itheima.domain.PageBean;
import com.itheima.domain.User;

import java.util.List;

public interface UserMapper {

    public User login(User user) throws Exception;

    List<User> findAll(PageBean pageBean) throws Exception;

    void saveUser(User user);

    void deleteUser(Integer id);

    Integer findCount();

    User findOne(Integer id);

    void updateUser(User user);
}
