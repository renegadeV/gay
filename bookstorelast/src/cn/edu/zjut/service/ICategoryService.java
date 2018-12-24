package cn.edu.zjut.service;

import java.util.List;

import cn.edu.zjut.po.Book;
import cn.edu.zjut.po.Category;

public interface ICategoryService {
	public void save(Category category);
	public void delete(Category category);
	public void update(Category category);
}
