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
	
	//���ӵ����ﳵ
	public String addToCart() throws Exception{
		//�õ�Ҫ�����ͼ��
		Book book=bookService.getBookbyId(bookid);
		//����һ��������
		Orderitem orderitem=new Orderitem();
		//��Ҫ������鼮���ӵ�������
		orderitem.setBook(book);
		//����Ҫ����ͼ������
		orderitem.setQuantity(quantity);
		Map session=ActionContext.getContext().getSession();
		//��ù��ﳵ����
		Cart cart=(Cart)session.get("cart");
		//���û�оʹ���һ��
		if(cart==null){
			cart=new Cart();
		}
		//��ͼ���ID�Ͷ����������빺�ﳵ
		cart.addBook(bookid, orderitem);
		//�ѹ��ﳵ����Session��
		session.put("cart",cart);
		return SUCCESS;
	}
	//���¹��ﳵ
	public String updateCart() throws Exception{
		Map session=ActionContext.getContext().getSession();
		Cart cart=(Cart)session.get("cart");
		//ֱ�ӵ��ù��ﳵģ���еķ���ʵ���޸�ͼ������
		cart.updateCart(bookid, this.getQuantity());
		session.put("cart", cart);
		return SUCCESS;
	}
	
	//�����¶���
	public String checkout() throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		Cart cart=(Cart)session.get("cart");
		if(user==null || cart ==null)
			return ActionSupport.ERROR;			//���û�е�¼���ص�¼����
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