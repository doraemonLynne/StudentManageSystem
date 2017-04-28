package com.chf.action;

import com.chf.entity.Mark;
import com.chf.entity.User;
import com.chf.service.UserService;
import com.chf.service.MarkService;

import javax.servlet.http.HttpSession;
import java.util.List;

import static java.lang.Integer.parseInt;

public class AddMarkAction extends Action {
	private static final long serialVersionUID = 4878247652427455524L;
    private UserService userService;
	private MarkService markService;
    private String userName;
    private String stuId;
	private String stuName;
	private String english;
    private String math;
    private String physics;
	@Override
	public String execute()
	{
        HttpSession session = request.getSession();
        userName= (String) session.getAttribute("UserName");
        userService=new UserService();
        markService=new MarkService();

        stuId=request.getParameter("studentId");
        stuName=request.getParameter("studentName");
        english=request.getParameter("english");
        math=request.getParameter("math");
        physics=request.getParameter("physics");

		Mark amark=new Mark();
        amark.setStuId(parseInt(stuId));
        amark.setStuName(stuName);
        amark.setMarkEng(parseInt(english));
        amark.setMarkMath(parseInt(math));
        amark.setMarkPhy(parseInt(physics));
		this.markService.addMark(amark);
        List<Mark> marks=markService.findMark();
        request.setAttribute("marks",marks);
        return "updateMark.jsp";
	}

}
 