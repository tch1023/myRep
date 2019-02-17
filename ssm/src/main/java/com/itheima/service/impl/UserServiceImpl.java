package com.itheima.service.impl;

import com.itheima.domain.PageBean;
import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) throws Exception {
        return userMapper.login(user);
    }

    @Override
    public List<User> findAll(PageBean pageBean, Integer currPage) throws Exception {
        Integer pageSize = 5;
        pageBean.setPageSize(pageSize);
        Integer totalCount = userMapper.findCount();
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage((int) Math.ceil(totalCount * 1.0 / pageSize));
        Integer begin = (currPage - 1) * pageSize;
        pageBean.setBegin(begin);
        pageBean.setCurrPage(currPage);
        System.out.println(pageBean);
        return userMapper.findAll(pageBean);
    }

    @Override
    public void saveUser(User user) throws Exception {
        userMapper.saveUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }

    @Override
    public User findOne(Integer id) {
        return userMapper.findOne(id);
    }

    @Override
    public void updateUser(User user) {
         userMapper.updateUser(user);
    }
}
