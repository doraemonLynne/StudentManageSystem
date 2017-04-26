package com.chf.action;

import com.chf.entity.User;
import com.chf.service.UserService;
import com.chf.entity.Mark;
import com.chf.service.MarkService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewMarkAction extends Action {
	private static final long serialVersionUID = 4878247652427455524L;
	private UserService userService;
    private MarkService markService;
	private String userName;
    private String subject;
    private String showMark;
    private String stuName;
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

        stuName=request.getParameter("stuName");
        subject=request.getParameter("subject");

        ShowingGrade showing = new ShowingGrade();

        if("English".equalsIgnoreCase(subject)){
            Grade english = new GradeEng();
            showing.add(english);
        }
        else if("Math".equalsIgnoreCase(subject)){
            Grade math = new GradeMath();
            showing.add(math);
        }
        else{
            Grade phy = new GradePhy();
            showing.add(phy);
        }

        showMark = showing.showGrade();

        String grade;
        grade= this.markService.findMarkNameByUserName(stuName,showMark);

        request.setAttribute("grade",grade);

        if(user.getRole()==2||user.getRole()==1||user.getRole()==0){
            return "viewMark.jsp";
        }
        return "noPriviledge.jsp";
	}
}
 