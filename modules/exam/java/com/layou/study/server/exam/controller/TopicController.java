package com.layou.study.server.exam.controller;

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
@RequestMapping(value = "/topic")
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	/**
	 * 跳转到管理页面
	 * @return
	 */
	@RequestMappingName(value = "打开管理页面")
	@RequestMapping(value = "toManagerPage", method = RequestMethod.GET)
	public String toManagerPage() {
		return "exam/topic/topicList";
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
		
		List<Topic> topics = topicService.searchByPage(searchParams);
		
		model.addAttribute("total", topics.size());
		model.addAttribute("rows", topics);
		
		return new JacksonUtil().getJson(model);
	}
	
	/**
	 * 按User查询
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMappingName(value = "查询列表")
	@RequestMapping(value = "findTopicByUser", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public @ResponseBody String findTopicByUser(Model model, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		
		List<Topic> topics = topicService.findTopicByUser(searchParams);
		
		model.addAttribute("total", topics.size());
		model.addAttribute("rows", topics);
		
		return new JacksonUtil().getJson(model);
	}
	
	/**
	 * 按User查询
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMappingName(value = "查询列表")
	@RequestMapping(value = "findCollectByUser", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public @ResponseBody String findCollectByUser(Model model, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		
		List<Topic> topics = topicService.findCollectByUser(searchParams);
		
		model.addAttribute("total", topics.size());
		model.addAttribute("rows", topics);
		
		return new JacksonUtil().getJson(model);
	}
	
	/**
	 * 按UserChapter查询
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMappingName(value = "查询列表")
	@RequestMapping(value = "findTopicByUserChapter", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public @ResponseBody String findTopicByUserChapter(Model model, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		
		List<Topic> topics = topicService.findTopicByUserChapter(searchParams);
		
		model.addAttribute("total", topics.size());
		model.addAttribute("rows", topics);
		
		return new JacksonUtil().getJson(model);
	}
	
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMappingName(value = "打开增加页面")
	@RequestMapping(value = "toAddPage", method = RequestMethod.GET)
	public String toAddPage() {
		return "exam/topic/topicAdd";
	}
	
	/**
	 * 执行保存操作
	 * @param topic
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "保存")
	@RequestMapping(value = "save", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public String save(@Valid Topic topic, RedirectAttributes redirectAttributes) {
		topicService.save(topic);
		return "exam/topic/topicList";
	}
	
	/**
	 * 跳转到修改页面
	 * @param topicId
	 * @param model
	 * @return
	 */
	@RequestMappingName(value = "打开修改页面")
	@RequestMapping(value = "toUpdatePage/{topicId}", method = RequestMethod.GET)
	public String toUpdatePage(@PathVariable("topicId") String topicId, Model model) {
		model.addAttribute("topic", topicService.findById(topicId));
		return "exam/topic/topicUpdate";
	}
	
	/**
	 * 执行修改操作
	 * @param topic
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "修改")
	@RequestMapping(value = "update", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public String update(@Valid @ModelAttribute("topic") Topic topic, RedirectAttributes redirectAttributes) {
		topicService.update(topic);
		redirectAttributes.addFlashAttribute("message", "更新成功");
		return "exam/topic/topicList";
	}
	
	/**
	 * 跳转详细页面
	 * @param topicId
	 * @param model
	 * @return
	 */
	@RequestMappingName(value = "打开详细页面")
	@RequestMapping(value = "toDetailPage/{topicId}", method = RequestMethod.GET)
	public String toDetailPage(@PathVariable("topicId") String topicId, Model model) {
		model.addAttribute("topic", topicService.findById(topicId));
		return "exam/topic/topicDetail";
	}
	
	/**
	 * 执行删除操作
	 * @param topicId
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "删除")
	@RequestMapping(value = "delete/{topicId}")
	public String delete(@PathVariable("topicId") String topicId, RedirectAttributes redirectAttributes) {
		topicService.delete(topicId);
		redirectAttributes.addFlashAttribute("message", "删除成功");
		return "exam/topic/topicList";
	}
}
