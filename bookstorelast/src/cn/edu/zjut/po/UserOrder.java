package cn.edu.zjut.po;

import java.util.HashSet;
import java.util.Set;

public class UserOrder {
	private Integer orderID;
	private Customer customer;
	private String name;
	private String phone;
	private String address;
	private String zipcode;
	private Integer orderState;
	private String kdNum;
	private Double price;
	private Double finalPrice;
	private String discountName;
	private Set<OrderItem> orderItem=new HashSet<OrderItem>(0);
	public String getDiscountName(){
		return this.discountName;
	}
	public void setDiscountName(String discountName){
		this.discountName=discountName;
	}
	public void setFinalPrice(Double finalPrice){
		this.finalPrice=finalPrice;
	}
	public Double getFinalPrice(){
		return this.finalPrice;
	}
	public void setKdNum(String kdNum){
		this.kdNum=kdNum;
	}
	public String getKdNum(){
		return this.kdNum;
	}
	public void setAddress(Address address){
		this.name=address.getName();
		this.phone=address.getPhone();
		this.address=address.getAddress();
		this.zipcode=address.getZipcode();
	}
	public void setOrderItem(Set<OrderItem> orderItem)
	{
		this.orderItem=orderItem;
	}
	public Set<OrderItem> getOrderItem(){
		return this.orderItem;
	}
	public void setPrice(Double price){
		this.price=price;
	}
	public Double getPrice(){
		return this.price;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return this.phone;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return this.address;
	}
	public void setZipcode(String zipcode){
		this.zipcode=zipcode;
	}
	public String getZipcode(){
		return this.zipcode;
	}

	public void setOrderID(Integer orderID){
		this.orderID=orderID;
	}
	public Integer getOrderID(){
		return this.orderID;
	}
	public void setCustomer(Customer customer){
		this.customer=customer;
	}
	public Customer getCustomer(){
		return this.customer;
	}
	public void setOrderState(Integer orderState){
		this.orderState=orderState;
	}
	public Integer getOrderState(){
		return this.orderState;
	}
	public void clearCart() {		//清空购物车
		// TODO Auto-generated method stub
		orderItem.clear();		//清空
	}
	
	
}
