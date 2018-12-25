package cn.edu.zjut.service;

import java.util.List;

import cn.edu.zjut.po.Customer;
import cn.edu.zjut.po.MoneyCard;

public interface IAdminService {
	public boolean login(String account,String password);
	public Customer getCustomerByID(Integer customerID);
	public List<MoneyCard> produceMoneyCard(Double money,Integer num);
	public Customer FindCustomerByCustomerID(Integer customerID);
	public MoneyCard getMoneyCardByID(Integer moneyCardID);
	public void deleteCustomer(Customer customer);
	public void updateCustomer(Customer customer);
}
