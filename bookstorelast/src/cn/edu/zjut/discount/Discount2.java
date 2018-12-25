package cn.edu.zjut.discount;

public class Discount2 implements IDiscount{
	String discountName;
	@Override
	public Double getPrice(Double price) {
		// TODO Auto-generated method stub
		if(price>=200.0)
		{
			price=price-50;
		}
		else if(price>=100.0){
		price=price-20.0;
		}
		return price;
	}

	@Override
	public String getDiscountName() {
		// TODO Auto-generated method stub
		return this.discountName;
	}
	public void setDiscountName(String discountName){
		this.discountName=discountName;
	}

}
