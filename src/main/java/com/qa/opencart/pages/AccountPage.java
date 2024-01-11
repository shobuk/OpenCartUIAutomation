package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountPage {

	private WebDriver driver;
	ElementUtil eleUtil;

	private By logoutLink = By.linkText("Logout");
	private By Search = By.name("search");
	private By accHeaders = By.cssSelector("div#content >h2");

	// Page Const....
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	public String getAccountPageTitle() {
		String title = eleUtil.waitForTitleIs(AppConstants.ACCOUNT_PAGE_TITLE, AppConstants.SHORT_DEFAULT_WAIT);
		System.out.println("Account Page Title :-" + title);
		return title;
	}

	public String getAccountPageURL() {
		String AccountPageURL = eleUtil.waitForURLContains(AppConstants.ACCOUNT_PAGE_URL_FRACTION, AppConstants.SHORT_DEFAULT_WAIT);
		System.out.println("Login Page URL :-" + AccountPageURL);
		return AccountPageURL;
	}

	public boolean isLogutLinkExist() {
		return eleUtil.waitForVisibilityOfElement(logoutLink, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
	}

	public boolean isSearchFieldExist() {
		return eleUtil.waitForVisibilityOfElement(Search, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
	}

	public List<String> getAccountsHeader() {
		List<WebElement> headerList = eleUtil.waitForVisibilityOfElements(accHeaders, AppConstants.SHORT_DEFAULT_WAIT);
		List<String> headerValList = new ArrayList<String>();
		for (WebElement e : headerList) {
			String text = e.getText();
			headerValList.add(text);
		}
		return headerValList;

	}
}
