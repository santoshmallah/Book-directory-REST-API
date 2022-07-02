package com.santosh.main.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.stereotype.Service;

import com.santosh.main.common.Provider;
import com.santosh.main.dao.UserDao;
import com.santosh.main.model.UserVO;
import com.santosh.main.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
	public void addUser(String email,String name,Provider provider) {
		UserVO userVO=new UserVO();
		try {
			userVO.setEmail(email);
			userVO.setName(name);
			userVO.setEnable(true);
			userVO.setCreatedTime(new Date());
			userVO.setAuthProvider(provider);
			userDao.addUser(userVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public UserVO getUser(String email) {
		UserVO userVO=new UserVO();
		try {
			userVO=userDao.getUser(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userVO;
	}
	
	
	public UserVO updateUser(String email,String name) {
		UserVO userVO=new UserVO();
		try {
			userVO.setEmail(email);
			userVO.setName(name);
			userVO.setCreatedTime(new Date());
			userVO=userDao.updateUser(userVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userVO;
	}

}
