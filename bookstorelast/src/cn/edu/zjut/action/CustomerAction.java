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
		this.addActionMessage("��½ʧ�ܣ��û������������");
		return "loginFail";
		
	}
	//ע���û�
	public String register(){
		customerService.register(customer);
		this.addActionMessage("ע��ɹ������¼��");
		return "regSuccess";
	}
	//�����û�
	public String update(){
		customerService.update(customer);
		return "regSuccess";
	}
	//�˳���½
	public String logout(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		session.remove("loginUser");
		return "success";
	}
	//����ջ���ַ
	public String addAddress(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		customer=(Customer) session.get("loginUser");
		address.setCustomerID(customer.getCustomerID());
		customer.getAddress().add(address);
		customerService.update(customer);
		session.put("loginUser", customer);
		this.addActionMessage("��ӳɹ���");
		return "success";
	}
	//ɾ���ջ���ַ
	public String deleteAddress(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		customer=(Customer) session.get("loginUser");
		for(Address ads:customer.getAddress()){
			if(ads.getAddressID().equals(address.getAddressID())){
				customer.getAddress().remove(ads);
				customerService.update(customer);
				customer=customerService.getUpdatedCustomer(customer);
				session.put("loginUser", customer);
				this.addActionMessage("ɾ���ɹ��������");
				return "success";
			}
		}
		return "fail";
	}
	//�����ջ���ַ
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
				this.addActionMessage("���³ɹ��������");
				return "success";
			}
		}
		return "fail";
	}
	//��ֵ
	public String recharge(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		customer=(Customer) session.get("loginUser");
		
		String result=customerService.recharge(moneyCard,customer );
		if(result.equals("notfind")){
			this.addActionError("��ֵʧ�ܣ����Ż��ܴ���������");
			return "fail";
		}
		else if(result.equals("used"))
		{
			this.addActionError("��ֵʧ�ܣ��ó�ֵ���ѱ�ʹ�ã������ԣ�");
			return "fail";
		}
		else{
			
			this.addActionMessage("��ֵ�ɹ������˶��˻����");
			customer=customerService.getUpdatedCustomer(customer);
			session.put("loginUser", customer);
			moneyCard.setMoney(Double.parseDouble(result));
			return "success";
		}
	}
	//ɾ������
	public String delOrder(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		customer=(Customer) session.get("loginUser");
		for(UserOrder odr:customer.getOrders()){
			if(odr.getOrderID()==order.getOrderID()){
				if(odr.getOrderState()==3){
					this.addActionMessage("�����еĶ����޷�ɾ����");
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
