package com.layou.study.server.register.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import core.domain.DomainBase;
import core.mybatis.MyBatisDomain;

@MyBatisDomain
public class TeamClass extends DomainBase implements Serializable{

	private static final long serialVersionUID = 1L;

	private String teamClassId;
	private String teamClassName;

	public TeamClass() {
		super();
	}

	public String getTeamClassId() {
		return this.teamClassId;
	}

	public void setTeamClassId(String teamClassId) {
		this.teamClassId = teamClassId;
	}

	public String getTeamClassName() {
		return this.teamClassName;
	}

	public void setTeamClassName(String teamClassName) {
		this.teamClassName = teamClassName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}