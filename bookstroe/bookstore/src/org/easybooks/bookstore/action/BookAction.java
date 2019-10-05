package org.easybooks.bookstore.action;
import java.util.*;
import org.easybooks.bookstore.service.*;
import com.opensymphony.xwork2.*;
import org.easybooks.bookstore.util.*;

public class BookAction extends ActionSupport{
	protected ICatalogService catalogService;  //Ϊʹ��ҵ�������õ�����
	protected Integer catalogid;			   //���ͼ������ID
	protected IBookService bookService;
	private Integer currentPage=1;			//��ǰҳ
	private String bookname;			//��������������򲿷�������ѯ
	
	//�������Ŀ¼
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
	
	//��ҳ��ʾͼ��
	public String browseBookPaging() throws Exception{
		int totalSize=bookService.getTotalByCatalog(catalogid);
		Pager pager=new Pager(currentPage,totalSize);
		List books=bookService.getBookByCatalogidPaging(catalogid, currentPage, pager.getPageSize());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("books", books);
		request.put("pager",pager);
		//���ﳵҪ���ؼ�������ʱ,��Ҫ��ס���صĵ�ַ
		Map session=ActionContext.getContext().getSession();
		request.put("catalogid",catalogid);
		return SUCCESS;
	}
	
	//����ͼ��
	public String searchBook() throws Exception {
		StringBuffer hql=new StringBuffer("from Book b ");
		if(bookname!=null&&bookname.length()!=0)
			hql.append("where b.bookname like '%"+bookname+"%'");
		List books = bookService.getRequiredBookbyHql(hql.toString());
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("books",books);
		return SUCCESS;
	}
	//����Ϊ�����Ե�getter/setter����
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
