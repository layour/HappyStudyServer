package com.layou.study.server.register.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springside.modules.web.Servlets;

import com.layou.study.server.register.domain.*;
import com.layou.study.server.register.service.*;

import core.mybatis.PageParameter;
import core.spring.RequestMappingName;
import core.utils.jackson.JacksonUtil;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 跳转到管理页面
	 * @return
	 */
	@RequestMappingName(value = "打开管理页面")
	@RequestMapping(value = "toManagerPage",  method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public String toManagerPage() {
		return "register/user/userList";
	}
	
	/**
	 * 分页查询
	 * @param pageNumber
	 * @param pageSize
	 * @param sortType
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMappingName(value = "查询列表")
	@RequestMapping(value = "list",  method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public @ResponseBody String list(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = PageParameter.DEFAULT_PAGE_SIZE+"") int pageSize, 
			Model model, ServletRequest request) {
		
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		
		PageParameter page = new PageParameter();
		page.setCurrentPage(pageNumber);
		page.setPageSize(pageSize);
		searchParams.put("page", page);
		
		List<User> users = userService.searchByPage(searchParams);
		
		model.addAttribute("total", pageSize * pageNumber * 10);
		model.addAttribute("rows", users);
		
		return new JacksonUtil().getJson(model);
	}
	
	/**
	 * 登录验证
	 * @param pageNumber
	 * @param pageSize
	 * @param sortType
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMappingName(value = "登录")
	@RequestMapping(value="login", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String login(Model model, ServletRequest request) {
		
		String loginName = request.getParameter("loginName");//获取用户登录账号
		String loginPwd = request.getParameter("loginPwd");//获取用户登录密码
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		User user = userService.findByPhoneNo(loginName);
		if(loginPwd.equals(user.getPassword())){
			result.put("code", "0");
			result.put("msg", "登录成功");
			result.put("user", user);
		} else if(user.getPhoneNo() == null){
			result.put("code", "1");
			result.put("msg", "无此用户");
		} else {
			result.put("code", "2");
			result.put("msg", "用户名或密码错误");
		}
		
		return new JacksonUtil().getJson(result);
	}
	
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMappingName(value = "打开增加页面")
	@RequestMapping(value = "toAddPage",  method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public String toAddPage() {
		return "register/user/userAdd";
	}
	
	/**
	 * 执行保存操作
	 * @param user
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "保存")
	@RequestMapping(value = "save",  method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public String save(@Valid User user, RedirectAttributes redirectAttributes) {
		userService.save(user);
		return "register/user/userList";
	}
	
	/**
	 * 执行保存操作
	 * @param user
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "移动保存")
	@RequestMapping(value="mobileSave", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")  
	@ResponseBody
	public String mobileSave(@Valid User user, Model model) {
		userService.save(user);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "0");
		result.put("msg", "注册成功");
		result.put("user", user);
		
		return new JacksonUtil().getJson(result);
	}
	
	/**
	 * 跳转到修改页面
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMappingName(value = "打开修改页面")
	@RequestMapping(value = "toUpdatePage/{userId}",  method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public String toUpdatePage(@PathVariable("userId") String userId, Model model) {
		model.addAttribute("user", userService.findById(userId));
		return "register/user/userUpdate";
	}
	
	/**
	 * 执行修改操作
	 * @param user
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "修改")
	@RequestMapping(value = "update",  method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public String update(@Valid @ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
		userService.update(user);
		redirectAttributes.addFlashAttribute("message", "更新成功");
		return "register/user/userList";
	}
	
	/**
	 * 跳转详细页面
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMappingName(value = "打开详细页面")
	@RequestMapping(value = "toDetailPage/{userId}",  method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public String toDetailPage(@PathVariable("userId") String userId, Model model) {
		model.addAttribute("user", userService.findById(userId));
		return "register/user/userDetail";
	}
	
	/**
	 * 执行删除操作
	 * @param userId
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "删除")
	@RequestMapping(value = "delete/{userId}")
	public String delete(@PathVariable("userId") String userId, RedirectAttributes redirectAttributes) {
		userService.delete(userId);
		redirectAttributes.addFlashAttribute("message", "删除成功");
		return "register/user/userList";
	}
}
