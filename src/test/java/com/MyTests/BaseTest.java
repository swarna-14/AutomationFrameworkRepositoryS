package com.MyTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.MyPage.BasePage;
import com.MyPage.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	public Page page;
	
	
	@BeforeMethod
	
	@Parameters(value= {"browser"})
	
	public void setUpTest(String browser)
	{
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
		}
		else if(browser.equals("ff"))
		{
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("no browser is defined in xml file");
		}
		
		driver.get("http://way2automation.com/way2auto_jquery/index.php");
		
		page = new BasePage(driver);
	}
	
	@AfterMethod()
	public void finish()
	{
		driver.quit();
	}
	
}
