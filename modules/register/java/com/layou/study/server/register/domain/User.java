package com.layou.study.server.register.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import core.domain.DomainBase;
import core.mybatis.MyBatisDomain;

@MyBatisDomain
public class User extends DomainBase implements Serializable{

	private static final long serialVersionUID = 1L;

	private String userId;
	private String phoneNo;
	private String password;
	private String userName;
	private String sex;
	private String idNo;
	private String referrerNo;
	private String referrerPhoneNo;
	private String city;
	private String teamType;
	private String role;
	private String teamClass;

	public User() {
		super();
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdNo() {
		return this.idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getReferrerNo() {
		return this.referrerNo;
	}

	public void setReferrerNo(String referrerNo) {
		this.referrerNo = referrerNo;
	}

	public String getReferrerPhoneNo() {
		return this.referrerPhoneNo;
	}

	public void setReferrerPhoneNo(String referrerPhoneNo) {
		this.referrerPhoneNo = referrerPhoneNo;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTeamType() {
		return this.teamType;
	}

	public void setTeamType(String teamType) {
		this.teamType = teamType;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTeamClass() {
		return this.teamClass;
	}

	public void setTeamClass(String teamClass) {
		this.teamClass = teamClass;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}