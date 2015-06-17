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
public class ChapterService {

	@Autowired
	private ChapterDao chapterDao;
	
	/**
	 * 按条件分页查询记录
	 * @param searchParams 条件
	 * @return
	 */
	public List<Chapter> searchByPage(Map<String,Object> searchParams) {
		return (List<Chapter>) chapterDao.searchByPage(searchParams);
	}

	/**
	 * 按条件查询记录
	 * @param searchParams 条件
	 * @return
	 */
	public List<Chapter> search(Map<String,Object> searchParams) {
		return (List<Chapter>) chapterDao.search(searchParams);
	}

	/**
	 * 获取所有记录
	 * @return
	 */
	public List<Chapter> findAll() {
		return (List<Chapter>) chapterDao.findAll();
	}
	
	/**
	 * 通过chapterId获取一条记录
	 * @param chapterId 主键
	 * @return
	 */
	public Chapter findById(String chapterId) {
		Chapter chapter = chapterDao.findById(chapterId);
		if(chapter == null){
			chapter = new Chapter();
		}
		return chapter;
	}

	/**
	 * 保存一条记录
	 * @param chapter
	 */
	public void save(Chapter chapter) {
		chapter.setChapterId(ComUtil.getId());
		chapterDao.save(chapter);
	}

	/**
	 * 通过 chapterId 删除一条记录
	 * @param chapterId 主键
	 */
	public void delete(String chapterId) {
		chapterDao.delete(chapterId);

	}
	
	/**
	 * 修改记录
	 * @param chapter
	 */
	public void update(Chapter chapter) {
		chapterDao.update(chapter);
	}
}
