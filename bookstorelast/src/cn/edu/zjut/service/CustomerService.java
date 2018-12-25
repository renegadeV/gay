package cn.edu.zjut.service;

import cn.edu.zjut.dao.ICustomerDAO;
import cn.edu.zjut.dao.IMoneyCardDAO;
import cn.edu.zjut.po.Address;
import cn.edu.zjut.po.Customer;
import cn.edu.zjut.po.MoneyCard;

public class CustomerService implements ICustomerService{
	ICustomerDAO dao=null;
	IMoneyCardDAO moneyCardDAO=null;
	public void setMoneyCardDAO(IMoneyCardDAO moneyCardDAO){
		this.moneyCardDAO=moneyCardDAO;
	}
	public IMoneyCardDAO getMoneyCardDAO(){
		return this.moneyCardDAO;
	}
	public ICustomerDAO getDao(){
		return dao;
	}
	public void setDao(ICustomerDAO dao){
		this.dao=dao;
	}
	@Override
	public Customer login(String account,String password) {
		// TODO Auto-generated method stub
		Customer customer=dao.login(account, password);
		return customer;
	}

	@Override
	public void register(Customer customer) {
		// TODO Auto-generated method stub
		dao.save(customer);
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		dao.update(customer);
	}
	@Override
	public String recharge(MoneyCard moneyCard,Customer customer) {
		// TODO Auto-generated method stub
		MoneyCard findedCard=moneyCardDAO.findMoneyCardByIDandPassword(moneyCard.getMoneyCardID(), moneyCard.getPassword());
		if(findedCard==null){
			return "notfind";
		}
		else if(findedCard.getCustomerID()!=0){
			return "used";
		}
		else{
			findedCard.setCustomerID(customer.getCustomerID());
			customer.setMoney(customer.getMoney()+findedCard.getMoney());
			customer.setInMoney(customer.getInMoney()+findedCard.getMoney());
			moneyCardDAO.updateMoneyCard(findedCard);
			dao.update(customer); 
			return findedCard.getMoney().toString();
		}
	}
	@Override
	public Customer getUpdatedCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customer=dao.login(customer.getAccount(), customer.getPassword());
		return customer;
	}

}
