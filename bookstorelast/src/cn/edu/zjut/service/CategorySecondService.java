package cn.edu.zjut.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.edu.zjut.dao.CategorySecondDao;
import cn.edu.zjut.po.CategorySecond;

@Transactional
public class CategorySecondService {
	// 注入Dao
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	// 业务层的保存二级分类的操作
	public void save(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond);
	}

	// 业务层的删除二级分类的操作
	public void delete(CategorySecond categorySecond) {
		categorySecondDao.delete(categorySecond);
	}

	// 业务层根据id查询二级分类
	public CategorySecond findByCsid(Integer csid) {
		return categorySecondDao.findByCsid(csid);
	}

	// 业务层修改二级分类的方法
	public void update(CategorySecond categorySecond) {
		categorySecondDao.update(categorySecond);
	}

	// 业务层查询所有二级分类(不带分页)
	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
	}
	
}
