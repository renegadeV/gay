package cn.edu.zjut.service;

import cn.edu.zjut.po.Address;
import cn.edu.zjut.po.Customer;
import cn.edu.zjut.po.MoneyCard;

public interface ICustomerService {
	public Customer login(String account,String password);
	public void register(Customer customer);
	public void update(Customer customer);
	public String recharge(MoneyCard moneyCard,Customer customer);
	public Customer getUpdatedCustomer(Customer customer);
}
