package com.layou.study.server.register.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.layou.study.server.register.domain.*;
import com.layou.study.server.register.dao.mybatis.*;

import core.utils.ComUtil;

@Service
@Transactional
public class TeamClassService {

	@Autowired
	private TeamClassDao teamClassDao;
	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	public List<TeamClass> searchByPage(Map<String,Object> searchParams) {
		return (List<TeamClass>) teamClassDao.searchByPage(searchParams);
	}

	/**
	 * 按条件查询记录
	 * @param searchParams 条件
	 * @return
	 */
	public List<TeamClass> search(Map<String,Object> searchParams) {
		return (List<TeamClass>) teamClassDao.search(searchParams);
	}

	/**
	 * 获取所有记录
	 * @return
	 */
	public List<TeamClass> findAll() {
		return (List<TeamClass>) teamClassDao.findAll();
	}
	
	/**
	 * 通过teamClassId获取一条记录
	 * @param teamClassId 主键
	 * @return
	 */
	public TeamClass findById(String teamClassId) {
		TeamClass teamClass = teamClassDao.findById(teamClassId);
		if(teamClass == null){
			teamClass = new TeamClass();
		}
		return teamClass;
	}

	/**
	 * 保存一条记录
	 * @param teamClass
	 */
	public void save(TeamClass teamClass) {
		teamClass.setTeamClassId(ComUtil.getId());
		teamClassDao.save(teamClass);
	}

	/**
	 * 通过 teamClassId 删除一条记录
	 * @param teamClassId 主键
	 */
	public void delete(String teamClassId) {
		teamClassDao.delete(teamClassId);

	}
	
	/**
	 * 修改记录
	 * @param teamClass
	 */
	public void update(TeamClass teamClass) {
		teamClassDao.update(teamClass);
	}
}
