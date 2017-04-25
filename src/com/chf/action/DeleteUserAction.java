package com.chf.action;

import com.chf.entity.User;
import com.chf.service.UserService;

import java.util.List;

public class DeleteUserAction extends Action{
	private static final long serialVersionUID = 4878247652427455524L;
	private UserService userService;
	private String userName;
	private String passWord;
	@Override
	public String execute()
	{
        userName = request.getParameter("userName");
		userService=new UserService();
		User duser=new User();
		duser.setUserName(userName);
		this.userService.deleteUser(duser);
        List<User> users=userService.findUsers();
        request.setAttribute("users",users);
        return "updateUsers.jsp";
	}
}
 