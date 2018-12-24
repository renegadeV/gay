package cn.edu.zjut.discount;

public class Discount0 implements IDiscount{
	String discountName;
	@Override
	public Double getPrice(Double price) {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public String getDiscountName() {
		// TODO Auto-generated method stub
		return discountName;
	}

	@Override
	public void setDiscountName(String discountName) {
		// TODO Auto-generated method stub
		this.discountName=discountName;
	}

}
