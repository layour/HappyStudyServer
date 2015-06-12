package com.layou.study.server.register.rest;

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

import com.layou.study.server.register.domain.*;
import com.layou.study.server.register.service.TeamClassService;

/**
 * Restful API的Controller.
 * 
 */
@Controller
@RequestMapping(value = "/api/teamClass")
public class TeamClassRestController {

	private static Logger logger = LoggerFactory.getLogger(TeamClassRestController.class);

	@Autowired
	private TeamClassService teamClassService;

	@Autowired
	private Validator validator;
	
	/**
	 * 获取全部
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public List<TeamClass> list() {
		return teamClassService.findAll();
	}
	
	/**
	 * 获取单个记录
	 * @param teamClassId 主键
	 * @return
	 */
	@RequestMapping(value = "/{teamClassId}", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	public TeamClass get(@PathVariable("teamClassId") String teamClassId) {
		TeamClass teamClass = teamClassService.findById(teamClassId);
		if (teamClass == null) {
			String message = "不存在(teamClassId:" + teamClassId + ")";
			logger.warn(message);
			throw new RestException(HttpStatus.NOT_FOUND, message);
		}
		return teamClass;
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaTypes.JSON)
	public ResponseEntity<?> create(@RequestBody TeamClass teamClass, UriComponentsBuilder uriBuilder) {
		// 调用JSR303 Bean Validator进行校验, 异常将由RestExceptionHandler统一处理.
		BeanValidators.validateWithException(validator, teamClass);
		// 保存任务
		teamClassService.save(teamClass);

		// 按照Restful风格约定，创建指向新任务的url, 也可以直接返回teamClassId或对象.
		String teamClassId = teamClass.getTeamClassId();
		URI uri = uriBuilder.path("/api/teamClass/" + teamClassId).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{teamClassId}", method = RequestMethod.PUT, consumes = MediaTypes.JSON)
	// 按Restful风格约定，返回204状态码, 无内容. 也可以返回200状态码.
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody TeamClass teamClass) {
		// 调用JSR303 Bean Validator进行校验, 异常将由RestExceptionHandler统一处理.
		BeanValidators.validateWithException(validator, teamClass);
		// 保存任务
		teamClassService.update(teamClass);
	}

	@RequestMapping(value = "/{teamClassId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("teamClassId") String teamClassId) {
		teamClassService.delete(teamClassId);
	}
}
