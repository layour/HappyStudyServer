package com.layou.study.server.checkin.rest;

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

import com.layou.study.server.checkin.domain.*;
import com.layou.study.server.checkin.service.CheckInService;

/**
 * Restful API的Controller.
 * 
 */
@Controller
@RequestMapping(value = "/api/checkIn")
public class CheckInRestController {

	private static Logger logger = LoggerFactory.getLogger(CheckInRestController.class);

	@Autowired
	private CheckInService checkInService;

	@Autowired
	private Validator validator;
	
	/**
	 * 获取全部
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public List<CheckIn> list() {
		return checkInService.findAll();
	}
	
	/**
	 * 获取单个记录
	 * @param checkId 主键
	 * @return
	 */
	@RequestMapping(value = "/{checkId}", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public CheckIn get(@PathVariable("checkId") String checkId) {
		CheckIn checkIn = checkInService.findById(checkId);
		if (checkIn == null) {
			String message = "不存在(checkId:" + checkId + ")";
			logger.warn(message);
			throw new RestException(HttpStatus.NOT_FOUND, message);
		}
		return checkIn;
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaTypes.JSON)
	public ResponseEntity<?> create(@RequestBody CheckIn checkIn, UriComponentsBuilder uriBuilder) {
		// 调用JSR303 Bean Validator进行校验, 异常将由RestExceptionHandler统一处理.
		BeanValidators.validateWithException(validator, checkIn);
		// 保存任务
		checkInService.save(checkIn);

		// 按照Restful风格约定，创建指向新任务的url, 也可以直接返回checkId或对象.
		String checkId = checkIn.getCheckId();
		URI uri = uriBuilder.path("/api/checkIn/" + checkId).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{checkId}", method = RequestMethod.PUT, consumes = MediaTypes.JSON)
	// 按Restful风格约定，返回204状态码, 无内容. 也可以返回200状态码.
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody CheckIn checkIn) {
		// 调用JSR303 Bean Validator进行校验, 异常将由RestExceptionHandler统一处理.
		BeanValidators.validateWithException(validator, checkIn);
		// 保存任务
		checkInService.update(checkIn);
	}

	@RequestMapping(value = "/{checkId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("checkId") String checkId) {
		checkInService.delete(checkId);
	}
}
