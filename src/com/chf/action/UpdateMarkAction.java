package com.chf.action;

import com.chf.entity.Mark;
import com.chf.entity.User;
import com.chf.service.MarkService;
import com.chf.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UpdateMarkAction extends Action {
	private static final long serialVersionUID = 4878247652427455524L;
	private UserService userService;
    private MarkService markService;
	private String userName;
	@Override
	public String execute()
	{
        HttpSession session = request.getSession();
        userName= (String) session.getAttribute("UserName");
        userService=new UserService();
        markService=new MarkService();
        User user=new User();
        user=this.userService.findUserByUserName(userName);
        List<Mark> marks=markService.findMark();
        request.setAttribute("marks",marks);

        if(user.getRole()==2||user.getRole()==1){
            return "updateMark.jsp";
        }
        return "noPriviledge.jsp";
	}
}
 