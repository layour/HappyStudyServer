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
public interface PaperDao {
	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	List<Paper> searchByPage(Map<String,Object> searchParams);
	
	/**
	 * 按条件查询记录
	 * @param searchParams 条件
	 * @return
	 */
	List<Paper> search(Map<String,Object> searchParams);
	
	/**
	 * 获取所有记录
	 * @return
	 */
	List<Paper> findAll();
	
	/**
	 * 通过 paperId 获取一条记录
	 * @param paperId 主键
	 * @return
	 */
	Paper findById(String paperId);
	
	/**
	 * 保存一条记录
	 * @param paper
	 */
	void save(Paper paper);
	
	/**
	 * 通过paper删除一条记录
	 * @param paper
	 */
	void delete(String paperId);
	
	/**
	 * 修改记录
	 * @param paper
	 */
	void update(Paper paper);
}