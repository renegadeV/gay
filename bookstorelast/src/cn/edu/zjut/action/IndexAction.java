package cn.edu.zjut.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.zjut.po.Book;
import cn.edu.zjut.po.Category;
import cn.edu.zjut.po.CategorySecond;
import cn.edu.zjut.service.BookService;
import cn.edu.zjut.service.CategorySecondService;
import cn.edu.zjut.service.CategoryService;

public class IndexAction extends ActionSupport{
	// 注入一级分类的Service:
	private CategoryService categoryService;
	public CategorySecondService categorySecondService;
	protected List<Book> bookList;
	// 注入商品的Service
	private BookService bookService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setProductService(BookService bookService) {
		this.bookService = bookService;
	}
	
	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}
	
	public CategorySecondService getCategorySecondService() {
		return categorySecondService;
	}

	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	/**
	 * 执行的访问首页的方法:
	 */
	public String execute(){
		// 查询所有一级分类集合
		List<Category> cList = categoryService.findAll();
		// 将一级分类存入到Session的范围:
		ActionContext.getContext().getSession().put("cList", cList);
		// 查询所有二级分类.
		List<CategorySecond> csList = categorySecondService.findAll();
		// 将集合存入到值栈中.
		ActionContext.getContext().getValueStack().set("csList", csList);
		List<Book> bookList=bookService.getAllBooks();
		ActionContext.getContext().getValueStack().set("bookList", bookList);
		return "index";
	}
	
	
}
