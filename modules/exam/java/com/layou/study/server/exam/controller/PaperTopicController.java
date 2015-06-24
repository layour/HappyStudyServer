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
@RequestMapping(value = "/paperTopic")
public class PaperTopicController {
	
	@Autowired
	private PaperTopicService paperTopicService;
	
	/**
	 * 跳转到管理页面
	 * @return
	 */
	@RequestMappingName(value = "打开管理页面")
	@RequestMapping(value = "toManagerPage", method = RequestMethod.GET)
	public String toManagerPage() {
		return "exam/paperTopic/paperTopicList";
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
		
		List<PaperTopic> paperTopics = paperTopicService.searchByPage(searchParams);
		
		model.addAttribute("total", pageSize * pageNumber * 10);
		model.addAttribute("rows", paperTopics);
		
		return new JacksonUtil().getJson(model);
	}
	
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMappingName(value = "打开增加页面")
	@RequestMapping(value = "toAddPage", method = RequestMethod.GET)
	public String toAddPage() {
		return "exam/paperTopic/paperTopicAdd";
	}
	
	/**
	 * 执行保存操作
	 * @param paperTopic
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "保存")
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@Valid PaperTopic paperTopic, RedirectAttributes redirectAttributes) {
		paperTopicService.save(paperTopic);
		return "exam/paperTopic/paperTopicList";
	}
	
	/**
	 * 跳转到修改页面
	 * @param paperTopicId
	 * @param model
	 * @return
	 */
	@RequestMappingName(value = "打开修改页面")
	@RequestMapping(value = "toUpdatePage/{paperTopicId}", method = RequestMethod.GET)
	public String toUpdatePage(@PathVariable("paperTopicId") String paperTopicId, Model model) {
		model.addAttribute("paperTopic", paperTopicService.findById(paperTopicId));
		return "exam/paperTopic/paperTopicUpdate";
	}
	
	/**
	 * 执行修改操作
	 * @param paperTopic
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "修改")
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("paperTopic") PaperTopic paperTopic, RedirectAttributes redirectAttributes) {
		paperTopicService.update(paperTopic);
		redirectAttributes.addFlashAttribute("message", "更新成功");
		return "exam/paperTopic/paperTopicList";
	}
	
	/**
	 * 跳转详细页面
	 * @param paperTopicId
	 * @param model
	 * @return
	 */
	@RequestMappingName(value = "打开详细页面")
	@RequestMapping(value = "toDetailPage/{paperTopicId}", method = RequestMethod.GET)
	public String toDetailPage(@PathVariable("paperTopicId") String paperTopicId, Model model) {
		model.addAttribute("paperTopic", paperTopicService.findById(paperTopicId));
		return "exam/paperTopic/paperTopicDetail";
	}
	
	/**
	 * 执行删除操作
	 * @param paperTopicId
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "删除")
	@RequestMapping(value = "delete/{paperTopicId}")
	public String delete(@PathVariable("paperTopicId") String paperTopicId, RedirectAttributes redirectAttributes) {
		paperTopicService.delete(paperTopicId);
		redirectAttributes.addFlashAttribute("message", "删除成功");
		return "exam/paperTopic/paperTopicList";
	}
}
