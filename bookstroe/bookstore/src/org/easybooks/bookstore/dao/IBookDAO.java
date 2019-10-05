package org.easybooks.bookstore.dao;
import java.util.List;
import org.easybooks.bookstore.vo.Book;

public interface IBookDAO {
    //通过图书类别id号得到相应类别的图书
	public List getBookbyCatalogid(Integer catalogid);
	//分页显示图书
	public List getBookByCatalogidPaging(Integer catalogid,int currentPage,int pageSize);
	//得到某类型图书的数目
	public int getTotalByCatalog(Integer catalogid);
	//搜索图书
	public List getRequiredBookbyHql(String hql);
	public Book getBookbyId(Integer bookid);
}
