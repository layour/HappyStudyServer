package com.layou.study.server.exam.dao.mybatis;

import java.util.List;
import java.util.Map;

import com.layou.study.server.exam.domain.*;

import core.mybatis.MyBatisRepository;

/**
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * 
 */
@MyBatisRepository
public interface TopicDao {
	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	List<Topic> searchByPage(Map<String,Object> searchParams);
	
	/**
	 * 按条件查询记录
	 * @param searchParams 条件
	 * @return
	 */
	List<Topic> search(Map<String,Object> searchParams);
	
	/**
	 * 获取所有记录
	 * @return
	 */
	List<Topic> findAll();
	
	/**
	 * 通过 topicId 获取一条记录
	 * @param topicId 主键
	 * @return
	 */
	Topic findById(String topicId);
	
	/**
	 * 保存一条记录
	 * @param topic
	 */
	void save(Topic topic);
	
	/**
	 * 通过topic删除一条记录
	 * @param topic
	 */
	void delete(String topicId);
	
	/**
	 * 修改记录
	 * @param topic
	 */
	void update(Topic topic);
}