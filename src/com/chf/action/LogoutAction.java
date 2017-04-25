package com.chf.action;

import com.chf.entity.User;
import com.chf.service.UserService;

import javax.servlet.http.HttpSession;

public class LogoutAction extends Action {
    private static final long serialVersionUID = 4878247652427455524L;
    private UserService userService;
    private String userName;
    private String passWord;
    @Override
    public String execute()
    {
        HttpSession session = request.getSession();
        session.removeAttribute("UserName");
        session.invalidate();
        return "logout.jsp";
    }
}
 