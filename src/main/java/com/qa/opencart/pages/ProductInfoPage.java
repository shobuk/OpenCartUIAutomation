package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	private ElementUtil eleUtil;
	private WebDriver driver;
	private By productHeader = By.xpath("//h1[normalize-space()='MacBook Pro']");
	private By productImage = By.xpath("//a[@class=\"thumbnail\"]");
	private By productMetadata = By.xpath("(//div[@id = 'content']//ul[@class = 'list-unstyled'])[1]//li");
	private By productPriceData = By.xpath("(//div[@id = 'content']//ul[@class = 'list-unstyled'])[2]//li");
	private Map<String,String> productMap = new HashMap<String,String>();
	

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	public String getProductHeaderName() {
		String productHeaderVal = eleUtil.doElementGetText(productHeader);
		System.out.println("Product Header :" + productHeaderVal);
		return productHeaderVal;
	}

	public int getProductImageCount() {
		int imageCount = eleUtil.waitForVisibilityOfElements(productImage, AppConstants.MEDIUM_DEFAULT_WAIT).size();
		System.out.println("Product :- " + getProductHeaderName() + "Image Count:- " + imageCount );
		return imageCount;
		
	}
	public void getProductMetadata() {
		List<WebElement> metadatList = eleUtil.waitForVisibilityOfElements(productMetadata, 0);
		for(WebElement e :metadatList) {
			String metaValue = e.getText();
			String metaKey = metaValue.split(":")[0].trim();
			String metaVal = metaValue.split(":")[1].trim();
			productMap.put(metaKey,metaVal);
			
		}
	}
	public void getProductMetaPriceList() {
		List<WebElement> metadatList = eleUtil.waitForVisibilityOfElements(productPriceData, 0);
		for(WebElement e :metadatList) {
			String metaValue = e.getText();
			String metaKey = metaValue.split(":")[0].trim();
			String metaVal = metaValue.split(":")[1].trim();
			productMap.put(metaKey,metaVal);
			
		}
	}
	
}
