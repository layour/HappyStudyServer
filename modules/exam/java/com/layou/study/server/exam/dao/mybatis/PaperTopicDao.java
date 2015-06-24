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
public interface PaperTopicDao {
	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	List<PaperTopic> searchByPage(Map<String,Object> searchParams);
	
	/**
	 * 按条件查询记录
	 * @param searchParams 条件
	 * @return
	 */
	List<PaperTopic> search(Map<String,Object> searchParams);
	
	/**
	 * 获取所有记录
	 * @return
	 */
	List<PaperTopic> findAll();
	
	/**
	 * 通过 paperTopicId 获取一条记录
	 * @param paperTopicId 主键
	 * @return
	 */
	PaperTopic findById(String paperTopicId);
	
	/**
	 * 保存一条记录
	 * @param paperTopic
	 */
	void save(PaperTopic paperTopic);
	
	/**
	 * 通过paperTopic删除一条记录
	 * @param paperTopic
	 */
	void delete(String paperTopicId);
	
	/**
	 * 修改记录
	 * @param paperTopic
	 */
	void update(PaperTopic paperTopic);
}