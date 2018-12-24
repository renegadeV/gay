package cn.edu.zjut.po;

public class Address {
	private Integer addressID;
	private Integer customerID;
	private String name;
	private String phone;
	private String address;
	private String zipcode;
	public void setAddressID(Integer addressID){
		this.addressID=addressID;
	}
	public Integer getAddressID(){
		return this.addressID;
	}
	public void setCustomerID(Integer customerID){
		this.customerID=customerID;
	}
	public Integer getCustomerID(){
		return this.customerID;
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

}
