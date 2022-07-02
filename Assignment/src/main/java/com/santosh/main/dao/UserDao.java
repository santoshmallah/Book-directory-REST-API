package com.santosh.main.dao;

import com.santosh.main.model.UserVO;

public interface UserDao {
	public void addUser(UserVO userVO);
	public UserVO getUser(String email);
	public UserVO updateUser(UserVO userVO);
}
