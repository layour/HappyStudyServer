package com.layou.study.server.exam.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.layou.study.server.exam.domain.*;
import com.layou.study.server.exam.dao.mybatis.*;

import core.utils.ComUtil;

@Service
@Transactional
public class CollectService {

	@Autowired
	private CollectDao collectDao;
	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	public List<Collect> searchByPage(Map<String,Object> searchParams) {
		return (List<Collect>) collectDao.searchByPage(searchParams);
	}

	/**
	 * 按条件查询记录
	 * @param searchParams 条件
	 * @return
	 */
	public List<Collect> search(Map<String,Object> searchParams) {
		return (List<Collect>) collectDao.search(searchParams);
	}

	/**
	 * 获取所有记录
	 * @return
	 */
	public List<Collect> findAll() {
		return (List<Collect>) collectDao.findAll();
	}
	
	/**
	 * 通过collectId获取一条记录
	 * @param collectId 主键
	 * @return
	 */
	public Collect findById(String collectId) {
		Collect collect = collectDao.findById(collectId);
		if(collect == null){
			collect = new Collect();
		}
		return collect;
	}

	/**
	 * 保存一条记录
	 * @param collect
	 */
	public void save(Collect collect) {
		collect.setCollectId(ComUtil.getId());
		collectDao.save(collect);
	}

	/**
	 * 通过 collectId 删除一条记录
	 * @param collectId 主键
	 */
	public void delete(String collectId) {
		collectDao.delete(collectId);
	}
	
	/**
	 * 通过 userId和topicId 删除一条记录
	 * @param collectId 主键
	 */
	public void deleteByUserTopic(Collect collect) {
		collectDao.deleteByUserTopic(collect);
	}
	
	/**
	 * 修改记录
	 * @param collect
	 */
	public void update(Collect collect) {
		collectDao.update(collect);
	}
}
