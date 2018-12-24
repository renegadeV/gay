package cn.edu.zjut.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.edu.zjut.po.MoneyCard;

public class MoneyCardDAO extends BaseHibernateDAO implements IMoneyCardDAO{

	@Override
	public MoneyCard findMoneyCardByIDandPassword(Integer moneyCardID, String password) {
		// TODO Auto-generated method stub
		MoneyCard card=null;
		Session session=getSession();
		String hql="from MoneyCard where moneyCardID=? and password=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, moneyCardID);
		query.setString(1, password);
		Iterator it=query.list().iterator();
		if(it.hasNext()){
			card=(MoneyCard) it.next(); 
		}
		session.close();
		return card;
	}
	/*public MoneyCard findMoneyCardByPassword(String password) {
		// TODO Auto-generated method stub
		MoneyCard card=null;
		Session session=getSession();
		String hql="from MoneyCard where password=?";
		Query query=session.createQuery(hql);
		query.setString(0,password);
		Iterator it=query.list().iterator();
		if(it.hasNext()){
			card=(MoneyCard) it.next(); 
		}
		session.close();
		return card;
	}*/
	@Override
	public void updateMoneyCard(MoneyCard moneyCard) {
		// TODO Auto-generated method stub
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		session.update(moneyCard);
		tran.commit();
		session.close();
		
	}

	@Override
	public void addMoneyCard(MoneyCard moneyCard) {
		// TODO Auto-generated method stub
		Session session=getSession();
		Transaction tran=session.beginTransaction();
		session.save(moneyCard);
		tran.commit();
		session.close();
		
	}

	@Override
	public List<MoneyCard> getAllMoneyCard() {
		// TODO Auto-generated method stub
		List<MoneyCard> cards=null;
		Session session=getSession();
		String hql="from MoneyCard";
		Query query=session.createQuery(hql);
		cards=query.list();
		session.close();
		return cards;
	}

	@Override
	public MoneyCard findMoneyCardByID(Integer cardID) {
		// TODO Auto-generated method stub
		List<MoneyCard> cards=null;
		Session session=getSession();
		String hql="from MoneyCard where moneyCardID=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, cardID);
		cards=query.list();
		session.close();
		for(MoneyCard card:cards){
			return card;
		}
		return null;
	}

}
