package cn.edu.zjut.dao;

import java.util.List;

import cn.edu.zjut.po.Book;

public interface IBookDAO {
	public void add(Book book);
	public void delete(Book book);
	public void update(Book book);
	public Book getBookByID(Integer id);
	public List<Book> getAllBooks();
	public List<Book> getBooksByTitle(String title);
	public List<Book> getBooksByAuthor(String author);
	public List<Book> getBooksByPress(String press);
	public List<Book> getBooksByISBN(String ISBN);
	public List<Book> findByPageCid(Integer cid);
	public List<Book> findByPageCsid(Integer cid);
}
