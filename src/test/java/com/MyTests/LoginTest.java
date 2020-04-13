package com.MyTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.MyPage.HomePage;
import com.MyPage.LoginPage;

public class LoginTest extends BaseTest{

	@Test(priority=0)
	public void verifyLoginPageTitleTest()
	{
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Welcome to the Test Site");
	}
	@Test(priority=1)
	public void doLoginTest()
	{
		HomePage homepage = page.getInstance(LoginPage.class).DoLogin("rahul123", "Rahul@123");
	}
	
	
}
