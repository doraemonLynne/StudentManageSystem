package com.chf.service;

import com.chf.dao.UserDao;
import com.chf.entity.User;

import com.chf.dao.MarkDao;
import com.chf.entity.Mark;
import com.sun.javafx.binding.StringFormatter;

import java.util.ArrayList;
import java.util.List;

public class MarkService {
	private UserDao userDao = new UserDao();
    private MarkDao markDao = new MarkDao();

	/**
	 * ����û�������û�
	 * @param 
	 * userName���û���
	 * @return 
	 * ���ҵ����û��б�
	 */
	public List<User> findUser(String userName)
	{
		List<User> list= userDao.findByName(userName);
		
		return list;
	}
    public List<Mark> findMark()
    {
        List<Mark> list= markDao.findMarkAll();

        return list;
    }

	public String findMarkNameByUserName(String userName, String showMark){
        String grade;
        grade=markDao.findMarkByUserName(userName,showMark);
		return grade;
	}
}
