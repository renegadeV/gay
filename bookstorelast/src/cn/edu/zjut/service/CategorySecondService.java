package cn.edu.zjut.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.zjut.dao.CategorySecondDao;
import cn.edu.zjut.po.CategorySecond;

@Transactional
public class CategorySecondService {
	// ע��Dao
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	// ҵ���ı����������Ĳ���
	public void save(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond);
	}

	// ҵ����ɾ����������Ĳ���
	public void delete(CategorySecond categorySecond) {
		categorySecondDao.delete(categorySecond);
	}

	// ҵ������id��ѯ��������
	public CategorySecond findByCsid(Integer csid) {
		return categorySecondDao.findByCsid(csid);
	}

	// ҵ����޸Ķ�������ķ���
	public void update(CategorySecond categorySecond) {
		categorySecondDao.update(categorySecond);
	}

	// ҵ����ѯ���ж�������(������ҳ)
	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
	}
	
}
