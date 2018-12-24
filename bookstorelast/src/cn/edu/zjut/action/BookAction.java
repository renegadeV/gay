package cn.edu.zjut.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.zjut.po.Book;
import cn.edu.zjut.po.CategorySecond;
import cn.edu.zjut.service.CategorySecondService;
import cn.edu.zjut.service.CategoryService;
import cn.edu.zjut.service.IBookService;

public class BookAction extends ActionSupport{
	private String type;
	private String typeValue;
	// 接收分类cid
	private Integer cid;
	// 接收二级分类id
	private Integer csid;
	protected Book book;
	protected List<Book> bookList;
	protected IBookService bookService=null;
	// 注入一级分类的Service
	public CategoryService categoryService;
	public CategorySecondService categorySecondService;
	// 接收当前页数:
	private int page;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getType(){
		return this.type;
	}
	public void setType(String type){
		this.type=type;
	}
	public String getTypeValue(){
		return this.typeValue;
	}
	public void setTypeValue(String typeValue){
		this.typeValue=typeValue;
	}
	public void setBook(Book book){
		this.book=book;
	}
	public Book getBook(){
		return this.book;
	}
	public void setBookList(List<Book> bookList){
		this.bookList=bookList;
	}
	public List<Book> getBookList(){
		return this.bookList;
	}
	public void setBookService(IBookService bookService){
		this.bookService=bookService;
	}
	public IBookService getBookService(){
		return this.bookService;
	}
	public String getBooksByTitle(){
		bookList=bookService.getBooksByTitle(book.getTitle());
		return "success";
	}
	public String getBooksByAuthor(){
		bookList=bookService.getBooksByAuthor(book.getAuthor());
		return "success";
	}
	public String getBooksByPress(){
		bookList=bookService.getBooksByPress(book.getPress());
		return "success";
	}
	public String getBooksByISBN(){
		bookList=bookService.getBooksByISBN(book.getIsbn());
		return "success";
	}
	//通过书本id获取书本
	public String getBookByID(){
		// 查询所有二级分类.
		List<CategorySecond> csList = categorySecondService.findAll();
		// 将集合存入到值栈中.
		ActionContext.getContext().getValueStack().set("csList", csList);
		book= bookService.getBookByID(book.getBookID());
		return "success";
	}
	//查找书本
	public String findBook(){
		if(typeValue==null||typeValue.equals("")){
			//this.addActionError("请输入搜索内容！");
			bookList=bookService.getAllBooks();
			return "null";
		}
		else{
			if(type.equals("bookname")){
				bookList=bookService.getBooksByTitle(typeValue);
			}
			else if(type.equals("author")){
				bookList=bookService.getBooksByAuthor(typeValue);
			}
			else if(type.equals("bookID")){
				bookList=new ArrayList<Book>(0);
				book=bookService.getBookByID(Integer.parseInt(typeValue));
				if(book!=null){
					bookList.add(book);
				}
				
			}
		}
		if(bookList==null||bookList.size()==0){
			this.addActionMessage("没有查询到相关内容！");
		}
		return "success";
	}
	// 根据分类的id查询商品:
	public String findByCid() {
		bookList=bookService.getBookByCid(cid);
		return "findByCid";
	}
	// 根据二级分类id查询商品:
	public String findByCsid() {
		bookList=bookService.getBookByCsid(csid);
		return "findByCsid";
	}
	//获取所有书本
	public String getAllBooks(){
		bookList=bookService.getAllBooks();
		return "success";
	}
	
}
