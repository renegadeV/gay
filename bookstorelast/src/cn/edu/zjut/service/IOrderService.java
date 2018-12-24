package cn.edu.zjut.service;

import java.util.List;

import cn.edu.zjut.po.UserOrder;

public interface IOrderService {
public List<UserOrder> getOrderByCustomerID(Integer customerID);
public List<UserOrder> getAllOrders();
public List<UserOrder> getOrdersByOrderState(Integer orderState);
public UserOrder getOrderByID(Integer OrderID);
public void updateOrder(UserOrder order);
}
