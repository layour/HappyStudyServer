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
public class TopicService {

	@Autowired
	private TopicDao topicDao;
	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	public List<Topic> searchByPage(Map<String,Object> searchParams) {
		return (List<Topic>) topicDao.searchByPage(searchParams);
	}

	/**
	 * 按条件查询记录
	 * @param searchParams 条件
	 * @return
	 */
	public List<Topic> search(Map<String,Object> searchParams) {
		return (List<Topic>) topicDao.search(searchParams);
	}

	/**
	 * 获取所有记录
	 * @return
	 */
	public List<Topic> findAll() {
		return (List<Topic>) topicDao.findAll();
	}
	
	/**
	 * 按Paper查询
	 * @param searchParams 条件
	 * @return
	 */
	public List<Topic> findTopicByPaper(Map<String,Object> searchParams) {
		return (List<Topic>) topicDao.findTopicByPaper(searchParams);
	}
	
	/**
	 * 按User查询
	 * @param searchParams 条件
	 * @return
	 */
	public List<Topic> findTopicByUser(Map<String,Object> searchParams) {
		return (List<Topic>) topicDao.findTopicByUser(searchParams);
	}
	
	/**
	 * 按User查询
	 * @param searchParams 条件
	 * @return
	 */
	public List<Topic> findCollectByUser(Map<String,Object> searchParams) {
		return (List<Topic>) topicDao.findCollectByUser(searchParams);
	}
	
	/**
	 * 按UserChapter查询
	 * @param searchParams 条件
	 * @return
	 */
	public List<Topic> findTopicByUserChapter(Map<String,Object> searchParams) {
		return (List<Topic>) topicDao.findTopicByUserChapter(searchParams);
	}
	
	/**
	 * 通过topicId获取一条记录
	 * @param topicId 主键
	 * @return
	 */
	public Topic findById(String topicId) {
		Topic topic = topicDao.findById(topicId);
		if(topic == null){
			topic = new Topic();
		}
		return topic;
	}

	/**
	 * 保存一条记录
	 * @param topic
	 */
	public void save(Topic topic) {
		topic.setTopicId(ComUtil.getId());
		topicDao.save(topic);
	}

	/**
	 * 通过 topicId 删除一条记录
	 * @param topicId 主键
	 */
	public void delete(String topicId) {
		topicDao.delete(topicId);

	}
	
	/**
	 * 修改记录
	 * @param topic
	 */
	public void update(Topic topic) {
		topicDao.update(topic);
	}
}
