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
public class PaperService {

	@Autowired
	private PaperDao paperDao;
	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	public List<Paper> searchByPage(Map<String,Object> searchParams) {
		return (List<Paper>) paperDao.searchByPage(searchParams);
	}

	/**
	 * 按条件查询记录
	 * @param searchParams 条件
	 * @return
	 */
	public List<Paper> search(Map<String,Object> searchParams) {
		return (List<Paper>) paperDao.search(searchParams);
	}

	/**
	 * 获取所有记录
	 * @return
	 */
	public List<Paper> findAll() {
		return (List<Paper>) paperDao.findAll();
	}
	
	/**
	 * 通过paperId获取一条记录
	 * @param paperId 主键
	 * @return
	 */
	public Paper findById(String paperId) {
		Paper paper = paperDao.findById(paperId);
		if(paper == null){
			paper = new Paper();
		}
		return paper;
	}

	/**
	 * 保存一条记录
	 * @param paper
	 */
	public void save(Paper paper) {
		paper.setPaperId(ComUtil.getId());
		paperDao.save(paper);
	}

	/**
	 * 通过 paperId 删除一条记录
	 * @param paperId 主键
	 */
	public void delete(String paperId) {
		paperDao.delete(paperId);

	}
	
	/**
	 * 修改记录
	 * @param paper
	 */
	public void update(Paper paper) {
		paperDao.update(paper);
	}
}
