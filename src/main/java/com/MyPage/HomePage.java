package com.MyPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
	
	private By header= By.xpath("//h1[contains(text(),'Website for')]");

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public WebElement getHeader()
	{
		return getElement(header);
	}
	public String getHomePageTitle()
	{
		return getPageTitle();
	}
	
//	public String  getHomePageHeader()
//	{
//		return getPageHeader(header);
//	}

}
