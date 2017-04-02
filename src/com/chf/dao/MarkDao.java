package com.chf.dao;

import com.chf.dao.dbhelp.DBUtil;
import com.chf.entity.User;
import com.chf.entity.Mark;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarkDao {
	/**
	 * �����û�
	 * @param user������µ��û�
	 * @return ��������
	 */
	public int update(User user) {
		StringBuffer sql = new StringBuffer();
		int i = 0;
		try {
			sql.append("UPDATE user SET password='" + user.getPassword() + "' ");
			sql.append("WHERE username='" + user.getUserName() + "';");

			i = DBUtil.executeUpdateInsertDelete(sql.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return i;
	}

	/**
	 * ɾ���û�
	 * @param user����ɾ����û�
	 * @return ��������
	 */
	public int delete(User user) {
		StringBuffer sql = new StringBuffer();

		sql.append("delete from user where username='" + user.getUserName() + "';");

		return DBUtil.executeUpdateInsertDelete(sql.toString());
	}

	/**
	 * �����û�
	 * @param user������ӵ��̻�
	 * @return ��������
	 */
	public int insert(User user) {
		StringBuffer sql = new StringBuffer();

		sql.append("insert into user(username,password)");
		sql.append("values('" + user.getUserName() + "',");
		sql.append("'" + user.getPassword() + "');");

		return DBUtil.executeUpdateInsertDelete(sql.toString());
	}

	/**
	 * ���id�����û�
	 * @param id������ҵ��û�id
	 * @return ����������û�
	 */
	public User findById(int id) {
		User user = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from user where id=" + id + ";");

		try {
			ResultSet set = DBUtil.executeQuery(sql.toString());
			
			while (set.next()) {
				
				user = new User();
				user.setId(set.getInt("id"));
				user.setUserName(set.getString("username"));
				user.setPassword(set.getString("password"));
                user.setRole(set.getInt("role"));

				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return user;
	}
	
	public User findByUserName(String userName) {
		User user = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from user where username='" + userName + "';");

		try {
			ResultSet set = DBUtil.executeQuery(sql.toString());
			
			while (set.next()) {
				
				user = new User();
				user.setId(set.getInt("id"));
				user.setUserName(set.getString("username"));
				user.setPassword(set.getString("password"));
                user.setRole(set.getInt("role"));

				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return user;
	}
	
	/**
	 * ����û������
	 * @param userName������ҵ��û���
	 * @return ����������û��б�
	 */
	public List<User> findByName(String userName){
		List<User> list = new ArrayList<User>();
		
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT * FROM user WHERE username = '");
		sql.append(userName);
		sql.append("';");
		
		try{
			ResultSet set=DBUtil.executeQuery(sql.toString());
			while(set.next()){
				User user=new User();
				user.setId(set.getInt("id"));
				user.setUserName(set.getString("username"));
				user.setPassword(set.getString("password"));
                user.setRole(set.getInt("role"));

				list.add(user);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return list;
	}

    public List<Mark> findMarkAll(){
        List<Mark> list = new ArrayList<Mark>();

        StringBuffer sql=new StringBuffer();
        sql.append("SELECT * FROM mark;");

        try{
            ResultSet set=DBUtil.executeQuery(sql.toString());
            while(set.next()){
                Mark mark=new Mark();
                mark.setId(set.getInt("id"));
                mark.setStuId(set.getInt("stuId"));
                mark.setStuName(set.getString("stuName"));
                mark.setMarkEng(set.getInt("English"));
                mark.setMarkMath(set.getInt("Math"));
                mark.setMarkPhy(set.getInt("Physics"));

                list.add(mark);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
	
}
