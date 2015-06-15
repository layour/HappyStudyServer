package com.layou.study.server.opinion.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import core.domain.DomainBase;
import core.mybatis.MyBatisDomain;

@MyBatisDomain
public class Opinion extends DomainBase implements Serializable{

	private static final long serialVersionUID = 1L;

	private String opinionId;
	private String opinionDesc;
	private String contactInfo;
	private String opinionTime;
	private String userId;

	public Opinion() {
		super();
	}

	public String getOpinionId() {
		return this.opinionId;
	}

	public void setOpinionId(String opinionId) {
		this.opinionId = opinionId;
	}

	public String getOpinionDesc() {
		return this.opinionDesc;
	}

	public void setOpinionDesc(String opinionDesc) {
		this.opinionDesc = opinionDesc;
	}

	public String getContactInfo() {
		return this.contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public String getOpinionTime() {
		return this.opinionTime;
	}

	public void setOpinionTime(String opinionTime) {
		this.opinionTime = opinionTime;
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