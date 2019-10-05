package org.easybooks.bookstore.dao.impl;
import java.sql.*;
import java.util.List;
import org.easybooks.bookstore.dao.*;
import org.easybooks.bookstore.vo.User;
import org.hibernate.*;
public class UserDAO extends BaseDAO implements IUserDAO{
	//�����û���ע����Ϣ�����ݿ���
	public void saveUser(User user){
		try{
			Session session=getSession();
			//��user���󱣴浽���ݿ���
			Transaction ts=session.beginTransaction();
			session.save(user);
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
    //��֤�û���Ϣ�������ȷ������һ��Userʵ�������򷵻�null
	public User validateUser(String username, String password){
		//��ѯ Users ���еļ�¼
		String sql="from User u where u.username=? and u.password=?";
		Session session=getSession();
		Query query=session.createQuery(sql);
		query.setParameter(0, username);
		query.setParameter(1, password);
		List users=query.list();
		if(users.size()!=0){
			User user=(User)users.get(0);	//�����־û��� JavaBean ���� user
			return user;
		}
		session.close();
		return null;
	}

	public boolean existUser(String username){
		String hql="from Users where username=?";
		Session session=getSession();
		Query query=session.createQuery(hql);
		query.setParameter(0, username);
		List users=query.list();
		if(users.size()>0)
			return true;
		else
			return false;
	}
}
