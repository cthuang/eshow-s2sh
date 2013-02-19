package com.logo.eshow.bean.query;

import java.util.Date;

/**
 * User 查询Bean
 * 
 * @author leida
 * 
 */
public class UserQuery extends BaseQuery {

	public Date addTime;
	public Date updateTime;
	public String email;
	public String nikename;
	public String realname;
	public Integer age;
	public Boolean photo;

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNikename() {
		return nikename;
	}

	public void setNikename(String nikename) {
		this.nikename = nikename;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getPhoto() {
		return photo;
	}

	public void setPhoto(Boolean photo) {
		this.photo = photo;
	}

}