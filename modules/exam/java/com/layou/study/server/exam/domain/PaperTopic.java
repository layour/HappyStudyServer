package com.layou.study.server.exam.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import core.domain.DomainBase;
import core.mybatis.MyBatisDomain;

@MyBatisDomain
public class PaperTopic extends DomainBase implements Serializable{

	private static final long serialVersionUID = 1L;

	private String paperTopicId;
	private String paperId;
	private String topicId;

	public PaperTopic() {
		super();
	}

	public String getPaperTopicId() {
		return this.paperTopicId;
	}

	public void setPaperTopicId(String paperTopicId) {
		this.paperTopicId = paperTopicId;
	}

	public String getPaperId() {
		return this.paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public String getTopicId() {
		return this.topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}