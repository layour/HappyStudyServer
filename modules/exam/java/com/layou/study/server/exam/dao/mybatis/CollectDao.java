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
public interface CollectDao {
	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	List<Collect> searchByPage(Map<String,Object> searchParams);
	
	/**
	 * 按条件查询记录
	 * @param searchParams 条件
	 * @return
	 */
	List<Collect> search(Map<String,Object> searchParams);
	
	/**
	 * 获取所有记录
	 * @return
	 */
	List<Collect> findAll();
	
	/**
	 * 通过 collectId 获取一条记录
	 * @param collectId 主键
	 * @return
	 */
	Collect findById(String collectId);
	
	/**
	 * 保存一条记录
	 * @param collect
	 */
	void save(Collect collect);
	
	/**
	 * 通过collect删除一条记录
	 * @param collect
	 */
	void delete(String collectId);
	
	/**
	 * 通过userId和topicId删除一条记录
	 * @param collect
	 */
	void deleteByUserTopic(Collect collect);
	
	/**
	 * 修改记录
	 * @param collect
	 */
	void update(Collect collect);
}