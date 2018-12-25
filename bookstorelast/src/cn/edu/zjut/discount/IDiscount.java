package cn.edu.zjut.discount;

public interface IDiscount {
	public Double getPrice(Double price);
	public String getDiscountName();
	public void setDiscountName(String discountName);
}
