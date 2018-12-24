package cn.edu.zjut.service;

import java.util.List;

import cn.edu.zjut.po.Book;

public interface IBookService {  
	public void addBooks(Book book);
	public void deleteBooks(Book book);
	public void updateBooks(Book book);
	public Book getBookByID(Integer bookID);
	public List<Book> getAllBooks();
	public List<Book> getBooksByTitle(String title);
	public List<Book> getBooksByAuthor(String author);
	public List<Book> getBooksByPress(String press);
	public List<Book> getBooksByISBN(String ISBN);
	public List<Book> getBookByCid(Integer cid);
	public List<Book> getBookByCsid(Integer cid);
}
