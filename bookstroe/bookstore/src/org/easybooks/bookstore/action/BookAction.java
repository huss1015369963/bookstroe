package org.easybooks.bookstore.action;
import java.util.*;
import org.easybooks.bookstore.service.*;
import com.opensymphony.xwork2.*;
import org.easybooks.bookstore.util.*;

public class BookAction extends ActionSupport{
	protected ICatalogService catalogService;  //为使用业务层而设置的属性
	protected Integer catalogid;			   //获得图书类别的ID
	protected IBookService bookService;
	private Integer currentPage=1;			//当前页
	private String bookname;			//根据输入的书名或部分书名查询
	
	//浏览分类目录
	public String browseCatalog() throws Exception{
		List catalogs=catalogService.getAllCatalogs();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("catalogs",catalogs);
		return SUCCESS;
	}
	
	public String browseBook() throws Exception {
		List books = bookService.getBookbyCatalogid(catalogid);
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("books",books);
		return SUCCESS;
	}
	
	//分页显示图书
	public String browseBookPaging() throws Exception{
		int totalSize=bookService.getTotalByCatalog(catalogid);
		Pager pager=new Pager(currentPage,totalSize);
		List books=bookService.getBookByCatalogidPaging(catalogid, currentPage, pager.getPageSize());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("books", books);
		request.put("pager",pager);
		//购物车要返回继续购买时,需要记住返回的地址
		Map session=ActionContext.getContext().getSession();
		request.put("catalogid",catalogid);
		return SUCCESS;
	}
	
	//搜索图书
	public String searchBook() throws Exception {
		StringBuffer hql=new StringBuffer("from Book b ");
		if(bookname!=null&&bookname.length()!=0)
			hql.append("where b.bookname like '%"+bookname+"%'");
		List books = bookService.getRequiredBookbyHql(hql.toString());
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("books",books);
		return SUCCESS;
	}
	//以下为各属性的getter/setter方法
	public Integer getCatalogid() {
		return catalogid;
	}
	public void setCatalogid(Integer catalogid) {
		this.catalogid = catalogid;
	}
	public ICatalogService getCatalogService(){
		return catalogService;
	}
	public void setCatalogService(ICatalogService catalogService) {
		this.catalogService = catalogService;
	}
	public IBookService getBookService(){
		return bookService;
	}
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	/*
	
	

	public String newBook() throws Exception{
		List books=bookService.getNewBook();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("books", books);
		return SUCCESS;
	}
	
	
	
	

	
	
	*/
}
