package org.easybooks.bookstore.service.impl;
import java.util.List;
import org.easybooks.bookstore.dao.IBookDAO;
import org.easybooks.bookstore.service.IBookService;
import org.easybooks.bookstore.vo.Book;

public class BookService implements IBookService{
	private IBookDAO bookDAO;    //Ϊ��ʹ��DAO��������õ�����
	//����ͼ������id�õ������������ͼ��
	public List getBookbyCatalogid(Integer catalogid){
		return bookDAO.getBookbyCatalogid(catalogid);
	}
	//����ͼ������id�õ���ҳͼ��
	public List getBookByCatalogidPaging(Integer catalogid,int currentPage,int pageSize){
		return bookDAO.getBookByCatalogidPaging(catalogid, currentPage, pageSize);
	}
	//����ͼ������õ�����ͼ�����Ŀ
	public int getTotalByCatalog(Integer catalogid){
		return bookDAO.getTotalByCatalog(catalogid);
	}
	//����ͼ��
	public List getRequiredBookbyHql(String hql){
		return bookDAO.getRequiredBookbyHql(hql);
	}
	public Book getBookbyId(Integer bookid){
		return bookDAO.getBookbyId(bookid);
	}
	
	//����bookDAO��getter/setter����
	public IBookDAO getBookDAO(){
		return bookDAO;
	}
	public void setBookDAO(IBookDAO bookDAO){
		this.bookDAO=bookDAO;
	}

}
