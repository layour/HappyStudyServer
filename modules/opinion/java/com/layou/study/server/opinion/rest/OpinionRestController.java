package com.layou.study.server.opinion.rest;

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

import com.layou.study.server.opinion.domain.*;
import com.layou.study.server.opinion.service.OpinionService;

/**
 * Restful API的Controller.
 * 
 */
@Controller
@RequestMapping(value = "/api/opinion")
public class OpinionRestController {

	private static Logger logger = LoggerFactory.getLogger(OpinionRestController.class);

	@Autowired
	private OpinionService opinionService;

	@Autowired
	private Validator validator;
	
	/**
	 * 获取全部
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public List<Opinion> list() {
		return opinionService.findAll();
	}
	
	/**
	 * 获取单个记录
	 * @param opinionId 主键
	 * @return
	 */
	@RequestMapping(value = "/{opinionId}", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public Opinion get(@PathVariable("opinionId") String opinionId) {
		Opinion opinion = opinionService.findById(opinionId);
		if (opinion == null) {
			String message = "不存在(opinionId:" + opinionId + ")";
			logger.warn(message);
			throw new RestException(HttpStatus.NOT_FOUND, message);
		}
		return opinion;
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaTypes.JSON)
	public ResponseEntity<?> create(@RequestBody Opinion opinion, UriComponentsBuilder uriBuilder) {
		// 调用JSR303 Bean Validator进行校验, 异常将由RestExceptionHandler统一处理.
		BeanValidators.validateWithException(validator, opinion);
		// 保存任务
		opinionService.save(opinion);

		// 按照Restful风格约定，创建指向新任务的url, 也可以直接返回opinionId或对象.
		String opinionId = opinion.getOpinionId();
		URI uri = uriBuilder.path("/api/opinion/" + opinionId).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{opinionId}", method = RequestMethod.PUT, consumes = MediaTypes.JSON)
	// 按Restful风格约定，返回204状态码, 无内容. 也可以返回200状态码.
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody Opinion opinion) {
		// 调用JSR303 Bean Validator进行校验, 异常将由RestExceptionHandler统一处理.
		BeanValidators.validateWithException(validator, opinion);
		// 保存任务
		opinionService.update(opinion);
	}

	@RequestMapping(value = "/{opinionId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("opinionId") String opinionId) {
		opinionService.delete(opinionId);
	}
}
