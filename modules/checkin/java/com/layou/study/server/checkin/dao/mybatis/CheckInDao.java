package com.layou.study.server.checkin.dao.mybatis;

import java.util.List;
import java.util.Map;

import com.layou.study.server.checkin.domain.*;

import core.mybatis.MyBatisRepository;

/**
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * 
 */
@MyBatisRepository
public interface CheckInDao {
	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	List<CheckIn> searchByPage(Map<String,Object> searchParams);
	
	/**
	 * 按条件查询记录
	 * @param searchParams 条件
	 * @return
	 */
	List<CheckIn> search(Map<String,Object> searchParams);
	
	/**
	 * 获取所有记录
	 * @return
	 */
	List<CheckIn> findAll();
	
	/**
	 * 通过 checkId 获取一条记录
	 * @param checkId 主键
	 * @return
	 */
	CheckIn findById(String checkId);
	
	/**
	 * 保存一条记录
	 * @param checkIn
	 */
	void save(CheckIn checkIn);
	
	/**
	 * 通过checkIn删除一条记录
	 * @param checkIn
	 */
	void delete(String checkId);
	
	/**
	 * 修改记录
	 * @param checkIn
	 */
	void update(CheckIn checkIn);
}