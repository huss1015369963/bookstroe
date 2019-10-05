package org.easybooks.bookstore.action;
import java.util.Map;

import org.easybooks.bookstore.service.IUserService;
import org.easybooks.bookstore.service.impl.UserService;
import org.easybooks.bookstore.vo.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	//����user�����ڽ��մӽ���������û���Ϣ
	protected User user;
	//����userService�����ڰ���action�����صĲ���
	protected IUserService userService;
	//�û�ע�ᣬ����Service���saveUser()����
	public String register() throws Exception {
		User user1 = new User();
		user1.setUsername(user.getUsername());
		user1.setPassword(user.getPassword());
		user1.setAge(user.getAge());
		user1.setSex(user.getSex());
		userService.saveUser(user1);
		return SUCCESS;
	}
	//�û���¼������Service���validateUser()����
	public String execute() throws Exception {
		User u = userService.validateUser(user.getUsername(), user.getPassword());
		if (u != null) {
			Map session = ActionContext.getContext().getSession();
			//����˴λỰ��u(�û��˺�)��Ϣ
			session.put("user", u);
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	//�û�ע����ȥ���Ự�е��û��˺���Ϣ���ɣ��������Service��
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
