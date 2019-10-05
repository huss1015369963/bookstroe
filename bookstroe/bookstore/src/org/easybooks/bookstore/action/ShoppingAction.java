package org.easybooks.bookstore.action;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import org.easybooks.bookstore.model.Cart;
import org.easybooks.bookstore.service.IBookService;
import org.easybooks.bookstore.service.IOrderService;
import org.easybooks.bookstore.vo.*;

import com.opensymphony.xwork2.*;

public class ShoppingAction extends ActionSupport {
	private int bookid;
	private int quantity;
	private IBookService bookService;
	private IOrderService orderService;
	
	//添加到购物车
	public String addToCart() throws Exception{
		//得到要购买的图书
		Book book=bookService.getBookbyId(bookid);
		//创建一个订单项
		Orderitem orderitem=new Orderitem();
		//把要购买的书籍添加到订单项
		orderitem.setBook(book);
		//设置要购买图书数量
		orderitem.setQuantity(quantity);
		Map session=ActionContext.getContext().getSession();
		//获得购物车对象
		Cart cart=(Cart)session.get("cart");
		//如果没有就创建一个
		if(cart==null){
			cart=new Cart();
		}
		//把图书的ID和订单项添加入购物车
		cart.addBook(bookid, orderitem);
		//把购物车放入Session中
		session.put("cart",cart);
		return SUCCESS;
	}
	//更新购物车
	public String updateCart() throws Exception{
		Map session=ActionContext.getContext().getSession();
		Cart cart=(Cart)session.get("cart");
		//直接调用购物车模型中的方法实现修改图书数量
		cart.updateCart(bookid, this.getQuantity());
		session.put("cart", cart);
		return SUCCESS;
	}
	
	//结账下订单
	public String checkout() throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		Cart cart=(Cart)session.get("cart");
		if(user==null || cart ==null)
			return ActionSupport.ERROR;			//如果没有登录返回登录界面
		Orders order=new Orders();
		order.setOrderdate(new Date());
		order.setUser(user);
		for(Iterator it=cart.getItems().values().iterator();it.hasNext();){
			Orderitem orderitem=(Orderitem)it.next();
			orderitem.setOrders(order);
			order.getOrderitems().add(orderitem);
		}
		orderService.saveOrder(order);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("order",order);
		return SUCCESS;
	}

	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public IBookService getBookService() {
		return bookService;
	}
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
	public IOrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

}
