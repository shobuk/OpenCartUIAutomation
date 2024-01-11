package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest {


	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
	}
	@Test(priority = 2)
	public void loginPageURLTest() {
		String actURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION));
	}
	@Test(priority = 3)
	public void forgotPWDLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	@Test(priority = 4)
	public void logoIsExistTest()  {
		Assert.assertTrue(loginPage.isLogoExist());
		
	}
	@Test(priority = 5)
	public void loginTest()throws InterruptedException{
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(accPage.isLogutLinkExist());
	}
	
}
