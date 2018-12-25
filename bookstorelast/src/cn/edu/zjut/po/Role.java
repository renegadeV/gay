package cn.edu.zjut.po;

import java.util.Set;

public class Role {
	private Integer roleID;
	private String roleName;
	private Integer rightCode;
	private Set<Customer> customers;
	
	public Set<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	public Integer getRoleID() {
		return roleID;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getRightCode() {
		return rightCode;
	}
	public void setRightCode(Integer rightCode) {
		this.rightCode = rightCode;
	}
	
}
