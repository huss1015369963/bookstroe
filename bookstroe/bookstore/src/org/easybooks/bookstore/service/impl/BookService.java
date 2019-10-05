package org.easybooks.bookstore.service.impl;
import java.util.List;
import org.easybooks.bookstore.dao.IBookDAO;
import org.easybooks.bookstore.service.IBookService;
import org.easybooks.bookstore.vo.Book;

public class BookService implements IBookService{
	private IBookDAO bookDAO;    //为了使用DAO组件而设置的属性
	//根据图书种类id得到该种类的所有图书
	public List getBookbyCatalogid(Integer catalogid){
		return bookDAO.getBookbyCatalogid(catalogid);
	}
	//根据图书种类id得到分页图书
	public List getBookByCatalogidPaging(Integer catalogid,int currentPage,int pageSize){
		return bookDAO.getBookByCatalogidPaging(catalogid, currentPage, pageSize);
	}
	//根据图书种类得到该类图书的数目
	public int getTotalByCatalog(Integer catalogid){
		return bookDAO.getTotalByCatalog(catalogid);
	}
	//搜索图书
	public List getRequiredBookbyHql(String hql){
		return bookDAO.getRequiredBookbyHql(hql);
	}
	public Book getBookbyId(Integer bookid){
		return bookDAO.getBookbyId(bookid);
	}
	
	//属性bookDAO的getter/setter方法
	public IBookDAO getBookDAO(){
		return bookDAO;
	}
	public void setBookDAO(IBookDAO bookDAO){
		this.bookDAO=bookDAO;
	}

}
