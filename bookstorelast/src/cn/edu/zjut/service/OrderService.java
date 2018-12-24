package cn.edu.zjut.service;

import java.util.List;

import cn.edu.zjut.dao.IOrderDAO;
import cn.edu.zjut.po.UserOrder;

public class OrderService implements IOrderService{
	IOrderDAO orderDAO=null;
	public void setOrderDAO(IOrderDAO orderDAO){
		this.orderDAO=orderDAO;
	}
	public IOrderDAO getOrderDAO(){
		return this.orderDAO;
	}
	@Override
	public List<UserOrder> getOrderByCustomerID(Integer customerID) {
		// TODO Auto-generated method stub
		return orderDAO.getOrdersByCustomerID(customerID);
	}

	@Override
	public List<UserOrder> getAllOrders() {
		// TODO Auto-generated method stub
		return orderDAO.getAllOrders();
	}

	@Override
	public UserOrder getOrderByID(Integer OrderID) {
		// TODO Auto-generated method stub
		return orderDAO.getOrderByID(OrderID);
	}

	@Override
	public void updateOrder(UserOrder order) {
		// TODO Auto-generated method stub
		orderDAO.updateOrder(order);
	}
	@Override
	public List<UserOrder> getOrdersByOrderState(Integer orderState) {
		// TODO Auto-generated method stub
		return orderDAO.getOrdersByOrderState(orderState);
	}

}
