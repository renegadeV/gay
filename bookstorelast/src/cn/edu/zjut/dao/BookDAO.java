package cn.edu.zjut.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.edu.zjut.po.Book;

public class BookDAO extends BaseHibernateDAO implements IBookDAO{

	@Override
	public void add(Book book) {
		
		// TODO Auto-generated method stub
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		
		try{
			session.save(book);
			tx.commit();
			session.close();
		}catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Book book) {
		// TODO Auto-generated method stub
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		try{
			session.delete(book);
			tx.commit();
			session.close();
		}catch(Exception e){
			tx.rollback();
			session.close();
		}
		
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		try{
			session.update(book);
			tx.commit();
			session.close();
		}catch(Exception e){
			tx.rollback();
			session.close();
		}
	}

	@Override
	public Book getBookByID(Integer id) {
		// TODO Auto-generated method stub
		Book book=null;
		Session session=getSession();
		String hql="from Book b where b.bookID = ?";
		Query query=session.createQuery(hql);
		query.setInteger(0, id);
		List<Book> list=query.list();
		Iterator iterator=list.iterator();
		if(iterator.hasNext()){
			book=(Book)iterator.next();
		}
		session.close();
		return book;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		List<Book> list=null;
		Session session=getSession();
		String hql="from Book b";
		Query query=session.createQuery(hql);
		//query.setInteger(0, -999);
		list=query.list();
		session.close();
		return list;
	}
	
	@Override
	public List<Book> getBooksByTitle(String title) {
		// TODO Auto-generated method stub
		List<Book> list=null;
		Session session=getSession();
		String hql="from Book b where b.title like ?";
		Query query=session.createQuery(hql);
		query.setString(0, "%"+title+"%");
		list=query.list();
		session.close();
		return list;
	}

	@Override
	public List<Book> getBooksByAuthor(String author) {
		// TODO Auto-generated method stub
		List<Book> list=null;
		Session session=getSession();
		String hql="from Book b where b.author=?";
		Query query=session.createQuery(hql);
		query.setString(0, author);
		//query.setInteger(1, -999);
		list=query.list();
		return list;
	}

	@Override
	public List<Book> getBooksByPress(String press) {
		// TODO Auto-generated method stub
		List<Book> list=null;
		Session session=getSession();
		String hql="from Book b where b.author=?";
		Query query=session.createQuery(hql);
		query.setString(0,press);
	//	query.setInteger(1, -999);
		list=query.list();
		return list;
	}

	@Override
	public List<Book> getBooksByISBN(String ISBN) {
		// TODO Auto-generated method stub
		List<Book> list=null;
		Session session=getSession();
		String hql="from Book b where b.iSBN=?";
		Query query=session.createQuery(hql);
		query.setString(0,ISBN);
		//query.setInteger(1, -999);
		list=query.list();
		return list;
	}

	// 根据分类id查询商品的个数
	public int findCountCid(Integer cid) {
		Session session=getSession();
		String hql = "select count(*) from Book p where p.categorySecond.category.cid = ?";
		Query query=session.createQuery(hql);
		query.setInteger(0,cid);
		List<Long> list = query.list();
		if(list != null && list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}
	// 根据分类id查询商品的集合
	public List<Book> findByPageCid(Integer cid) {
		List<Book> list=null;
		Session session=getSession();
		String hql = "select p from Category c,CategorySecond cs,Book p where c.cid = cs.category.cid and cs.csid = p.categorySecond.csid and c.cid = ?";
		Query query=session.createQuery(hql);
		query.setInteger(0, cid);
		list=query.list();
		return list;
	}
	// 根据二级分类id查询商品的集合
		public List<Book> findByPageCsid(Integer csid) {
			List<Book> list=null;
			Session session=getSession();
			//select p from Category c,CategorySecond cs,Product p where c.cid = cs.category.cid and cs.csid = p.categorySecond.csid and c.cid = ?
			String hql = "select p from Book p join p.categorySecond cs where cs.csid = ?";
			Query query=session.createQuery(hql);
			query.setInteger(0,csid);
			list=query.list();
			return list;
		}
}
