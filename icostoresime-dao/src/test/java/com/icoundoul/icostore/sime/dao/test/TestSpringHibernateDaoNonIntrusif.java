package com.icoundoul.icostore.sime.dao.test;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icoundoul.icostore.sime.dao.ICategoryDao;
import com.icoundoul.icostore.sime.model.Category;

public class TestSpringHibernateDaoNonIntrusif {
	private Category category;
	private ICategoryDao springHibernateDaoNonIntrusif;
	private ClassPathXmlApplicationContext appContext;
	
	@Before
	public void chargementDonnees(){
		category = new Category("Informatique","Nos équipements d'informatique");
	    appContext = new ClassPathXmlApplicationContext("spring-data.xml");
	    springHibernateDaoNonIntrusif = (ICategoryDao)appContext.getBean("hibernateNonIntrusiveCategoryDao");
	}
	
	@Test
	public void testSaveCateory(){
		springHibernateDaoNonIntrusif.saveCategory(category);
	}
	
	@Test
	public void testGetCateory(){
		Category catImmobilier = springHibernateDaoNonIntrusif.getCaretgoryById(1);				
		Assert.assertEquals(1, catImmobilier.getId());
	}
	
	@Test
	public void testGetCateoryByName(){
		Category catImmobilier = springHibernateDaoNonIntrusif.getCaretgoryByName("Informatique");		
		Assert.assertEquals("Informatique", catImmobilier.getName());
	}
	
	@Test
	public void testGetAllCategories(){
		
		List<Category> results = springHibernateDaoNonIntrusif.getAllCategories();
		//Assert.assertEquals(3, results.size());
	}
	
	@After
	public void menageDonneesTest(){
		category = null;
		appContext = null;
		springHibernateDaoNonIntrusif = null;		
	}
}
