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
import com.layou.study.server.exam.service.ExamRecordService;

/**
 * Restful API的Controller.
 * 
 */
@Controller
@RequestMapping(value = "/api/examRecord")
public class ExamRecordRestController {

	private static Logger logger = LoggerFactory.getLogger(ExamRecordRestController.class);

	@Autowired
	private ExamRecordService examRecordService;

	@Autowired
	private Validator validator;
	
	/**
	 * 获取全部
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public List<ExamRecord> list() {
		return examRecordService.findAll();
	}
	
	/**
	 * 获取单个记录
	 * @param examRecordId 主键
	 * @return
	 */
	@RequestMapping(value = "/{examRecordId}", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public ExamRecord get(@PathVariable("examRecordId") String examRecordId) {
		ExamRecord examRecord = examRecordService.findById(examRecordId);
		if (examRecord == null) {
			String message = "不存在(examRecordId:" + examRecordId + ")";
			logger.warn(message);
			throw new RestException(HttpStatus.NOT_FOUND, message);
		}
		return examRecord;
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaTypes.JSON)
	public ResponseEntity<?> create(@RequestBody ExamRecord examRecord, UriComponentsBuilder uriBuilder) {
		// 调用JSR303 Bean Validator进行校验, 异常将由RestExceptionHandler统一处理.
		BeanValidators.validateWithException(validator, examRecord);
		// 保存任务
		examRecordService.save(examRecord);

		// 按照Restful风格约定，创建指向新任务的url, 也可以直接返回examRecordId或对象.
		String examRecordId = examRecord.getExamRecordId();
		URI uri = uriBuilder.path("/api/examRecord/" + examRecordId).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{examRecordId}", method = RequestMethod.PUT, consumes = MediaTypes.JSON)
	// 按Restful风格约定，返回204状态码, 无内容. 也可以返回200状态码.
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody ExamRecord examRecord) {
		// 调用JSR303 Bean Validator进行校验, 异常将由RestExceptionHandler统一处理.
		BeanValidators.validateWithException(validator, examRecord);
		// 保存任务
		examRecordService.update(examRecord);
	}

	@RequestMapping(value = "/{examRecordId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("examRecordId") String examRecordId) {
		examRecordService.delete(examRecordId);
	}
}
