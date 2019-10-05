package org.easybooks.bookstore.dao.impl;
import java.sql.*;
import java.util.List;
import org.easybooks.bookstore.dao.*;
import org.easybooks.bookstore.vo.User;
import org.hibernate.*;
public class UserDAO extends BaseDAO implements IUserDAO{
	//保存用户的注册信息到数据库中
	public void saveUser(User user){
		try{
			Session session=getSession();
			//将user对象保存到数据库中
			Transaction ts=session.beginTransaction();
			session.save(user);
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
    //验证用户信息，如果正确，返回一个User实例，否则返回null
	public User validateUser(String username, String password){
		//查询 Users 表中的记录
		String sql="from User u where u.username=? and u.password=?";
		Session session=getSession();
		Query query=session.createQuery(sql);
		query.setParameter(0, username);
		query.setParameter(1, password);
		List users=query.list();
		if(users.size()!=0){
			User user=(User)users.get(0);	//创建持久化的 JavaBean 对象 user
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
