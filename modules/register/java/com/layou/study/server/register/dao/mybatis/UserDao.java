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
public interface UserDao {
	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	List<User> searchByPage(Map<String,Object> searchParams);
	
	/**
	 * 按条件查询记录
	 * @param searchParams 条件
	 * @return
	 */
	List<User> search(Map<String,Object> searchParams);
	
	/**
	 * 获取所有记录
	 * @return
	 */
	List<User> findAll();
	
	/**
	 * 通过 phoneNo 获取一条记录
	 * @param phoneNo 唯一约束
	 * @return
	 */
	User findById(String userId);
	
	/**
	 * 通过 userId 获取一条记录
	 * @param userId 主键
	 * @return
	 */
	User findByPhoneNo(String phoneNo);
	
	/**
	 * 保存一条记录
	 * @param user
	 */
	void save(User user);
	
	/**
	 * 通过user删除一条记录
	 * @param user
	 */
	void delete(String userId);
	
	/**
	 * 修改记录
	 * @param user
	 */
	void update(User user);
}