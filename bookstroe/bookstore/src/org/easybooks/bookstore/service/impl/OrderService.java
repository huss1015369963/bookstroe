package org.easybooks.bookstore.service.impl;

import org.easybooks.bookstore.dao.IOrderDAO;
import org.easybooks.bookstore.service.IOrderService;
import org.easybooks.bookstore.vo.Orders;

public class OrderService implements IOrderService {
    private IOrderDAO orderDAO;//����orderDAO
	
	//���湺����Ϣ
	public Orders saveOrder(Orders order) {
		return orderDAO.saveOrder(order);
	}
	//����orderDAO��setter����
	public void setOrderDAO(IOrderDAO orderDAO){
		this.orderDAO=orderDAO;
	}

}
