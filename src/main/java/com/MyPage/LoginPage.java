package com.MyPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

	private By signInClick = By.xpath("//a[contains(text(),'Signin')]");
	private By emailId=By.xpath("//div[@id='login']//input[@name='username']");
	private By password=By.xpath("//div[@id='login']//input[@name='password']");
	private By submit=By.xpath("//div[@id='login']//input[@class='button']");
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement getEmailId() {
		return getElement(emailId);
	}

	public WebElement getSignInClick() {
		return getElement(signInClick);
	}

	public void setSignInClick(By signInClick) {
		this.signInClick = signInClick;
	}

	public void setEmailId(By emailId) {
		this.emailId = emailId;
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public void setPassword(By password) {
		this.password = password;
	}

	public WebElement getSubmit() {
		return getElement(submit);
	}

	public void setSubmit(By submit) {
		this.submit = submit;
	}
	
	public String getLoginPageTitle()
	{
		return getPageTitle();
	}
	
	
	
	public HomePage DoLogin()
	{
		getSignInClick().click();
		getEmailId().sendKeys("");
		getPassword().sendKeys("");
		getSubmit().click();
		return getInstance(HomePage.class);
	}
	
	public HomePage DoLogin(String username, String password)
	{
		getSignInClick().click();
		getEmailId().sendKeys(username);
		getPassword().sendKeys(password);
		getSubmit().click();
		return getInstance(HomePage.class);
	}
}
