package cn.edu.zjut.po;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private Integer customerID;
	private String account;
	private String password;
	private String name;
	private String sex;
	private String phone;
	private String email;
	private Double money=0.0;
	private Double usedMoney=0.0;
	private Double inMoney=0.0;
	private Set<Address> address=new HashSet<Address>();
	private Set<UserOrder> orders=new HashSet<UserOrder>();
	private Role role;
	//private Set saddress=new HashSet();
	
	public void setUsedMoney(Double usedMoney){
		this.usedMoney=usedMoney;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Double getUsedMoney(){
		return this.usedMoney;
	}
	public void setInMoney(Double inMoney){
		this.inMoney=inMoney;
	}
	public Double getInMoney(){
		return this.inMoney;
	}
	public void setOrders(Set<UserOrder> orders){
		this.orders=orders;
	}
	public Set<UserOrder> getOrders(){
		return this.orders;
	}
	public void setAddress(Set<Address> address){
		this.address=address;
	}
	public Set<Address> getAddress(){
		return this.address;
	}
	public void setCustomerID(Integer customerID){
		this.customerID=customerID;
	}
	public Integer getCustomerID(){
		return this.customerID;
	}
	public void setMoney(Double money){
		this.money=money;
	}
	public Double getMoney(){
		return this.money;
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
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	public void setSex(String sex){
		this.sex=sex;
	}
	public String getSex(){
		return this.sex;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return this.phone;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return this.email;
	}
	
	
}
