package com.layou.study.server.exam.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import core.domain.DomainBase;
import core.mybatis.MyBatisDomain;

@MyBatisDomain
public class Topic extends DomainBase implements Serializable{

	private static final long serialVersionUID = 1L;

	private String topicId;
	private String topic;
	private String answer;
	private String rightAnswer;
	private String topicScore;
	private String analysis;
	private String difficulty;
	private String chapterId;

	public Topic() {
		super();
	}

	public String getTopicId() {
		return this.topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getRightAnswer() {
		return this.rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public String getTopicScore() {
		return this.topicScore;
	}

	public void setTopicScore(String topicScore) {
		this.topicScore = topicScore;
	}

	public String getAnalysis() {
		return this.analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getChapterId() {
		return this.chapterId;
	}

	public void setChapterId(String chapterId) {
		this.chapterId = chapterId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}