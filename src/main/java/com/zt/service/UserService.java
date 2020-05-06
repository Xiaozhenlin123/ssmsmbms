package com.zt.service;

import java.util.List;

import com.zt.entity.User;

public interface UserService {
	public int addUser(User user);
	public int delUserById(int id);
	public int updateUser(User user);
	public User loginUser(User user);
	public User getUserById(int id);
	public List<User> getUsers();
}
