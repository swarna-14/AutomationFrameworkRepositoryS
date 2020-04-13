package FunctionalTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tooltip {

	WebDriver driver;
	
	@Test
	public void tooltiptest() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
    	driver= new ChromeDriver();
    	driver.manage().window().maximize();
		driver.get("http://way2automation.com/way2auto_jquery/index.php");
		driver.findElement(By.xpath("//a[contains(text(),'Signin')]")).click();
		driver.findElement(By.xpath("//div[@id='login']//input[@name='username']")).sendKeys("rahul123");
		driver.findElement(By.xpath("//div[@id='login']//input[@name='password']")).sendKeys("Rahul@123");
		driver.findElement(By.xpath("//div[@id='login']//input[@class='button']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1050)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[2]/div[2]/ul/li[7]/a/figure/img")).click();
		driver.switchTo().frame(0);
		Actions act = new Actions(driver);
		WebElement wb = driver.findElement(By.id("age"));
		act.moveToElement(wb).build().perform();
		String expres = "We ask for your age only for statistical purposes.";
		String tooltiptext = wb.getAttribute("title");
		System.out.println(tooltiptext);
		Assert.assertEquals(tooltiptext, expres,"invalid");
	}
}
