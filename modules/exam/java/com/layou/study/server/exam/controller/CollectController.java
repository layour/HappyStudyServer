package com.layou.study.server.exam.controller;

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

import com.layou.study.server.exam.domain.*;
import com.layou.study.server.exam.service.*;

import core.mybatis.PageParameter;
import core.spring.RequestMappingName;
import core.utils.jackson.JacksonUtil;

@Controller
@RequestMapping(value = "/collect")
public class CollectController {
	
	@Autowired
	private CollectService collectService;
	
	/**
	 * 跳转到管理页面
	 * @return
	 */
	@RequestMappingName(value = "打开管理页面")
	@RequestMapping(value = "toManagerPage", method = RequestMethod.GET)
	public String toManagerPage() {
		return "exam/collect/collectList";
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
	@RequestMapping(value = "list", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public @ResponseBody String list(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = PageParameter.DEFAULT_PAGE_SIZE+"") int pageSize, 
			Model model, ServletRequest request) {
		
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		
		PageParameter page = new PageParameter();
		page.setCurrentPage(pageNumber);
		page.setPageSize(pageSize);
		searchParams.put("page", page);
		
		List<Collect> collects = collectService.searchByPage(searchParams);
		
		model.addAttribute("total", pageSize * pageNumber * 10);
		model.addAttribute("rows", collects);
		
		return new JacksonUtil().getJson(model);
	}
	
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMappingName(value = "打开增加页面")
	@RequestMapping(value = "toAddPage", method = RequestMethod.GET)
	public String toAddPage() {
		return "exam/collect/collectAdd";
	}
	
	/**
	 * 执行保存操作
	 * @param collect
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "保存")
	@RequestMapping(value = "save", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public String save(@Valid Collect collect, RedirectAttributes redirectAttributes) {
		collectService.save(collect);
		return "exam/collect/collectList";
	}
	
	/**
	 * 执行保存操作
	 * @param collect
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "保存")
	@RequestMapping(value = "mobileSave", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String mobileSave(@Valid Collect collect) {
		collectService.save(collect);
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("code", "0");
		result.put("msg", "收藏成功");
		
		return new JacksonUtil().getJson(result);
	}
	
	/**
	 * 跳转到修改页面
	 * @param collectId
	 * @param model
	 * @return
	 */
	@RequestMappingName(value = "打开修改页面")
	@RequestMapping(value = "toUpdatePage/{collectId}", method = RequestMethod.GET)
	public String toUpdatePage(@PathVariable("collectId") String collectId, Model model) {
		model.addAttribute("collect", collectService.findById(collectId));
		return "exam/collect/collectUpdate";
	}
	
	/**
	 * 执行修改操作
	 * @param collect
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "修改")
	@RequestMapping(value = "update", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public String update(@Valid @ModelAttribute("collect") Collect collect, RedirectAttributes redirectAttributes) {
		collectService.update(collect);
		redirectAttributes.addFlashAttribute("message", "更新成功");
		return "exam/collect/collectList";
	}
	
	/**
	 * 跳转详细页面
	 * @param collectId
	 * @param model
	 * @return
	 */
	@RequestMappingName(value = "打开详细页面")
	@RequestMapping(value = "toDetailPage/{collectId}", method = RequestMethod.GET)
	public String toDetailPage(@PathVariable("collectId") String collectId, Model model) {
		model.addAttribute("collect", collectService.findById(collectId));
		return "exam/collect/collectDetail";
	}
	
	/**
	 * 执行删除操作
	 * @param collectId
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "删除")
	@RequestMapping(value = "delete/{collectId}")
	public String delete(@PathVariable("collectId") String collectId, RedirectAttributes redirectAttributes) {
		collectService.delete(collectId);
		redirectAttributes.addFlashAttribute("message", "删除成功");
		return "exam/collect/collectList";
	}
	
	/**
	 * 执行删除操作
	 * @param collect
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "删除")
	@RequestMapping(value = "mobileDelete", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String mobileDelete(@Valid Collect collect) {
		collectService.deleteByUserTopic(collect);
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("code", "0");
		result.put("msg", "取消成功");
		
		return new JacksonUtil().getJson(result);
	}
}
