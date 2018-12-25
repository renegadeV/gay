package cn.edu.zjut.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.edu.zjut.po.Customer;
import cn.edu.zjut.po.MoneyCard;

public class AdminDAO extends BaseHibernateDAO implements IAdminDAO{

	@Override
	public boolean login(String account,String password) {
		// TODO Auto-generated method stub
		Session session=getSession();
		String hql="from Admin a where a.account=? and a.password=?";
		Query query=session.createQuery(hql);
		query.setString(0, account);
		query.setString(1, password);
		List list=query.list();
		session.close();
		Iterator it=list.iterator();
		if(it.hasNext())
		return true;
		return false;
	}
	public Customer getCustomerByID(Integer customerID){
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
	
}
