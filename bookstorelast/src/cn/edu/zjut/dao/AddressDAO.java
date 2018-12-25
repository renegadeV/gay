package cn.edu.zjut.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.edu.zjut.po.Address;

public class AddressDAO extends BaseHibernateDAO implements IAddressDAO{

	@Override
	public void UpdateAddress(Address address) {
		// TODO Auto-generated method stub
		Session session=getSession();
		Transaction trans=session.beginTransaction();
		session.update(address);
		trans.commit();
		session.close();
	}

}
