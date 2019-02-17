package com.itheima.service.impl;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: tch
 * @Date: 2019/2/12 下午 09:55
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

}
