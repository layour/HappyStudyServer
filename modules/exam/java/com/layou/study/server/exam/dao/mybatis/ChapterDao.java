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
public interface ChapterDao {
	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	List<Chapter> searchByPage(Map<String,Object> searchParams);
	
	/**
	 * 按条件查询记录
	 * @param searchParams 条件
	 * @return
	 */
	List<Chapter> search(Map<String,Object> searchParams);
	
	/**
	 * 获取所有记录
	 * @return
	 */
	List<Chapter> findAll();
	
	/**
	 * 通过 chapterId 获取一条记录
	 * @param chapterId 主键
	 * @return
	 */
	Chapter findById(String chapterId);
	
	/**
	 * 保存一条记录
	 * @param chapter
	 */
	void save(Chapter chapter);
	
	/**
	 * 通过chapter删除一条记录
	 * @param chapter
	 */
	void delete(String chapterId);
	
	/**
	 * 修改记录
	 * @param chapter
	 */
	void update(Chapter chapter);
}