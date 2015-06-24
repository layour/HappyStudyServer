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
@RequestMapping(value = "/paper")
public class PaperController {
	
	@Autowired
	private PaperService paperService;
	
	/**
	 * 跳转到管理页面
	 * @return
	 */
	@RequestMappingName(value = "打开管理页面")
	@RequestMapping(value = "toManagerPage", method = RequestMethod.GET)
	public String toManagerPage() {
		return "exam/paper/paperList";
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
		
		List<Paper> papers = paperService.searchByPage(searchParams);
		
		model.addAttribute("total", pageSize * pageNumber * 10);
		model.addAttribute("rows", papers);
		
		return new JacksonUtil().getJson(model);
	}
	
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMappingName(value = "打开增加页面")
	@RequestMapping(value = "toAddPage", method = RequestMethod.GET)
	public String toAddPage() {
		return "exam/paper/paperAdd";
	}
	
	/**
	 * 执行保存操作
	 * @param paper
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "保存")
	@RequestMapping(value = "save", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public String save(@Valid Paper paper, RedirectAttributes redirectAttributes) {
		paperService.save(paper);
		return "exam/paper/paperList";
	}
	
	/**
	 * 跳转到修改页面
	 * @param paperId
	 * @param model
	 * @return
	 */
	@RequestMappingName(value = "打开修改页面")
	@RequestMapping(value = "toUpdatePage/{paperId}", method = RequestMethod.GET)
	public String toUpdatePage(@PathVariable("paperId") String paperId, Model model) {
		model.addAttribute("paper", paperService.findById(paperId));
		return "exam/paper/paperUpdate";
	}
	
	/**
	 * 执行修改操作
	 * @param paper
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "修改")
	@RequestMapping(value = "update", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public String update(@Valid @ModelAttribute("paper") Paper paper, RedirectAttributes redirectAttributes) {
		paperService.update(paper);
		redirectAttributes.addFlashAttribute("message", "更新成功");
		return "exam/paper/paperList";
	}
	
	/**
	 * 跳转详细页面
	 * @param paperId
	 * @param model
	 * @return
	 */
	@RequestMappingName(value = "打开详细页面")
	@RequestMapping(value = "toDetailPage/{paperId}", method = RequestMethod.GET)
	public String toDetailPage(@PathVariable("paperId") String paperId, Model model) {
		model.addAttribute("paper", paperService.findById(paperId));
		return "exam/paper/paperDetail";
	}
	
	/**
	 * 执行删除操作
	 * @param paperId
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "删除")
	@RequestMapping(value = "delete/{paperId}")
	public String delete(@PathVariable("paperId") String paperId, RedirectAttributes redirectAttributes) {
		paperService.delete(paperId);
		redirectAttributes.addFlashAttribute("message", "删除成功");
		return "exam/paper/paperList";
	}
}
