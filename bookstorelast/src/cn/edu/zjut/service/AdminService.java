package cn.edu.zjut.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zjut.dao.IAdminDAO;
import cn.edu.zjut.dao.ICustomerDAO;
import cn.edu.zjut.dao.IMoneyCardDAO;
import cn.edu.zjut.po.CategorySecond;
import cn.edu.zjut.po.Customer;
import cn.edu.zjut.po.MoneyCard;

public class AdminService implements IAdminService{
	IAdminDAO adminDAO=null;
	IMoneyCardDAO moneyCardDAO=null;
	ICustomerDAO customerDAO=null;
	public ICustomerDAO getCustomerDAO(){
		return this.customerDAO;
	}
	public void setCustomerDAO(ICustomerDAO customerDAO){
		this.customerDAO=customerDAO;
	}
	public void setMoneyCardDAO(IMoneyCardDAO moneyCardDAO){
		this.moneyCardDAO=moneyCardDAO;
	}
	public IMoneyCardDAO getMoneyCardDAO(){
		return this.moneyCardDAO;
	}
	public void setAdminDAO(IAdminDAO adminDAO){
		this.adminDAO=adminDAO;
	}
	public IAdminDAO getAdminDAO(){
		return this.adminDAO;
	}
	@Override
	public boolean login(String account, String password) {
		// TODO Auto-generated method stub
		return adminDAO.login(account, password);
	}
	@Override
	public Customer getCustomerByID(Integer customerID) {
		// TODO Auto-generated method stub
		
		return adminDAO.getCustomerByID(customerID);
	}
	@Override
	public List<MoneyCard> produceMoneyCard(Double money, Integer num) {
		// TODO Auto-generated method stub
		List<MoneyCard> newcards=new ArrayList<MoneyCard>(0);
		//Integer password= 0;
		for(int i=num-1;i>=0;i--){
			MoneyCard moneyCard=new MoneyCard();
			long time = System.currentTimeMillis();
			String t = String.valueOf(time); 
			String password = "0";
				if (t == null || t.length() == 0) {
					throw new IllegalArgumentException("String to encript cannot be null or zero length");
				}
				//StringBuffer hexString = new StringBuffer();
				try {
					MessageDigest md = MessageDigest.getInstance("MD5");
					md.update(t.getBytes());
					password=new BigInteger(1, md.digest()).toString(18);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
			//password=(int)(Math.random()*10000000);//MD5 18Î» ×Ö·û´® 
			//moneyCard.setPassword(password.toString());
			moneyCard.setPassword(password.substring(15));
			moneyCard.setMoney(money);
			moneyCardDAO.addMoneyCard(moneyCard);
			//moneyCard=moneyCardDAO.findMoneyCardByPassword(moneyCard.getPassword());
			System.out.println("aaaa:"+moneyCard.getMoneyCardID()+":"+moneyCard.getPassword());
			if(moneyCard!=null)
			newcards.add(moneyCard);
			}
		return newcards;
		
	}
	public void deleteCustomer(Customer customer) {
		customerDAO.delete(customer);
	}
	@Override
	public Customer FindCustomerByCustomerID(Integer customerID) {
		// TODO Auto-generated method stub
		return customerDAO.findCustomerByID(customerID);
	}
	public MoneyCard getMoneyCardByID(Integer moneyCardID){
		return moneyCardDAO.findMoneyCardByID(moneyCardID);
	}
	public void updateCustomer(Customer customer)
	{
		customerDAO.update(customer);
	}
}
