package com.santosh.main.daoImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.santosh.main.dao.UserDao;
import com.santosh.main.model.BookVO;
import com.santosh.main.model.UserVO;
import com.santosh.main.util.BookUtil;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public void addUser(UserVO userVO) {
		try {
			mongoTemplate.insert(BookUtil.encryptUserData(userVO));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public UserVO getUser(String email) {
		UserVO userVO=new UserVO();
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("email").is(email));
			userVO=mongoTemplate.findOne(query, UserVO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userVO;
	}
	
	public UserVO updateUser(UserVO userVO) {
		UserVO userVO2=new UserVO();
		BookVO updateBookVO = new BookVO();
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("email").is(userVO.getEmail()));
			userVO2=mongoTemplate.findOne(query, UserVO.class);
			if(userVO2!=null) {
				userVO2.setEmail(userVO.getEmail());;
				userVO2.setCreatedTime(new Date());;
				mongoTemplate.save(userVO2);
				userVO2=mongoTemplate.findOne(query, UserVO.class);
				
				updateBookVO = mongoTemplate.findOne(query, BookVO.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userVO2;
	}

}
