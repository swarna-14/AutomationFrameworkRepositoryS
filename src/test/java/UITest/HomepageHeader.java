package UITest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HomepageHeader {

	WebDriver driver;
	@Test
	public void countInteractionMenu() throws Exception
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
		
		WebElement wb= driver.findElement(By.xpath("//a[contains(text(),'Interaction')]"));
		Actions act=new Actions(driver);
		act.moveToElement(wb).build().perform();
		 ArrayList<WebElement> submenu=new ArrayList<WebElement>(driver.findElements(By.xpath("//a[contains(text(),'Interaction')]")));
		 System.out.println(submenu.indexOf(1));
		// submenu.size();
		// System.out.println(submenu.size());
		List<WebElement> subm= driver.findElements(By.xpath("//a[contains(text(),'Registration')]"));
		System.out.println(subm.size());
	}
}
