package com.layou.study.server.register.dao.mybatis;

import java.util.List;
import java.util.Map;

import com.layou.study.server.register.domain.*;

import core.mybatis.MyBatisRepository;

/**
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * 
 */
@MyBatisRepository
public interface TeamClassDao {
	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	List<TeamClass> searchByPage(Map<String,Object> searchParams);
	
	/**
	 * 按条件查询记录
	 * @param searchParams 条件
	 * @return
	 */
	List<TeamClass> search(Map<String,Object> searchParams);
	
	/**
	 * 获取所有记录
	 * @return
	 */
	List<TeamClass> findAll();
	
	/**
	 * 通过 teamClassId 获取一条记录
	 * @param teamClassId 主键
	 * @return
	 */
	TeamClass findById(String teamClassId);
	
	/**
	 * 保存一条记录
	 * @param teamClass
	 */
	void save(TeamClass teamClass);
	
	/**
	 * 通过teamClass删除一条记录
	 * @param teamClass
	 */
	void delete(String teamClassId);
	
	/**
	 * 修改记录
	 * @param teamClass
	 */
	void update(TeamClass teamClass);
}