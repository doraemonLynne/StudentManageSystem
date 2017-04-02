package com.chf.service;

import com.chf.dao.UserDao;
import com.chf.entity.User;

import com.chf.dao.MarkDao;
import com.chf.entity.Mark;

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
	public void addUser(User auser){
		this.userDao.insert(auser);
	}
	public void deleteUser(User duser){
		this.userDao.delete(duser);
	}
	public User findUserByUserName(String userName){
		User user=userDao.findByUserName(userName);
		return user;
	}
	public void updateUser(User uuser){
		this.userDao.update(uuser);
	}
}
