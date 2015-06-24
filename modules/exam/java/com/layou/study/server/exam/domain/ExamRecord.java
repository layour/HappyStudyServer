package com.layou.study.server.exam.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import core.domain.DomainBase;
import core.mybatis.MyBatisDomain;

@MyBatisDomain
public class ExamRecord extends DomainBase implements Serializable{

	private static final long serialVersionUID = 1L;

	private String examRecordId;
	private String examScore;
	private String eamTime;
	private String useTime;
	private String userId;
	private String paperId;

	public ExamRecord() {
		super();
	}

	public String getExamRecordId() {
		return this.examRecordId;
	}

	public void setExamRecordId(String examRecordId) {
		this.examRecordId = examRecordId;
	}

	public String getExamScore() {
		return this.examScore;
	}

	public void setExamScore(String examScore) {
		this.examScore = examScore;
	}

	public String getEamTime() {
		return this.eamTime;
	}

	public void setEamTime(String eamTime) {
		this.eamTime = eamTime;
	}

	public String getUseTime() {
		return this.useTime;
	}

	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPaperId() {
		return this.paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}