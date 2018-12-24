package cn.edu.zjut.dao;

import java.util.List;

import cn.edu.zjut.po.Category;

public interface ICategoryDao {
	public List<Category> getAllCategory();
	public Category getCategoryByCid(Integer cid);
}