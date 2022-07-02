package com.santosh.main.service;

import com.santosh.main.common.Provider;
import com.santosh.main.model.UserVO;

public interface UserService {
	public void addUser(String email,String name,Provider provider);
	public UserVO getUser(String email);
	public UserVO updateUser(String email,String name);
}
