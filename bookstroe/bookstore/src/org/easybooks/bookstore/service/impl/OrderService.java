package org.easybooks.bookstore.service.impl;

import org.easybooks.bookstore.dao.IOrderDAO;
import org.easybooks.bookstore.service.IOrderService;
import org.easybooks.bookstore.vo.Orders;

public class OrderService implements IOrderService {
    private IOrderDAO orderDAO;//属性orderDAO
	
	//保存购物信息
	public Orders saveOrder(Orders order) {
		return orderDAO.saveOrder(order);
	}
	//属性orderDAO的setter方法
	public void setOrderDAO(IOrderDAO orderDAO){
		this.orderDAO=orderDAO;
	}

}
