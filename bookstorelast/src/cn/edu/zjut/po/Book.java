package cn.edu.zjut.po;

public class Book {
	private Integer bookID;
	private String isbn;
	private String title;
	private String author;
	private String press;
	private String description;
	private Integer soldNum;
	private Integer stockNum;
	private Double price;
	private String paddress;
	// 二级分类的外键:使用二级分类的对象.
	private CategorySecond categorySecond;
	public CategorySecond getCategorySecond() {
		return categorySecond;
	}
	public void setCategorySecond(CategorySecond categorySecond) {
		this.categorySecond = categorySecond;
	}
	public void setPrice(Double price){
		this.price=price;
	}
	public Double getPrice(){
		return this.price;
	}
	public void setIsbn(String isbn){
		this.isbn=isbn;
	}
	public String getIsbn(){
		return this.isbn;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return this.title;
	}
	public void setAuthor(String author){
		this.author=author;
	}
	public String getAuthor(){
		return this.author;
	}
	public void setPress(String press){
		this.press=press;
	}
	public String getPress(){
		return this.press;
	}
	public void setDescription(String description){
		this.description=description;
	}
	public String getDescription(){
		return this.description;
	}
	public void setBookID(Integer bookID){
		this.bookID=bookID;
	}
	public Integer getBookID(){
		return this.bookID;
	}
	public void setSoldNum(Integer soldNum){
		this.soldNum=soldNum;
	}
	public Integer getSoldNum(){
		return this.soldNum;
	}
	public void setStockNum(Integer stockNum){
		this.stockNum=stockNum;
	}
	public Integer getStockNum(){
		return this.stockNum;
	}
	public void setPaddress(String paddress){
		this.paddress=paddress;
	}
	public String getPaddress(){
		return this.paddress;
	}
}
