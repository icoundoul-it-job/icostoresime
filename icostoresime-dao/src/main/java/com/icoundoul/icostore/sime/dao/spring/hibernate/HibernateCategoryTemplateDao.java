package com.icoundoul.icostore.sime.dao.spring.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.icoundoul.icostore.sime.dao.ICategoryDao;
import com.icoundoul.icostore.sime.model.Category;

public class HibernateCategoryTemplateDao implements ICategoryDao{

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void saveCategory(Category category) {
		//hibernateTemplate.saveOrUpdate(category);
		hibernateTemplate.save(category);
	}

	public Category getCaretgoryById(int id) {
		List results = hibernateTemplate.find("from Category where id =" + id);
		return (results.size() >0 ? (Category)results.get(0) : null);
	}

	public Category getCaretgoryByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Category> getAllCategories(){
		List allCategories = hibernateTemplate.find("from Category");
		return allCategories;
	}

}
