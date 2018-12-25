package cn.edu.zjut.po;

public class OrderItem {
	private Integer itemID;
	private UserOrder order;
	private Integer num;
	private Double bookPrice;
	private Book book;
	private Double price;
	private String bookTitle;
	public String getBookTitle(){
		return this.bookTitle;
	}
	public void setBookTitle(String bookTitle){
		this.bookTitle=bookTitle;
	}
	
	public void setBookPrice(Double bookPrice){
		this.bookPrice=bookPrice;
	}
	public Double getBookPrice(){
		return this.bookPrice;
	}
	public void setPrice(Double price){
		this.price=price;
	}
	public Double getPrice(){
		return this.price;
	}
	public void setBook(Book book){
		this.book=book;
	}
	public Book getBook(){
		return this.book;
	}
	public void setOrder(UserOrder order){
		this.order=order;
	}
	public UserOrder getOrder(){
		return this.order;
	}
	public void setItemID(Integer itemID){
		this.itemID=itemID;
	}
	public Integer getItemID(){
		return this.itemID;
	}

	public void setNum(Integer num){
		this.num=num;
	}
	public Integer getNum(){
		return this.num;
	}

}
