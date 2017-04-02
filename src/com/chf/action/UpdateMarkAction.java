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

import javax.servlet.http.HttpSession;

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
public class UpdateMarkAction extends Action {
	private static final long serialVersionUID = 4878247652427455524L;
	private UserService userService;
	private String userName;
	@Override
	public String execute()
	{
        HttpSession session = request.getSession();
        userName= (String) session.getAttribute("UserName");
		userService=new UserService();
		User uuser=new User();
		uuser=this.userService.findUserByUserName(userName);
        if(uuser.getRole()==2||uuser.getRole()==1){
            return "updateMark.jsp";
        }
        return "noPriviledge.jsp";
	}
}
 