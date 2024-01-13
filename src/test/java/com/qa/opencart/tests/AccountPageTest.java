package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.SearchResultPage;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accSepUp() {
	//	accPage = new AccountPage(driver);
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}
	@Test
	public void getAccPageTitleTest() {
		Assert.assertEquals(accPage.getAccountPageTitle(), AppConstants.ACCOUNT_PAGE_TITLE);
	}
	
	@Test
	public void getAccPageURLTest() {
		Assert.assertTrue(accPage.getAccountPageURL().contains(AppConstants.ACCOUNT_PAGE_URL_FRACTION));
	}
	
	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogutLinkExist());
	}
	@Test
	public void accPageHeaderCountTest() {
		List <String> actAccPageHeaderList = accPage.getAccountsHeader();
		System.out.println(actAccPageHeaderList);
		Assert.assertEquals(actAccPageHeaderList.size(), AppConstants.ACCOUNT_PAGE_HEADER_COUNT);
		
	}
	@Test
	public void accPageHeaderListTest() {
		List <String> actAccPageHeaderList = accPage.getAccountsHeader();
		Assert.assertEquals(actAccPageHeaderList, AppConstants.ACCOUNT_PAGE_HEADER_List);
		
	}
	@Test
	public void searchTest() {
		searchResultPage = accPage.doSearch("MacBook");
		productInfoPage	= searchResultPage.selectProduct("MacBook Pro");
		Assert.assertEquals(productInfoPage.getProductHeaderName(), "MacBook Pro");
		
	}
}
