package cn.edu.zjut.po;

import java.util.HashSet;
import java.util.Set;

public class CategorySecond {
	private Integer csid;
	private String csname;
	// ����һ������.�����һ������Ķ���.
	private Category category;
	// ������Ʒ����
	private Set<Book> products = new HashSet<Book>();
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<Book> getProducts() {
		return products;
	}
	public void setProducts(Set<Book> products) {
		this.products = products;
	}
	
}
