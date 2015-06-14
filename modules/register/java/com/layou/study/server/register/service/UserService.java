package com.layou.study.server.register.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.layou.study.server.register.domain.*;
import com.layou.study.server.register.dao.mybatis.*;

import core.utils.ComUtil;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;
	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	public List<User> searchByPage(Map<String,Object> searchParams) {
		return (List<User>) userDao.searchByPage(searchParams);
	}

	/**
	 * 按条件查询记录
	 * @param searchParams 条件
	 * @return
	 */
	public List<User> search(Map<String,Object> searchParams) {
		return (List<User>) userDao.search(searchParams);
	}

	/**
	 * 获取所有记录
	 * @return
	 */
	public List<User> findAll() {
		return (List<User>) userDao.findAll();
	}
	
	/**
	 * 通过userId获取一条记录
	 * @param userId 主键
	 * @return
	 */
	public User findById(String userId) {
		User user = userDao.findById(userId);
		if(user == null){
			user = new User();
		}
		return user;
	}
	
	/**
	 * 通过phoneNo获取一条记录
	 * @param phoneNo 唯一约束
	 * @return
	 */
	public User findByPhoneNo(String phoneNo) {
		User user = userDao.findByPhoneNo(phoneNo);
		if(user == null){
			user = new User();
		}
		return user;
	}

	/**
	 * 保存一条记录
	 * @param user
	 */
	public void save(User user) {
		user.setUserId(ComUtil.getId());
		userDao.save(user);
	}

	/**
	 * 通过 userId 删除一条记录
	 * @param userId 主键
	 */
	public void delete(String userId) {
		userDao.delete(userId);

	}
	
	/**
	 * 修改记录
	 * @param user
	 */
	public void update(User user) {
		userDao.update(user);
	}
}
