package cn.edu.zjut.dao;

import java.util.List;

import cn.edu.zjut.po.MoneyCard;

public interface IMoneyCardDAO {
public MoneyCard findMoneyCardByIDandPassword(Integer moneyCardID,String password);
//public MoneyCard findMoneyCardByPassword(String password);
public void updateMoneyCard(MoneyCard moneyCard);
public void addMoneyCard(MoneyCard moneyCard);
public List<MoneyCard> getAllMoneyCard();
public MoneyCard findMoneyCardByID(Integer cardID);
}
