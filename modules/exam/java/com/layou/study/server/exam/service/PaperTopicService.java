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
public class PaperTopicService {

	@Autowired
	private PaperTopicDao paperTopicDao;
	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	public List<PaperTopic> searchByPage(Map<String,Object> searchParams) {
		return (List<PaperTopic>) paperTopicDao.searchByPage(searchParams);
	}

	/**
	 * 按条件查询记录
	 * @param searchParams 条件
	 * @return
	 */
	public List<PaperTopic> search(Map<String,Object> searchParams) {
		return (List<PaperTopic>) paperTopicDao.search(searchParams);
	}

	/**
	 * 获取所有记录
	 * @return
	 */
	public List<PaperTopic> findAll() {
		return (List<PaperTopic>) paperTopicDao.findAll();
	}
	
	/**
	 * 通过paperTopicId获取一条记录
	 * @param paperTopicId 主键
	 * @return
	 */
	public PaperTopic findById(String paperTopicId) {
		PaperTopic paperTopic = paperTopicDao.findById(paperTopicId);
		if(paperTopic == null){
			paperTopic = new PaperTopic();
		}
		return paperTopic;
	}

	/**
	 * 保存一条记录
	 * @param paperTopic
	 */
	public void save(PaperTopic paperTopic) {
		paperTopic.setPaperTopicId(ComUtil.getId());
		paperTopicDao.save(paperTopic);
	}

	/**
	 * 通过 paperTopicId 删除一条记录
	 * @param paperTopicId 主键
	 */
	public void delete(String paperTopicId) {
		paperTopicDao.delete(paperTopicId);

	}
	
	/**
	 * 修改记录
	 * @param paperTopic
	 */
	public void update(PaperTopic paperTopic) {
		paperTopicDao.update(paperTopic);
	}
}
