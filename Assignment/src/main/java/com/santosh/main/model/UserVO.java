package com.santosh.main.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.santosh.main.common.Provider;

@Document("user")
public class UserVO {
	private String email;
	private String name;
	private boolean enable;
	private Date createdTime;
	private Provider authProvider;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Provider getAuthProvider() {
		return authProvider;
	}
	public void setAuthProvider(Provider authProvider) {
		this.authProvider = authProvider;
	}
	@Override
	public String toString() {
		return "UserVO [email=" + email + ", name=" + name + ", enable=" + enable + ", createdTime=" + createdTime
				+ ", authProvider=" + authProvider + "]";
	}
	
}
