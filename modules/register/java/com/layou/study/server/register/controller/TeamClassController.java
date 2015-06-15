package com.layou.study.server.register.controller;

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
@RequestMapping(value = "/teamClass")
public class TeamClassController {
	
	@Autowired
	private TeamClassService teamClassService;
	
	/**
	 * 跳转到管理页面
	 * @return
	 */
	@RequestMappingName(value = "打开管理页面")
	@RequestMapping(value = "toManagerPage", method = RequestMethod.GET)
	public String toManagerPage() {
		return "register/teamClass/teamClassList";
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
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public @ResponseBody String list(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = PageParameter.DEFAULT_PAGE_SIZE+"") int pageSize, 
			Model model, ServletRequest request) {
		
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		
		PageParameter page = new PageParameter();
		page.setCurrentPage(pageNumber);
		page.setPageSize(pageSize);
		searchParams.put("page", page);
		
		List<TeamClass> teamClasss = teamClassService.searchByPage(searchParams);
		
		model.addAttribute("total", pageSize * pageNumber * 10);
		model.addAttribute("rows", teamClasss);
		
		return new JacksonUtil().getJson(model);
	}
	
	/**
	 * 查询所有
	 * @param pageNumber
	 * @param pageSize
	 * @param sortType
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMappingName(value = "查询列表")
	@RequestMapping(value = "mobileList", method = RequestMethod.GET)
	public @ResponseBody String mobileList(Model model, ServletRequest request) {
		
		List<TeamClass> teamClasss = teamClassService.findAll();
		
		model.addAttribute("total", teamClasss.size());
		model.addAttribute("rows", teamClasss);
		
		return new JacksonUtil().getJson(model);
	}
	
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMappingName(value = "打开增加页面")
	@RequestMapping(value = "toAddPage", method = RequestMethod.GET)
	public String toAddPage() {
		return "register/teamClass/teamClassAdd";
	}
	
	/**
	 * 执行保存操作
	 * @param teamClass
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "保存")
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@Valid TeamClass teamClass, RedirectAttributes redirectAttributes) {
		teamClassService.save(teamClass);
		return "register/teamClass/teamClassList";
	}
	
	/**
	 * 跳转到修改页面
	 * @param teamClassId
	 * @param model
	 * @return
	 */
	@RequestMappingName(value = "打开修改页面")
	@RequestMapping(value = "toUpdatePage/{teamClassId}", method = RequestMethod.GET)
	public String toUpdatePage(@PathVariable("teamClassId") String teamClassId, Model model) {
		model.addAttribute("teamClass", teamClassService.findById(teamClassId));
		return "register/teamClass/teamClassUpdate";
	}
	
	/**
	 * 执行修改操作
	 * @param teamClass
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "修改")
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("teamClass") TeamClass teamClass, RedirectAttributes redirectAttributes) {
		teamClassService.update(teamClass);
		redirectAttributes.addFlashAttribute("message", "更新成功");
		return "register/teamClass/teamClassList";
	}
	
	/**
	 * 跳转详细页面
	 * @param teamClassId
	 * @param model
	 * @return
	 */
	@RequestMappingName(value = "打开详细页面")
	@RequestMapping(value = "toDetailPage/{teamClassId}", method = RequestMethod.GET)
	public String toDetailPage(@PathVariable("teamClassId") String teamClassId, Model model) {
		model.addAttribute("teamClass", teamClassService.findById(teamClassId));
		return "register/teamClass/teamClassDetail";
	}
	
	/**
	 * 执行删除操作
	 * @param teamClassId
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "删除")
	@RequestMapping(value = "delete/{teamClassId}")
	public String delete(@PathVariable("teamClassId") String teamClassId, RedirectAttributes redirectAttributes) {
		teamClassService.delete(teamClassId);
		redirectAttributes.addFlashAttribute("message", "删除成功");
		return "register/teamClass/teamClassList";
	}
}
