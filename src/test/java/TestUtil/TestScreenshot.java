package TestUtil;




import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestScreenshot implements TakesScreenshot {

	WebDriver driver;
	TestScreenshot ts;
	
	@Test
	public void demoscreenshot() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
    	driver= new ChromeDriver();
    	driver.manage().window().maximize();
		driver.get("http://way2automation.com/demo.html");
//		driver.findElement(By.xpath("//a[contains(text(),'Signin')]")).click();
//		driver.findElement(By.xpath("//div[@id='login']//input[@name='username']")).sendKeys("rahul123");
//		driver.findElement(By.xpath("//div[@id='login']//input[@name='password']")).sendKeys("Rahul@123");
//		driver.findElement(By.xpath("//div[@id='login']//input[@class='button']")).click();
    	Thread.sleep(2000);	
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//File src=ts.getScreenshotAs(OutputType.FILE);
		try
		{
		FileUtils.copyFile(src, new File("D:\\error\\err.jpg"));
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		// TODO Auto-generated method stub
		return null;
	}
}
