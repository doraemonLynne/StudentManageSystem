/** 
 * Project Name:MVCDemo 
 * File Name:AddUserAction.java 
 * Package Name:com.chf.action 
 * Date:2014年12月17日 上午9:25:20 
 * Copyright (c) 2014, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package com.chf.action;  

import java.util.List;

import com.chf.entity.User;
import com.chf.service.UserService;

/** 
 * ClassName:AddUserAction <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2014年12月17日 上午9:25:20 <br/> 
 * @author   zhangzhaoyu 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class AddUserAction extends Action {
	private static final long serialVersionUID = 4878247652427455524L;
	private UserService userService;
	private String userName;
	private String passWord;
	@Override
	public String execute()
	{
		userName=request.getParameter("username");
		passWord=request.getParameter("password");
		userService=new UserService();
		User auser=new User();
		auser.setUserName(userName);
		auser.setPassword(passWord);
		this.userService.addUser(auser);
		return "success.jsp";
	}
}
 