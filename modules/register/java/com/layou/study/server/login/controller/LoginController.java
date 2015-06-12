
package com.layou.study.server.login.controller;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.layou.study.server.login.domain.LoginInfoBean;
import com.layou.study.server.login.domain.TregUser;

import core.spring.RequestMappingName;


@Controller
public class LoginController {
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * 跳转到登陆页面
	 * @return
	 */
	@RequestMappingName(value = "跳转到登陆页面")
	@RequestMapping(value = "toLogin", method = RequestMethod.GET)
	public String toLogin() {
		return "logins/login";
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	@RequestMappingName(value = "用户登录")
	@RequestMapping(value = "login", method = RequestMethod.GET)
	@ResponseBody
	public LoginInfoBean login(Model model,ServletRequest request,ServletResponse response) {
	
		String loginName = request.getParameter("loginName");//获取用户登录账号
		String loginPwd = request.getParameter("loginPwd");//获取用户登录密码
		
		LoginInfoBean info = new LoginInfoBean();
		TregUser tregUser=new TregUser(loginName,loginPwd);
		if(tregUser == null){//用户验证失败
			info.setCode("1");
			info.setMsg("用户名或密码错误！");
		}else{
//					this.session().setAttribute(LoginUtil.userKey, person);//把用户信息放到session中
			info.setCode("0");
			info.setMsg("登录成功，欢迎您："+tregUser.getUserName()+"！");
		}
		return info;
	}
	
	/**
	 * <p>用户注销</p>
	 */
	@RequestMappingName(value = "用户注销")
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(){
		
		return "redirect:/toLogin";
	}
	
	
}
