package cn.edu.zjut.discount;
import cn.edu.zjut.discount.IDiscount;

public class Discount1 implements IDiscount{
	String discountName;
	@Override
	public Double getPrice(Double price) {
		// TODO Auto-generated method stub
		return price*0.8;
	}

	@Override
	public String getDiscountName() {
		// TODO Auto-generated method stub
		return this.discountName;
	}

	@Override
	public void setDiscountName(String discountName) {
		// TODO Auto-generated method stub
		this.discountName=discountName;
		}
}
