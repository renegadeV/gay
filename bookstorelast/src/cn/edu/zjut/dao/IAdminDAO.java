package cn.edu.zjut.dao;

import cn.edu.zjut.po.Customer;
import cn.edu.zjut.po.MoneyCard;

public interface IAdminDAO {
	public boolean login(String account,String password);
	public Customer getCustomerByID(Integer customerID);
}
