package cn.edu.zjut.dao;

import cn.edu.zjut.po.Address;
import cn.edu.zjut.po.Customer;
import cn.edu.zjut.po.MoneyCard;

public interface ICustomerDAO {
	public void save(Customer customer);
	public void update(Customer customer);
	public Customer login(String account,String password);
	public Customer findCustomerByID(Integer customerID);
//	public String recharge(MoneyCard moneyCard,Customer customer);
	public void delete(Customer customer);
}
