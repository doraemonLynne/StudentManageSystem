/** 
 * Project Name:MVCDemo 
 * File Name:ToDeleteUserAction.java 
 * Package Name:com.chf.action 
 * Date:2014年12月17日 上午10:09:55 
 * Copyright (c) 2014, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package com.chf.action;  

import java.util.List;

import com.chf.entity.User;
import com.chf.service.UserService;

/** 
 * ClassName:ToDeleteUserAction <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2014年12月17日 上午10:09:55 <br/> 
 * @author   zhangzhaoyu 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class ToDeleteUserAction extends Action{
	private static final long serialVersionUID = 4878247652427455524L;
	private UserService userService;
	private String userName;
	@Override
	public String execute()
	{
		return "deleteUsers.jsp";
	}

}
 