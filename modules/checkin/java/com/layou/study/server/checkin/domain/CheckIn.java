package com.layou.study.server.checkin.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import core.domain.DomainBase;
import core.mybatis.MyBatisDomain;

@MyBatisDomain
public class CheckIn extends DomainBase implements Serializable{

	private static final long serialVersionUID = 1L;

	private String checkId;
	private String checkTime;
	private String checkAddr;
	private String checkType;
	private String userId;

	public CheckIn() {
		super();
	}

	public String getCheckId() {
		return this.checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

	public String getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckAddr() {
		return this.checkAddr;
	}

	public void setCheckAddr(String checkAddr) {
		this.checkAddr = checkAddr;
	}

	public String getCheckType() {
		return this.checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}