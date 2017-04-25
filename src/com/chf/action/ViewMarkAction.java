/** 
 * Project Name:MVCDemo 
 * File Name:UpdateUserAction.java 
 * Package Name:com.chf.action 
 * Date:2014年12月17日 上午10:35:40 
 * Copyright (c) 2014, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package com.chf.action;  

import com.chf.entity.User;
import com.chf.service.UserService;
import com.chf.entity.Mark;
import com.chf.service.MarkService;

import javax.servlet.http.HttpSession;
import java.util.List;

/** 
 * ClassName:ViewMarkAction <br/>
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年04月24日 上午10:35:40 <br/>
 * @author   Shi Linyong
 * @version   
 * @since    JDK 1.8
 * @see       
 */
public class ViewMarkAction extends Action {
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

        if(user.getRole()==2||user.getRole()==1||user.getRole()==0){
            return "viewMark.jsp";
        }
        return "noPriviledge.jsp";
	}
}
 