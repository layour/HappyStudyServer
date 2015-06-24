package com.layou.study.server.exam.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import core.domain.DomainBase;
import core.mybatis.MyBatisDomain;

@MyBatisDomain
public class Paper extends DomainBase implements Serializable{

	private static final long serialVersionUID = 1L;

	private String paperId;
	private String paperName;
	private String topicCount;
	private String totalScore;
	private String paperTime;
	private String enabled;

	public Paper() {
		super();
	}

	public String getPaperId() {
		return this.paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public String getPaperName() {
		return this.paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public String getTopicCount() {
		return this.topicCount;
	}

	public void setTopicCount(String topicCount) {
		this.topicCount = topicCount;
	}

	public String getTotalScore() {
		return this.totalScore;
	}

	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}

	public String getPaperTime() {
		return this.paperTime;
	}

	public void setPaperTime(String paperTime) {
		this.paperTime = paperTime;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}