package com.layou.study.server.login.util;

import javax.servlet.http.HttpSession;

import com.layou.study.server.login.domain.TregUser;

/**
 * 登录工具类
 */
public class LoginUtil {
	public static ThreadLocal<HttpSession> sessions = new ThreadLocal<HttpSession>();//存放session
	public static String userKey = "app_TregUser";//session属性：存入session的用户信息
	
	/**
	 * 设置session到ThreadLocal中
	 * @param session
	 */
	public static void setSession(HttpSession session){
		sessions.set(session);
	}

	/**
	 * 清空ThreadLocal中的session
	 */
	public static void clearSession(){
		sessions.set(null);
	}
	
	/**
	 * 获取当前登陆用户信息
	 * @return
	 */
	public static TregUser getCurrentPerson(){
		HttpSession session = sessions.get();
		if(session == null) return null;
		return (TregUser) session.getAttribute(userKey);
	}
	
	/**
	 * 获取登陆用户的UUID
	 * @return
	 */
	public static String getCurrentUserId(){
		TregUser tregUser = getCurrentPerson();//获取登陆用户信息
		if(tregUser == null) return null;
		return tregUser.getUnid();
	}
	
	/**
	 * 获取登陆用户的账号
	 * @return
	 */
	public static String getCurrentUserAccount(){
		TregUser tregUser = getCurrentPerson();//获取登陆用户信息
		if(tregUser == null) return null;
		return tregUser.getLoginName();
	}
	
	/**
	 * 获取登陆用户的姓名
	 * @return
	 */
	public static String getCurrentUserName(){
		TregUser tregUser = getCurrentPerson();//获取登陆用户信息
		if(tregUser == null) return null;
		if(tregUser.getUserName() != null && !"".equals(tregUser.getUserName()))
			return tregUser.getUserName();
		else
			return tregUser.getLoginName();//如果登陆用户的名称为空返回登录账号
	}

	
	
}
