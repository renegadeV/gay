package cn.edu.zjut.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.edu.zjut.po.Category;
import cn.edu.zjut.po.CategorySecond;

public class CategorySecondDao extends BaseHibernateDAO{

	// DAO中的保存二级分类的方法
	public void save(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		try{
			session.save(categorySecond);
			tx.commit();
			session.close();
		}catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}
	}

	// DAO中的删除二级分类的方法
	public void delete(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		try{
			session.delete(categorySecond);
			tx.commit();
			session.close();
		}catch(Exception e){
			tx.rollback();
			session.close();
		}
	}

	// DAO中根据id查询二级分类的方法
	public CategorySecond findByCsid(Integer csid) {
		// TODO Auto-generated method stub
		CategorySecond categorySecond=null;
		Session session=getSession();
		String hql="from CategorySecond b where b.csid = ?";
		Query query=session.createQuery(hql);
		query.setInteger(0, csid);
		List<CategorySecond> list=query.list();
		Iterator iterator=list.iterator();
		if(iterator.hasNext()){
			categorySecond=(CategorySecond)iterator.next();
		}
		session.close();
		return categorySecond;
	}

	// DAO中的修改二级分类的方法
	public void update(CategorySecond categorySecond) {
		// TODO Auto-generated method stub
		System.out.println(categorySecond.getCsname()+categorySecond.getCategory().getCid());
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		try{
			session.update(categorySecond);
			tx.commit();
			session.close();
		}catch(Exception e){
			tx.rollback();
			session.close();
		}
	}
	// DAO中的查询所有二级分类的方法
	public List<CategorySecond> findAll() {
		// TODO Auto-generated method stub
		List<CategorySecond> list=null;
		Session session=getSession();
		String hql="from CategorySecond b";
		Query query=session.createQuery(hql);
		//query.setInteger(0, -999);
		list=query.list();
		session.close();
		return list;
	}
}
