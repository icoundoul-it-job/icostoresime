package com.icoundoul.icostore.sime.dao.test;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icoundoul.icostore.sime.dao.ICategoryDao;
import com.icoundoul.icostore.sime.model.Category;

public class TestSpringHibernateDao {

	private Category category;
	private ICategoryDao springHibernateDao1;
	private ClassPathXmlApplicationContext appContext;
	
	@Before
	public void chargementDonnees(){
		category = new Category("Informatique","Nos équipements d'informatique");
	    appContext = new ClassPathXmlApplicationContext("spring-data.xml");
	    springHibernateDao1 = (ICategoryDao)appContext.getBean("hibernateCategoryTemplateDao");
	}
	
	@Test
	public void testSaveCateory(){
		springHibernateDao1.saveCategory(category);
	}
	
	@Test
	public void testGetCateory(){
		Category catImmobilier = springHibernateDao1.getCaretgoryById(1);		
		System.out.print(catImmobilier.toString());
	}
	@Test
	public void testGetAllCategories(){
		
		List<Category> results = springHibernateDao1.getAllCategories();
		Assert.assertEquals(3, results.size());
	}
	
	@After
	public void menageDonneesTest(){
		category = null;
		appContext = null;
		springHibernateDao1 = null;		
	}
}
