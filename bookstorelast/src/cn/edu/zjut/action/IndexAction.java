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
	// ע��һ�������Service:
	private CategoryService categoryService;
	public CategorySecondService categorySecondService;
	protected List<Book> bookList;
	// ע����Ʒ��Service
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
	 * ִ�еķ�����ҳ�ķ���:
	 */
	public String execute(){
		// ��ѯ����һ�����༯��
		List<Category> cList = categoryService.findAll();
		// ��һ��������뵽Session�ķ�Χ:
		ActionContext.getContext().getSession().put("cList", cList);
		// ��ѯ���ж�������.
		List<CategorySecond> csList = categorySecondService.findAll();
		// �����ϴ��뵽ֵջ��.
		ActionContext.getContext().getValueStack().set("csList", csList);
		List<Book> bookList=bookService.getAllBooks();
		ActionContext.getContext().getValueStack().set("bookList", bookList);
		return "index";
	}
	
	
}
