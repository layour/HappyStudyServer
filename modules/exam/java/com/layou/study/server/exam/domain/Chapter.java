package com.layou.study.server.exam.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import core.domain.DomainBase;
import core.mybatis.MyBatisDomain;

@MyBatisDomain
public class Chapter extends DomainBase implements Serializable{

	private static final long serialVersionUID = 1L;

	private String chapterId;
	private String chapterName;

	public Chapter() {
		super();
	}

	public String getChapterId() {
		return this.chapterId;
	}

	public void setChapterId(String chapterId) {
		this.chapterId = chapterId;
	}

	public String getChapterName() {
		return this.chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}