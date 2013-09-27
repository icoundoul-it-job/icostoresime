package com.icoundoul.icostore.sime.dao;

import java.util.List;

import com.icoundoul.icostore.sime.model.Category;

public interface ICategoryDao {

	public void saveCategory(Category category);
	public Category getCaretgoryById(int id);
	public Category getCaretgoryByName(String name);
	public List<Category> getAllCategories();
}
