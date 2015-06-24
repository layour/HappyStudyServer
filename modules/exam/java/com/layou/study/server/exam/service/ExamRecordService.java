package com.layou.study.server.exam.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.layou.study.server.exam.domain.*;
import com.layou.study.server.exam.dao.mybatis.*;

import core.utils.ComUtil;

@Service
@Transactional
public class ExamRecordService {

	@Autowired
	private ExamRecordDao examRecordDao;
	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	public List<ExamRecord> searchByPage(Map<String,Object> searchParams) {
		return (List<ExamRecord>) examRecordDao.searchByPage(searchParams);
	}

	/**
	 * 按条件查询记录
	 * @param searchParams 条件
	 * @return
	 */
	public List<ExamRecord> search(Map<String,Object> searchParams) {
		return (List<ExamRecord>) examRecordDao.search(searchParams);
	}

	/**
	 * 获取所有记录
	 * @return
	 */
	public List<ExamRecord> findAll() {
		return (List<ExamRecord>) examRecordDao.findAll();
	}
	
	/**
	 * 通过examRecordId获取一条记录
	 * @param examRecordId 主键
	 * @return
	 */
	public ExamRecord findById(String examRecordId) {
		ExamRecord examRecord = examRecordDao.findById(examRecordId);
		if(examRecord == null){
			examRecord = new ExamRecord();
		}
		return examRecord;
	}

	/**
	 * 保存一条记录
	 * @param examRecord
	 */
	public void save(ExamRecord examRecord) {
		examRecord.setExamRecordId(ComUtil.getId());
		examRecordDao.save(examRecord);
	}

	/**
	 * 通过 examRecordId 删除一条记录
	 * @param examRecordId 主键
	 */
	public void delete(String examRecordId) {
		examRecordDao.delete(examRecordId);

	}
	
	/**
	 * 修改记录
	 * @param examRecord
	 */
	public void update(ExamRecord examRecord) {
		examRecordDao.update(examRecord);
	}
}
