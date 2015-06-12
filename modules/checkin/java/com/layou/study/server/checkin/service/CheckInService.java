package com.layou.study.server.checkin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.layou.study.server.checkin.domain.*;
import com.layou.study.server.checkin.dao.mybatis.*;

import core.utils.ComUtil;

@Service
@Transactional
public class CheckInService {

	@Autowired
	private CheckInDao checkInDao;
	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	public List<CheckIn> searchByPage(Map<String,Object> searchParams) {
		return (List<CheckIn>) checkInDao.searchByPage(searchParams);
	}

	/**
	 * 按条件查询记录
	 * @param searchParams 条件
	 * @return
	 */
	public List<CheckIn> search(Map<String,Object> searchParams) {
		return (List<CheckIn>) checkInDao.search(searchParams);
	}

	/**
	 * 获取所有记录
	 * @return
	 */
	public List<CheckIn> findAll() {
		return (List<CheckIn>) checkInDao.findAll();
	}
	
	/**
	 * 通过checkId获取一条记录
	 * @param checkId 主键
	 * @return
	 */
	public CheckIn findById(String checkId) {
		CheckIn checkIn = checkInDao.findById(checkId);
		if(checkIn == null){
			checkIn = new CheckIn();
		}
		return checkIn;
	}

	/**
	 * 保存一条记录
	 * @param checkIn
	 */
	public void save(CheckIn checkIn) {
		checkIn.setCheckId(ComUtil.getId());
		checkInDao.save(checkIn);
	}

	/**
	 * 通过 checkId 删除一条记录
	 * @param checkId 主键
	 */
	public void delete(String checkId) {
		checkInDao.delete(checkId);

	}
	
	/**
	 * 修改记录
	 * @param checkIn
	 */
	public void update(CheckIn checkIn) {
		checkInDao.update(checkIn);
	}
}
