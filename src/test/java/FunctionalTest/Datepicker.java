package FunctionalTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class Datepicker {

	WebDriver driver;
	
	
	@Test
	public void formatDate() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
    	driver= new ChromeDriver();
    	driver.manage().window().maximize();

    	File fl= new File("D://eclipse//AutomationFrameworkpractice//src//test//resources//config.properties");
    	FileInputStream fis= new FileInputStream(fl);
    	Properties prop=new Properties();
    	prop.load(fis);
    	driver.get(prop.getProperty("URL"));
		//driver.get("http://way2automation.com/way2auto_jquery/index.php");
		driver.findElement(By.xpath("//a[contains(text(),'Signin')]")).click();
		driver.findElement(By.xpath("//div[@id='login']//input[@name='username']")).sendKeys("rahul123");
		driver.findElement(By.xpath("//div[@id='login']//input[@name='password']")).sendKeys("Rahul@123");
		driver.findElement(By.xpath("//div[@id='login']//input[@class='button']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[2]/div[2]/ul/li[3]/a/figure/img")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[6]/a")).click();
	}
}
