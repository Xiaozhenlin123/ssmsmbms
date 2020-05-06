package com.zt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zt.entity.User;
import com.zt.mapper.UserMapper;
import com.zt.service.UserService;

@Service(value="userService")
public class UserServiceImpl implements UserService {
	@Resource(name="userMapper")
	//@Autowired
    private UserMapper userMapper;
	

	@Override
	public int addUser(User user) {
		
		return userMapper.addUser(user);
	}

	@Override
	public int delUserById(int id) {
		
		return userMapper.delUserById(id);
	}

	@Override
	public int updateUser(User user) {
		
		return userMapper.updateUser(user);
	}

	@Override
	public User loginUser(User user) {
		
		return userMapper.loginUser(user);
	}

	@Override
	public User getUserById(int id) {
		
		return userMapper.getUserById(id);
	}

	@Override
	public List<User> getUsers() {
		
		return userMapper.getUsers();
	}
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

}
