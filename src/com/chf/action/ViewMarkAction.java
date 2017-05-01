package com.chf.action;

import com.chf.entity.User;
import com.chf.service.UserService;
import com.chf.entity.Mark;
import com.chf.service.MarkService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ViewMarkAction extends Action {
	private static final long serialVersionUID = 4878247652427455524L;
	private UserService userService;
    private MarkService markService;
	private String userName;
    private String[] subject;
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
        subject=request.getParameterValues("subject");

        ShowingGrade showing = new ShowingGrade();
        Grade english = new GradeEng();
        Grade math = new GradeMath();
        Grade physics = new GradePhy();

        if (subject!=null){
            for(int i=0;i<subject.length;i++) {
                switch (subject[i]) {
                    case "english": {
                        showing.add(english);
                        break;
                    }
                    case "math": {
                        showing.add(math);
                        break;
                    }
                    case "physics": {
                        showing.add(physics);
                        break;
                    }
                }
            }
        }
        else{
            showing.add(english);
            showing.add(math);
            showing.add(physics);
        }

        showMark = showing.showGrade(stuName);

        request.setAttribute("grade",showMark);

        if(user.getRole()==2||user.getRole()==1||user.getRole()==0){
            return "viewMark.jsp";
        }
        return "noPriviledge.jsp";
	}
}
 