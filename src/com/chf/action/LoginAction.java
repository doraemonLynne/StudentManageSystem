/**
 * Project Name:MVCDemo 
 * File Name:LoginAction.java
 * Package Name:com.chf.action 
 * Date:2014年12月17日 上午10:35:40 
 * Copyright (c) 2014, zhangzhaoyu0524@163.com All Rights Reserved. 
 *
 */

package com.chf.action;

import java.util.ArrayList;
import java.util.List;

import com.chf.entity.Mark;
import com.chf.entity.User;
import com.chf.service.MarkService;
import com.chf.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * ClassName:LoginAction <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:   TODO ADD REASON. <br/>
 * Date:     2014年12月17日 上午10:35:40 <br/>
 * @author   zhangzhaoyu
 * @version
 * @since    JDK 1.7
 * @see
 */
public class LoginAction extends Action {
    private static final long serialVersionUID = 4878247652427455524L;
    private UserService userService;
    private MarkService markService;
    private String userName;
    private String passWord;
    @Override
    public String execute()
    {
        HttpSession session = request.getSession();
        userName=request.getParameter("username");
        passWord=request.getParameter("password");
        userService=new UserService();
        markService=new MarkService();
        User uuser=new User();
        List<Mark> marks=markService.findMark();
        request.setAttribute("marks",marks);
        User luser=new User();
        luser=this.userService.findUserByUserName(userName);

        GreetFactory greetFactory = new GreetFactory();
        Greet greet = greetFactory.getShow(luser.getRole());

        session.setAttribute("UserName",luser.getUserName());
        session.setAttribute("Role",luser.getRole());
        session.setAttribute("RoleName",greet.show());

        if(luser!=null){
            if((luser.getPassword()).equals(passWord)){
                return "viewMark.jsp";
            }
        }
        return "fail.jsp";
    }
}
 