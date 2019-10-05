package org.easybooks.bookstore.util;

public class Pager {
	private int currentPage; //当前页面
	private int pageSize=3;  //每页的记录数，此处赋了一个初始值，每页显示3条
	private int totalSize;   //总的记录数
	private int totalPage;   //总的页数，由总的记录数除以每页的记录数得到:totalSize/pageSize
	private boolean hasFirst; //是否有第一页
	private boolean hasPrevious; //是否有上一页
	private boolean hasNext;   //是否有下一页
	private boolean hasLast;   //是否有最后一页
	//构造函数，传递当前页、总的记录数
	public Pager(int currentPage,int totalSize){
		this.currentPage=currentPage;
		this.totalSize=totalSize;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	
	public int getTotalPage() {
		//所有的页数可以通过总的记录数除以每页的数目求得
		totalPage=totalSize/pageSize;
		if(totalSize%pageSize!=0)
			totalPage++;
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	//判断当前页面是否为1，若是，则没有“首页”
	public boolean isHasFirst() {
		if(currentPage==1){
			return false;
		}
		return true;
	}
	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}
	//判断是否有上一页
	public boolean isHasPrevious() {
		//如果首页存在，就一定有上一页
		if(isHasFirst())
			return true;
		else
			return false;
	}
	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}
	//判断是否有下一页
	public boolean isHasNext() {
		//如果尾页存在，则一定有下一页
		if(isHasLast())
			return true;
		else
			return false;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	//判断是否有尾页
	public boolean isHasLast() {
		//如果当前页等于总页数，则说明它已经是最后一页了，没有尾页
		if(currentPage == getTotalPage())
			return false;
		else
			return true;
	}
	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}
}

