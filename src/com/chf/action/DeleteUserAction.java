/** 
 * Project Name:MVCDemo 
 * File Name:DeleteUserAction.java 
 * Package Name:com.chf.action 
 * Date:2014年12月17日 上午10:12:02 
 * Copyright (c) 2014, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package com.chf.action;  

import com.chf.entity.User;
import com.chf.service.UserService;

/** 
 * ClassName:DeleteUserAction <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2014年12月17日 上午10:12:02 <br/> 
 * @author   zhangzhaoyu 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class DeleteUserAction extends Action{
	private static final long serialVersionUID = 4878247652427455524L;
	private UserService userService;
	private String userName;
	private String passWord;
	@Override
	public String execute()
	{
		userName=request.getParameter("username");
		userService=new UserService();
		User duser=new User();
		duser.setUserName(userName);
		this.userService.deleteUser(duser);
		return "success.jsp";
	}
}
 