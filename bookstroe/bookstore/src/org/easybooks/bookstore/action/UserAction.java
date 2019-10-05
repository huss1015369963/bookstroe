package org.easybooks.bookstore.action;
import java.util.Map;

import org.easybooks.bookstore.service.IUserService;
import org.easybooks.bookstore.service.impl.UserService;
import org.easybooks.bookstore.vo.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	//属性user，用于接收从界面输入的用户信息
	protected User user;
	//属性userService，用于帮助action完成相关的操作
	protected IUserService userService;
	//用户注册，调用Service层的saveUser()方法
	public String register() throws Exception {
		User user1 = new User();
		user1.setUsername(user.getUsername());
		user1.setPassword(user.getPassword());
		user1.setAge(user.getAge());
		user1.setSex(user.getSex());
		userService.saveUser(user1);
		return SUCCESS;
	}
	//用户登录，调用Service层的validateUser()方法
	public String execute() throws Exception {
		User u = userService.validateUser(user.getUsername(), user.getPassword());
		if (u != null) {
			Map session = ActionContext.getContext().getSession();
			//保存此次会话的u(用户账号)信息
			session.put("user", u);
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	//用户注销，去除会话中的用户账号信息即可，无须调用Service层
	public String logout() throws Exception{
		Map session=ActionContext.getContext().getSession();
		session.remove("user");
		session.remove("cart");
		return SUCCESS;
	}
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public IUserService getUserService(){
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
