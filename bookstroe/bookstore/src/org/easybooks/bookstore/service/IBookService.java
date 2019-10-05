package org.easybooks.bookstore.service;
import java.util.List;
import org.easybooks.bookstore.vo.Book;

public interface IBookService {
	//����ͼ������id�õ������������ͼ��
	public List getBookbyCatalogid(Integer catalogid);
	public List getBookByCatalogidPaging(Integer catalogid,int currentPage,int pageSize);
	public int getTotalByCatalog(Integer catalogid);
	public List getRequiredBookbyHql(String hql);
	//����bookid�õ�ͼ����Ϣ
	public Book getBookbyId(Integer bookid);

}
