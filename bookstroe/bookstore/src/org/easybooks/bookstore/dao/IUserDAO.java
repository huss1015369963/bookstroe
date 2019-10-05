package org.easybooks.bookstore.dao;
import org.easybooks.bookstore.vo.User;
public interface IUserDAO {
	//�û�ע��ʱ������ע����Ϣ
	public void saveUser(User user);
	//�û���¼ʱ����֤�û���Ϣ
	public User validateUser(String username, String password);
	public boolean existUser(String username);
}
