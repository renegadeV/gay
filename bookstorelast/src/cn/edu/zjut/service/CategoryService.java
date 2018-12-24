package cn.edu.zjut.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.zjut.dao.CategoryDao;
import cn.edu.zjut.po.Book;
import cn.edu.zjut.po.Category;

/**
 * һ�������ҵ������
 * @author ����.����
 *
 */
@Transactional
public class CategoryService {
	// ע��CategoryDao
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	// ҵ����ѯ����һ������ķ���
	public List<Category> findAll() {
		return categoryDao.getAllCategory();
	}

	// ҵ��㱣��һ������Ĳ���
	public void save(Category category) {
		categoryDao.save(category);
	}

	// ҵ������һ������id��ѯһ������
	public Category findByCid(Integer cid) {
		return categoryDao.getCategoryByCid(cid);
	}

	// ҵ���ɾ��һ������
	public void delete(Category category) {
		categoryDao.delete(category);
	}

	// ҵ����޸�һ������
	public void update(Category category) {
		categoryDao.update(category);
	}
}
