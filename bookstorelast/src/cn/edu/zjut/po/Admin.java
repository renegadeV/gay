package cn.edu.zjut.po;

public class Admin {
	private Integer adminID;
	private String account;
	private String password;
	public void setAdminID(Integer adminID){
		this.adminID=adminID;
	}
	public Integer getAdminID(){
		return this.adminID;
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
}
