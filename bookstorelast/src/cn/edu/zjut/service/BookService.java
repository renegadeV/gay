package cn.edu.zjut.service;

import java.util.List;

import cn.edu.zjut.dao.IBookDAO;
import cn.edu.zjut.po.Book;

public class BookService implements IBookService{
	IBookDAO dao=null;
	public IBookDAO getDao(){
		return dao;
	}
	public void setDao(IBookDAO dao){
		this.dao=dao;
	}
	@Override
	public void addBooks(Book book) {
		// TODO Auto-generated method stub
		dao.add(book);
	}

	@Override
	public void deleteBooks(Book book) {
		// TODO Auto-generated method stub
		dao.delete(book);
	}

	@Override
	public void updateBooks(Book book) {
		// TODO Auto-generated method stub
		dao.update(book);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return dao.getAllBooks();
	}

	@Override
	public List<Book> getBooksByTitle(String title) {
		// TODO Auto-generated method stub
		return dao.getBooksByTitle(title);
	}

	@Override
	public List<Book> getBooksByAuthor(String author) {
		// TODO Auto-generated method stub
		return dao.getBooksByAuthor(author);
	}

	@Override
	public List<Book> getBooksByPress(String press) {
		// TODO Auto-generated method stub
		return dao.getBooksByPress(press);
	}

	@Override
	public List<Book> getBooksByISBN(String ISBN) {
		// TODO Auto-generated method stub
		return dao.getBooksByISBN(ISBN);
	}
	@Override
	public Book getBookByID(Integer bookID) {
		// TODO Auto-generated method stub
		return dao.getBookByID(bookID);
	}
	@Override
	public List<Book> getBookByCid(Integer cid) {
		// TODO Auto-generated method stub
		return dao.findByPageCid(cid);
	}
	@Override
	public List<Book> getBookByCsid(Integer csid) {
		// TODO Auto-generated method stub
		return dao.findByPageCsid(csid);
	}
}
