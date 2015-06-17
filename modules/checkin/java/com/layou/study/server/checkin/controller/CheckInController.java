package com.layou.study.server.checkin.controller;

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

import com.layou.study.server.checkin.domain.*;
import com.layou.study.server.checkin.service.*;
import com.layou.study.server.checkin.util.DateTimeUtil;

import core.mybatis.PageParameter;
import core.spring.RequestMappingName;
import core.utils.jackson.JacksonUtil;

@Controller
@RequestMapping(value = "/checkIn")
public class CheckInController {
	
	@Autowired
	private CheckInService checkInService;
	
	/**
	 * 跳转到管理页面
	 * @return
	 */
	@RequestMappingName(value = "打开管理页面")
	@RequestMapping(value = "toManagerPage",  method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public String toManagerPage() {
		return "checkin/checkIn/checkInList";
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
		
		List<CheckIn> checkIns = checkInService.searchByPage(searchParams);
		
		model.addAttribute("total", pageSize * pageNumber * 10);
		model.addAttribute("rows", checkIns);
		
		return new JacksonUtil().getJson(model);
	}
	
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMappingName(value = "打开增加页面")
	@RequestMapping(value = "toAddPage",  method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public String toAddPage() {
		return "checkin/checkIn/checkInAdd";
	}
	
	/**
	 * 执行保存操作
	 * @param checkIn
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "保存")
	@RequestMapping(value = "save",  method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public String save(@Valid CheckIn checkIn, RedirectAttributes redirectAttributes) {
		checkInService.save(checkIn);
		return "checkin/checkIn/checkInList";
	}
	
	/**
	 * 执行保存操作
	 * @param checkIn
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "移动保存")
	@RequestMapping(value="mobileSave", method = { RequestMethod.GET,RequestMethod.POST },produces = "application/json; charset=utf-8")  
	@ResponseBody
	public String mobileSave(@Valid CheckIn checkIn) {
		String dateTime = DateTimeUtil.getDateTime();
		
		Map<String, String> result = new HashMap<String, String>();
		
		String tempDateTime = dateTime.substring(0, dateTime.indexOf(" ")).replace("-", "");
		if(checkIn.getCheckTime().equals(tempDateTime)){
			checkIn.setCheckTime(dateTime);
			checkInService.save(checkIn);
			
			result.put("code", "0");
			result.put("msg", "签到成功");
		} else {
			result.put("code", "1");
			result.put("msg", "签到日期错误");
		}
		
		return new JacksonUtil().getJson(result);
	}
	
	/**
	 * 跳转到修改页面
	 * @param checkId
	 * @param model
	 * @return
	 */
	@RequestMappingName(value = "打开修改页面")
	@RequestMapping(value = "toUpdatePage/{checkId}",  method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public String toUpdatePage(@PathVariable("checkId") String checkId, Model model) {
		model.addAttribute("checkIn", checkInService.findById(checkId));
		return "checkin/checkIn/checkInUpdate";
	}
	
	/**
	 * 执行修改操作
	 * @param checkIn
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "修改")
	@RequestMapping(value = "update",  method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public String update(@Valid @ModelAttribute("checkIn") CheckIn checkIn, RedirectAttributes redirectAttributes) {
		checkInService.update(checkIn);
		redirectAttributes.addFlashAttribute("message", "更新成功");
		return "checkin/checkIn/checkInList";
	}
	
	/**
	 * 跳转详细页面
	 * @param checkId
	 * @param model
	 * @return
	 */
	@RequestMappingName(value = "打开详细页面")
	@RequestMapping(value = "toDetailPage/{checkId}",  method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public String toDetailPage(@PathVariable("checkId") String checkId, Model model) {
		model.addAttribute("checkIn", checkInService.findById(checkId));
		return "checkin/checkIn/checkInDetail";
	}
	
	/**
	 * 执行删除操作
	 * @param checkId
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMappingName(value = "删除")
	@RequestMapping(value = "delete/{checkId}")
	public String delete(@PathVariable("checkId") String checkId, RedirectAttributes redirectAttributes) {
		checkInService.delete(checkId);
		redirectAttributes.addFlashAttribute("message", "删除成功");
		return "checkin/checkIn/checkInList";
	}
}
