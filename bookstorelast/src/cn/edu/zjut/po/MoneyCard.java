package cn.edu.zjut.po;

public class MoneyCard {
	private Integer moneyCardID;
	private Integer customerID=0;
	private Double money;
	private String password;
	public void setMoneyCardID(Integer moneyCardID){
		this.moneyCardID=moneyCardID;
	}
	public Integer getMoneyCardID(){
		return this.moneyCardID;
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
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return this.password;
	}

}
