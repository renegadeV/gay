package cn.edu.zjut.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.edu.zjut.po.Address;

public class BaseHibernateDAO {
	private SessionFactory sessionFactory=null;
	public Session getSession(){
		return this.sessionFactory.openSession();
	}
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

}
