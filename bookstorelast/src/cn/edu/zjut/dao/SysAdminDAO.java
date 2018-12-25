package cn.edu.zjut.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.edu.zjut.po.Book;
import cn.edu.zjut.po.Category;
import cn.edu.zjut.po.CategorySecond;
import cn.edu.zjut.po.Customer;
import cn.edu.zjut.po.Role;

public class SysAdminDAO extends BaseHibernateDAO implements ISysAdminDAO{
	@Override
	public boolean login(String account,String password) {
		// TODO Auto-generated method stub
		Session session=getSession();
		String hql="from SysAdmin a where a.account=? and a.password=?";
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
	public void saveRole(Role role) {
		// TODO Auto-generated method stub
		
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		try{
			session.save(role);
			tx.commit();
			session.close();
		}catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}
	}
	
	public void deleteRole(Role role) {
		// TODO Auto-generated method stub
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		try{
			session.delete(role);
			tx.commit();
			session.close();
		}catch(Exception e){
			tx.rollback();
			session.close();
		}
		
	}
	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		try{
			session.update(role);
			tx.commit();
			session.close();
		}catch(Exception e){
			tx.rollback();
			session.close();
		}
	}
	public List<Role> findAllRoles(){
		// TODO Auto-generated method stub
		List<Role> list=null;
		Session session=getSession();
		String hql="from Role b";
		Query query=session.createQuery(hql);
		//query.setInteger(0, -999);
		list=query.list();
		session.close();
		return list;
	}
	
	public Role findRoleByRoleID(Integer roleID){
		Role role=null;
		Session session=getSession();
		String hql="from Role c where c.roleID=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, roleID);
		List<Role> list=query.list();
		Iterator it=list.iterator();
		if(it.hasNext()){
			role=(Role)it.next();
		}
		session.close();
		return role;
	}
}
