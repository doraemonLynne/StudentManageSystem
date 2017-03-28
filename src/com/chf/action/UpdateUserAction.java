/** 
 * Project Name:MVCDemo 
 * File Name:UpdateUserAction.java 
 * Package Name:com.chf.action 
 * Date:2014年12月17日 上午10:35:40 
 * Copyright (c) 2014, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package com.chf.action;  

import java.util.ArrayList;
import java.util.List;

import com.chf.entity.User;
import com.chf.service.UserService;

/** 
 * ClassName:UpdateUserAction <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2014年12月17日 上午10:35:40 <br/> 
 * @author   zhangzhaoyu 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class UpdateUserAction extends Action {
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
		User uuser=new User();
		uuser=this.userService.findUserByUserName(userName);
		//uuser.setUserName(userName);
		uuser.setPassword(passWord);
		this.userService.updateUser(uuser);
		return "success.jsp";
	}
}
 