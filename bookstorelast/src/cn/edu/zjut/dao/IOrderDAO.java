package cn.edu.zjut.dao;

import java.util.List;

import cn.edu.zjut.po.UserOrder;

public interface IOrderDAO {
public List<UserOrder> getOrdersByCustomerID(Integer customerID);
public List<UserOrder> getAllOrders();
public List<UserOrder> getOrdersByOrderState(Integer orderState);
public UserOrder getOrderByID(Integer OrderID);
public void updateOrder(UserOrder order);

}
