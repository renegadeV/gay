package cn.edu.zjut.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.edu.zjut.po.Address;
import cn.edu.zjut.po.CategorySecond;
import cn.edu.zjut.po.Customer;
import cn.edu.zjut.po.MoneyCard;
import cn.edu.zjut.po.Role;

public class CustomerDAO extends BaseHibernateDAO implements ICustomerDAO{

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
	//	try{
		session=getSession();
		tx=session.beginTransaction();
		session.save(customer);
		tx.commit();
		session.close();
	/*	}catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}*/
	}
	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		try{
			session.update(customer);
			tx.commit();
			session.close();
		}catch(Exception e){
			tx.rollback();
			session.close();
		}
	}

	@Override
	public Customer login(String account,String password) {
		// TODO Auto-generated method stub
		Customer customer=null;
		Session session=getSession();
		String hql="from Customer c where c.account=? and c.password=?";
		Query query=session.createQuery(hql);
		query.setString(0, account);
		query.setString(1, password);
		List<Customer> list=query.list();
		Iterator it=list.iterator();
		if(it.hasNext()){
			customer=(Customer)it.next();
		}
		session.close();
		return customer;
		
	}
	@Override
	public Customer findCustomerByID(Integer customerID) {
		// TODO Auto-generated method stub
		
		Customer customer=null;
		Session session=getSession();
		String hql="from Customer c where c.customerID=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, customerID);
		List<Customer> list=query.list();
		Iterator it=list.iterator();
		if(it.hasNext()){
			customer=(Customer)it.next();
		}
		session.close();
		return customer;
	}
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		try{
			session.delete(customer);
			tx.commit();
			session.close();
		}catch(Exception e){
			tx.rollback();
			session.close();
		}
	}
}
