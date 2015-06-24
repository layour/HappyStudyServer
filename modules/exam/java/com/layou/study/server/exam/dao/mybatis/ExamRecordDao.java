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
public interface ExamRecordDao {
	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	List<ExamRecord> searchByPage(Map<String,Object> searchParams);
	
	/**
	 * 按条件查询记录
	 * @param searchParams 条件
	 * @return
	 */
	List<ExamRecord> search(Map<String,Object> searchParams);
	
	/**
	 * 获取所有记录
	 * @return
	 */
	List<ExamRecord> findAll();
	
	/**
	 * 通过 examRecordId 获取一条记录
	 * @param examRecordId 主键
	 * @return
	 */
	ExamRecord findById(String examRecordId);
	
	/**
	 * 保存一条记录
	 * @param examRecord
	 */
	void save(ExamRecord examRecord);
	
	/**
	 * 通过examRecord删除一条记录
	 * @param examRecord
	 */
	void delete(String examRecordId);
	
	/**
	 * 修改记录
	 * @param examRecord
	 */
	void update(ExamRecord examRecord);
}