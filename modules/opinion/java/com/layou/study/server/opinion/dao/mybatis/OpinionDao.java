package com.layou.study.server.opinion.dao.mybatis;

import java.util.List;
import java.util.Map;

import com.layou.study.server.opinion.domain.*;

import core.mybatis.MyBatisRepository;

/**
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * 
 */
@MyBatisRepository
public interface OpinionDao {
	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	List<Opinion> searchByPage(Map<String,Object> searchParams);
	
	/**
	 * 按条件查询记录
	 * @param searchParams 条件
	 * @return
	 */
	List<Opinion> search(Map<String,Object> searchParams);
	
	/**
	 * 获取所有记录
	 * @return
	 */
	List<Opinion> findAll();
	
	/**
	 * 通过 opinionId 获取一条记录
	 * @param opinionId 主键
	 * @return
	 */
	Opinion findById(String opinionId);
	
	/**
	 * 保存一条记录
	 * @param opinion
	 */
	void save(Opinion opinion);
	
	/**
	 * 通过opinion删除一条记录
	 * @param opinion
	 */
	void delete(String opinionId);
	
	/**
	 * 修改记录
	 * @param opinion
	 */
	void update(Opinion opinion);
}