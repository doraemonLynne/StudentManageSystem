package com.chf.action;

import com.chf.entity.User;
import com.chf.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class ViewUserAction extends Action {
	private static final long serialVersionUID = 4878247652427455524L;
	private UserService userService;
	private String userName;
	@Override
	public String execute()
	{
        HttpSession session = request.getSession();
		userName= (String) session.getAttribute("UserName");
		userService=new UserService();
		User user=new User();
        user=this.userService.findUserByUserName(userName);
        List<User> users=userService.findUsers();
        request.setAttribute("users",users);

        if(user.getRole()==2){
            return "updateUsers.jsp";
        }
        return "noPriviledge.jsp";
	}
}
 