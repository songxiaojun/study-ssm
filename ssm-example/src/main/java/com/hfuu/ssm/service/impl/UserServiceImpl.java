package com.hfuu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hfuu.ssm.dao.UserMapper;
import com.hfuu.ssm.entity.User;
import com.hfuu.ssm.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	public List<User> list() {
		// TODO Auto-generated method stub
		return userMapper.list();
	}

}
