package com.layou.study.server.opinion.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.layou.study.server.opinion.domain.*;
import com.layou.study.server.opinion.dao.mybatis.*;

import core.utils.ComUtil;

@Service
@Transactional
public class OpinionService {

	@Autowired
	private OpinionDao opinionDao;
	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	public List<Opinion> searchByPage(Map<String,Object> searchParams) {
		return (List<Opinion>) opinionDao.searchByPage(searchParams);
	}

	/**
	 * 按条件查询记录
	 * @param searchParams 条件
	 * @return
	 */
	public List<Opinion> search(Map<String,Object> searchParams) {
		return (List<Opinion>) opinionDao.search(searchParams);
	}

	/**
	 * 获取所有记录
	 * @return
	 */
	public List<Opinion> findAll() {
		return (List<Opinion>) opinionDao.findAll();
	}
	
	/**
	 * 通过opinionId获取一条记录
	 * @param opinionId 主键
	 * @return
	 */
	public Opinion findById(String opinionId) {
		Opinion opinion = opinionDao.findById(opinionId);
		if(opinion == null){
			opinion = new Opinion();
		}
		return opinion;
	}

	/**
	 * 保存一条记录
	 * @param opinion
	 */
	public void save(Opinion opinion) {
		opinion.setOpinionId(ComUtil.getId());
		opinionDao.save(opinion);
	}

	/**
	 * 通过 opinionId 删除一条记录
	 * @param opinionId 主键
	 */
	public void delete(String opinionId) {
		opinionDao.delete(opinionId);

	}
	
	/**
	 * 修改记录
	 * @param opinion
	 */
	public void update(Opinion opinion) {
		opinionDao.update(opinion);
	}
}
