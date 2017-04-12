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

import static java.lang.Integer.parseInt;

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
    private String userId;
	private String userName;
	private String passWord;
    private String role;
    private String roleId;
	@Override
	public String execute()
	{
        userId=request.getParameter("userId");
		userName=request.getParameter("userName");
		passWord=request.getParameter("password");
        role=request.getParameter("role");
        roleId=request.getParameter("roleId");
		userService=new UserService();
		User uuser=new User();
        uuser.setId(parseInt(userId));
        uuser.setUserName(userName);
        uuser.setPassword(passWord);
        uuser.setRole(parseInt(role));
        uuser.setRoleId(parseInt(roleId));
		this.userService.updateUser(uuser);
        List<User> users=userService.findUsers();
        request.setAttribute("users",users);
        return "updateUsers.jsp";
	}
}
 