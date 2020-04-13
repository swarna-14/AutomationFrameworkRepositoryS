package com.MyPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page{

	public BasePage(WebDriver driver)
	{
		super(driver);
	}

	@Override
	public String getPageTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		// TODO Auto-generated method stub
		WebElement element=null;
		try
		{
			element=driver.findElement(locator);
		
		return element;
		}
		catch(Exception e)
		{
		System.out.println("Some error occured while creating element" +locator.toString());
		e.printStackTrace();
		}
		return element;
	}

	@Override
	public void waitForElementPresent(By locator) {
		// TODO Auto-generated method stub
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		catch(Exception e)
		{
			System.out.println("some exception/error occured while waiting for the element" +locator.toString());
		}
	}

	@Override
	public void waitForPageTitle(String title) {
		// TODO Auto-generated method stub
		try
		{
			wait.until(ExpectedConditions.titleContains(title));
		}
		catch(Exception e)
		{
			System.out.println("some exception/error occured while waiting for the element" +title);
		}
	}

	


	
}
