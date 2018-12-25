package cn.edu.zjut.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.edu.zjut.po.UserOrder;

public class OrderDAO extends BaseHibernateDAO implements IOrderDAO{

	@Override
	public List<UserOrder> getOrdersByCustomerID(Integer customerID) {
		// TODO Auto-generated method stub
		Session session=getSession();
		String hql="from UserOrder where CustomerID=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, customerID);
		List<UserOrder> list=query.list();
		session.close();
		return list;
	}

	@Override
	public List<UserOrder> getAllOrders() {
		// TODO Auto-generated method stub
		Session session=getSession();
		String hql="from UserOrder";
		Query query=session.createQuery(hql);
		List<UserOrder> list=query.list();
		session.close();
		return list;
	}



	@Override
	public UserOrder getOrderByID(Integer OrderID) {
		// TODO Auto-generated method stub
		Session session=getSession();
		String hql="from UserOrder where orderID=?";
		Query query=session.createQuery(hql);
		query.setInteger(0,OrderID);
		List<UserOrder> list=query.list();
		session.close();
		for(UserOrder order:list){
			return order;
		}
		return null;
	}

	@Override
	public void updateOrder(UserOrder order) {
		// TODO Auto-generated method stub
		Session session=getSession();
		Transaction trans=session.beginTransaction();
		session.update(order);
		trans.commit();
		session.close();
		
	}

	@Override
	public List<UserOrder> getOrdersByOrderState(Integer orderState) {
		// TODO Auto-generated method stub
		Session session=getSession();
		String hql="from UserOrder where orderState=?";
		Query query=session.createQuery(hql);
		query.setInteger(0,orderState);
		List<UserOrder> list=query.list();
		session.close();
		return list;
	}

}
