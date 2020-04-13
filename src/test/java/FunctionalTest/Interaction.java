package FunctionalTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Interaction {

	WebDriver driver;
	
	@Test(priority=0)
	public void draganddrop() throws Exception
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
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[2]/div[1]/ul/li[2]/a/h2")).click();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement destination=driver.findElement(By.id("droppable"));
		Actions act= new Actions(driver);
		act.clickAndHold(source).moveToElement(destination).release().build().perform();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
	}
	
	@Test(priority=1)
	public void shoppingcartdemo() throws InterruptedException
	{
		
	driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[1]/div[1]/ul/li[5]/a")).click();
	Thread.sleep(3000);
	driver.switchTo().frame(3);
	WebElement srcelement1=driver.findElement(By.xpath("//li[contains(text(),'Lolcat Shirt')]"));
	driver.findElement(By.xpath("//h2[@id='ui-id-3']")).click();
	WebElement srcelement2=driver.findElement(By.xpath("//li[@class='ui-draggable ui-draggable-handle'][contains(text(),'Black Leather')]"));
	WebElement dstelement=driver.findElement(By.xpath("//div[@class='ui-widget-content']"));
	Actions act1=new Actions(driver);
	act1.clickAndHold(srcelement1).moveToElement(dstelement).release().build().perform();
	act1.clickAndHold(srcelement2).moveToElement(dstelement).release().build().perform();
	
	}
}
