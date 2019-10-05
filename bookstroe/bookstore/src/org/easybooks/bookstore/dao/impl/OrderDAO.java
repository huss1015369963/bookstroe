package org.easybooks.bookstore.dao.impl;

import org.easybooks.bookstore.dao.BaseDAO;
import org.easybooks.bookstore.dao.IOrderDAO;
import org.easybooks.bookstore.vo.Orders;
import org.hibernate.*;

public class OrderDAO extends BaseDAO implements IOrderDAO {

	//���湺����Ϣ
	public Orders saveOrder(Orders order) {
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.save(order);
		tx.commit();
		session.close();
		return null;
	}

}
