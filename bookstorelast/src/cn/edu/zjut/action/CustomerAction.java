package cn.edu.zjut.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.zjut.po.Address;
import cn.edu.zjut.po.Customer;
import cn.edu.zjut.po.MoneyCard;
import cn.edu.zjut.po.OrderItem;
import cn.edu.zjut.po.UserOrder;
import cn.edu.zjut.service.IAddressService;
import cn.edu.zjut.service.ICustomerService;

public class CustomerAction extends ActionSupport{
	private String account;
	private String password;
	private Customer customer;
	private Address address;
	private MoneyCard moneyCard;
	private UserOrder order;
	private ICustomerService customerService=null;
//	private IAddressService addressService=null;
	public void setOrder(UserOrder order){
		this.order=order;
	}
	public UserOrder getOrder(){
		return this.order;
	}
	/*public void setAddressService(IAddressService addressService){
		this.addressService=addressService;
	}
	public IAddressService getAddressService(){
		return this.addressService;
	}*/
	public void setMoneyCard(MoneyCard moneyCard){
		this.moneyCard=moneyCard;
	}
	public MoneyCard getMoneyCard(){
		return this.moneyCard;
	}
	
	public Address getAddress(){
		return this.address;
	}
	public void setAddress(Address address){
		this.address=address;
	}
	public void setCustomer(Customer customer){
		this.customer=customer;
	}
	public Customer getCustomer(){
		return this.customer;
	}	
	public ICustomerService getCustomerService(){
		return this.customerService;
	}
	public void setCustomerService(ICustomerService customerService){
		this.customerService=customerService;
	}
	public void setAccount(String account){
		this.account=account;
	}
	public String getAccount(){
		return this.account;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return this.password;
	}
	
	public String login(){
		customer=customerService.login(account, password);
		if(customer!=null){
			Map<String,Object> session=ActionContext.getContext().getSession();
			session.put("loginUser", customer);
			return "loginSuccess";
		}
		this.addActionMessage("登陆失败！用户名或密码错误！");
		return "loginFail";
		
	}
	//注册用户
	public String register(){
		customerService.register(customer);
		this.addActionMessage("注册成功！请登录！");
		return "regSuccess";
	}
	//更新用户
	public String update(){
		customerService.update(customer);
		return "regSuccess";
	}
	//退出登陆
	public String logout(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		session.remove("loginUser");
		return "success";
	}
	//添加收货地址
	public String addAddress(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		customer=(Customer) session.get("loginUser");
		address.setCustomerID(customer.getCustomerID());
		customer.getAddress().add(address);
		customerService.update(customer);
		session.put("loginUser", customer);
		this.addActionMessage("添加成功！");
		return "success";
	}
	//删除收货地址
	public String deleteAddress(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		customer=(Customer) session.get("loginUser");
		for(Address ads:customer.getAddress()){
			if(ads.getAddressID().equals(address.getAddressID())){
				customer.getAddress().remove(ads);
				customerService.update(customer);
				customer=customerService.getUpdatedCustomer(customer);
				session.put("loginUser", customer);
				this.addActionMessage("删除成功！请继续");
				return "success";
			}
		}
		return "fail";
	}
	//更新收货地址
	public String updateAddress(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		customer=(Customer) session.get("loginUser");
		for(Address ads:customer.getAddress()){
			if(ads.getAddressID().equals(address.getAddressID())){
				customer.getAddress().remove(ads);
				address.setCustomerID(customer.getCustomerID());
				customer.getAddress().add(address);
				customerService.update(customer);
				session.put("loginUser", customer);
				this.addActionMessage("更新成功！请继续");
				return "success";
			}
		}
		return "fail";
	}
	//充值
	public String recharge(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		customer=(Customer) session.get("loginUser");
		
		String result=customerService.recharge(moneyCard,customer );
		if(result.equals("notfind")){
			this.addActionError("充值失败！卡号或卡密错误！请重试");
			return "fail";
		}
		else if(result.equals("used"))
		{
			this.addActionError("充值失败！该充值卡已被使用！请重试！");
			return "fail";
		}
		else{
			
			this.addActionMessage("充值成功！清查核对账户余额");
			customer=customerService.getUpdatedCustomer(customer);
			session.put("loginUser", customer);
			moneyCard.setMoney(Double.parseDouble(result));
			return "success";
		}
	}
	//删除订单
	public String delOrder(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		customer=(Customer) session.get("loginUser");
		for(UserOrder odr:customer.getOrders()){
			if(odr.getOrderID()==order.getOrderID()){
				if(odr.getOrderState()==3){
					this.addActionMessage("交易中的订单无法删除！");
					return "fail";
				}
				customer.getOrders().remove(odr);
				customerService.update(customer);
				customer=customerService.getUpdatedCustomer(customer);
				return "success";
			}
		}
		return "fail";
	}


}
