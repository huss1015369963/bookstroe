package org.easybooks.bookstore.dao;
import java.util.List;
import org.easybooks.bookstore.vo.Book;

public interface IBookDAO {
    //ͨ��ͼ�����id�ŵõ���Ӧ����ͼ��
	public List getBookbyCatalogid(Integer catalogid);
	//��ҳ��ʾͼ��
	public List getBookByCatalogidPaging(Integer catalogid,int currentPage,int pageSize);
	//�õ�ĳ����ͼ�����Ŀ
	public int getTotalByCatalog(Integer catalogid);
	//����ͼ��
	public List getRequiredBookbyHql(String hql);
	public Book getBookbyId(Integer bookid);
}
