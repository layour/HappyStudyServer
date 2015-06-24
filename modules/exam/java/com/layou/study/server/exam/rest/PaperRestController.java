package com.layou.study.server.exam.rest;

import java.net.URI;
import java.util.List;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;
import org.springside.modules.beanvalidator.BeanValidators;
import org.springside.modules.web.MediaTypes;

import core.rest.RestException;

import com.layou.study.server.exam.domain.*;
import com.layou.study.server.exam.service.PaperService;

/**
 * Restful API的Controller.
 * 
 */
@Controller
@RequestMapping(value = "/api/paper")
public class PaperRestController {

	private static Logger logger = LoggerFactory.getLogger(PaperRestController.class);

	@Autowired
	private PaperService paperService;

	@Autowired
	private Validator validator;
	
	/**
	 * 获取全部
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public List<Paper> list() {
		return paperService.findAll();
	}
	
	/**
	 * 获取单个记录
	 * @param paperId 主键
	 * @return
	 */
	@RequestMapping(value = "/{paperId}", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public Paper get(@PathVariable("paperId") String paperId) {
		Paper paper = paperService.findById(paperId);
		if (paper == null) {
			String message = "不存在(paperId:" + paperId + ")";
			logger.warn(message);
			throw new RestException(HttpStatus.NOT_FOUND, message);
		}
		return paper;
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaTypes.JSON)
	public ResponseEntity<?> create(@RequestBody Paper paper, UriComponentsBuilder uriBuilder) {
		// 调用JSR303 Bean Validator进行校验, 异常将由RestExceptionHandler统一处理.
		BeanValidators.validateWithException(validator, paper);
		// 保存任务
		paperService.save(paper);

		// 按照Restful风格约定，创建指向新任务的url, 也可以直接返回paperId或对象.
		String paperId = paper.getPaperId();
		URI uri = uriBuilder.path("/api/paper/" + paperId).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{paperId}", method = RequestMethod.PUT, consumes = MediaTypes.JSON)
	// 按Restful风格约定，返回204状态码, 无内容. 也可以返回200状态码.
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody Paper paper) {
		// 调用JSR303 Bean Validator进行校验, 异常将由RestExceptionHandler统一处理.
		BeanValidators.validateWithException(validator, paper);
		// 保存任务
		paperService.update(paper);
	}

	@RequestMapping(value = "/{paperId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("paperId") String paperId) {
		paperService.delete(paperId);
	}
}
