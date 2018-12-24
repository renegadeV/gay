package cn.edu.zjut.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.edu.zjut.po.Book;
import cn.edu.zjut.po.Category;

/**
 * һ������ĳ־ò����
 * @author ����.����
 *
 */
public class CategoryDao extends BaseHibernateDAO implements ICategoryDao{

	//DAO��Ĳ�ѯ����һ������ķ���
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		List<Category> list=null;
		Session session=getSession();
		String hql="from Category b";
		Query query=session.createQuery(hql);
		//query.setInteger(0, -999);
		list=query.list();
		session.close();
		return list;
	}
	// ���ݷ���id��ѯ��Ʒ�ļ���
	public List<Book> findByPageCid(Integer cid, int begin, int limit) {
		List<Book> list=null;
		Session session=getSession();
		String hql = "select p from Category c,CategorySecond cs,Product p where c.cid = cs.category.cid and cs.csid = p.categorySecond.csid and c.cid = ?";
		Query query=session.createQuery(hql);
		list=query.list();
		if(list != null && list.size() > 0){
			return list;
		}
		return null;	
	}
	// Dao�еı���һ������ķ���
		public void save(Category category) {
			// TODO Auto-generated method stub
			Session session=getSession();
			Transaction tx=session.beginTransaction();
			
			try{
				session.save(category);
				tx.commit();
				session.close();
			}catch(Exception e){
				tx.rollback();
				e.printStackTrace();
			}
		}
		public Category getCategoryByCid(Integer cid) {
			// TODO Auto-generated method stub
			Category category=null;
			Session session=getSession();
			String hql="from Category b where b.cid = ?";
			Query query=session.createQuery(hql);
			query.setInteger(0, cid);
			List<Category> list=query.list();
			Iterator iterator=list.iterator();
			if(iterator.hasNext()){
				category=(Category)iterator.next();
			}
			session.close();
			return category;
		}
		public void delete(Category category) {
			// TODO Auto-generated method stub
			Session session=getSession();
			Transaction tx=session.beginTransaction();
			try{
				session.delete(category);
				tx.commit();
				session.close();
			}catch(Exception e){
				tx.rollback();
				session.close();
			}
			
		}
		public void update(Category category) {
			// TODO Auto-generated method stub
			Session session=getSession();
			Transaction tx=session.beginTransaction();
			try{
				session.update(category);
				tx.commit();
				session.close();
			}catch(Exception e){
				tx.rollback();
				session.close();
			}
		}
}
