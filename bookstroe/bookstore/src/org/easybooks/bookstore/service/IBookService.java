package org.easybooks.bookstore.service;
import java.util.List;
import org.easybooks.bookstore.vo.Book;

public interface IBookService {
	//根据图书种类id得到该种类的所有图书
	public List getBookbyCatalogid(Integer catalogid);
	public List getBookByCatalogidPaging(Integer catalogid,int currentPage,int pageSize);
	public int getTotalByCatalog(Integer catalogid);
	public List getRequiredBookbyHql(String hql);
	//根据bookid得到图书信息
	public Book getBookbyId(Integer bookid);

}
