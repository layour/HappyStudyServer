package com.layou.study.server.opinion.controller;

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

import com.layou.study.server.checkin.domain.CheckIn;
import com.layou.study.server.checkin.util.DateTimeUtil;
import com.layou.study.server.opinion.domain.*;
import com.layou.study.server.opinion.service.*;

import core.mybatis.PageParameter;
import core.spring.RequestMappingName;
import core.utils.jackson.JacksonUtil;

@Controller
@RequestMapping(value = "/opinion")
public class OpinionController {
	
	@Autowired
	private OpinionService opinionService;
	
	/**
	 * 跳转到管理页面
	 * @return
	 */
	@RequestMappingName(value = "打开管理页面")
	@RequestMapping(value = "toManagerPage",  method = RequestMethod.GET)
	public String toManagerPage() {
		return "opinion/opinion/opinionList";
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
		
		List<Opinion> opinions = opinionService.searchByPage(searchParams);
		
		model.addAttribute("total", pageSize * pageNumber * 10);
		model.addAttribute("rows", opinions);
		
		return new JacksonUtil().getJson(model);
	}
	
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMappingName(value = "打开增加页面")
	@RequestMapping(value = "toAddPage",  method = RequestMethod.GET)
	public String toAddPage() {
		return "opinion/opinion/opinionAdd";
	}
	
	/**
	 * 执行保存操作
	 * @param opinion
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "保存")
	@RequestMapping(value = "save",  method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public String save(@Valid Opinion opinion, RedirectAttributes redirectAttributes) {
		opinionService.save(opinion);
		return "opinion/opinion/opinionList";
	}
	
	/**
	 * 执行保存操作
	 * @param opinion
	 * @return
	 */
	@RequestMappingName(value = "移动保存")
	@RequestMapping(value="mobileSave", method = { RequestMethod.GET,RequestMethod.POST },produces = "application/json; charset=utf-8")  
	@ResponseBody
	public String mobileSave(@Valid Opinion opinion) {
		String dateTime = DateTimeUtil.getDateTime();
		opinion.setOpinionTime(dateTime);
		
		opinionService.save(opinion);
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("code", "0");
		result.put("msg", "签到成功");
		
		return new JacksonUtil().getJson(result);
	}
	
	/**
	 * 跳转到修改页面
	 * @param opinionId
	 * @param model
	 * @return
	 */
	@RequestMappingName(value = "打开修改页面")
	@RequestMapping(value = "toUpdatePage/{opinionId}",  method = RequestMethod.GET)
	public String toUpdatePage(@PathVariable("opinionId") String opinionId, Model model) {
		model.addAttribute("opinion", opinionService.findById(opinionId));
		return "opinion/opinion/opinionUpdate";
	}
	
	/**
	 * 执行修改操作
	 * @param opinion
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "修改")
	@RequestMapping(value = "update",  method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public String update(@Valid @ModelAttribute("opinion") Opinion opinion, RedirectAttributes redirectAttributes) {
		opinionService.update(opinion);
		redirectAttributes.addFlashAttribute("message", "更新成功");
		return "opinion/opinion/opinionList";
	}
	
	/**
	 * 跳转详细页面
	 * @param opinionId
	 * @param model
	 * @return
	 */
	@RequestMappingName(value = "打开详细页面")
	@RequestMapping(value = "toDetailPage/{opinionId}",  method = RequestMethod.GET)
	public String toDetailPage(@PathVariable("opinionId") String opinionId, Model model) {
		model.addAttribute("opinion", opinionService.findById(opinionId));
		return "opinion/opinion/opinionDetail";
	}
	
	/**
	 * 执行删除操作
	 * @param opinionId
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "删除")
	@RequestMapping(value = "delete/{opinionId}")
	public String delete(@PathVariable("opinionId") String opinionId, RedirectAttributes redirectAttributes) {
		opinionService.delete(opinionId);
		redirectAttributes.addFlashAttribute("message", "删除成功");
		return "opinion/opinion/opinionList";
	}
}
