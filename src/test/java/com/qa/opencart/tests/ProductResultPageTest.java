package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductResultPageTest extends BaseTest {

	@BeforeClass
	public void accSepUp() {
		// accPage = new AccountPage(driver);
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void productImageTest() {
		searchResultPage = accPage.doSearch("MacBook");
		productInfoPage =searchResultPage.selectProduct("MacBook Pro");
		Assert.assertEquals(productInfoPage.getProductImageCount(),4);
	}
	
}
