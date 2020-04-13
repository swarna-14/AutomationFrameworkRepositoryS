package DataDrivenTesting;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationPage {

	WebDriver driver;
	
	@Test(priority=0)
	public void registration() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
    	driver= new ChromeDriver();
    	driver.manage().window().maximize();
    	
    	driver.get("http://www.way2automation.com/demo.html");
    	String parent=driver.getWindowHandle();
	 	driver.findElement(By.xpath("//a[contains(text(),'Registration')]")).click();
		Thread.sleep(3000);
		
		Set<String> set=driver.getWindowHandles();
		System.out.println(set.size());
		System.out.println(parent);
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{
			String child=it.next();
			if(!parent.equals(child))
			{
				driver.switchTo().window(child);
				System.out.println(driver.switchTo().window(child).getTitle());
			}
		}
		
		
		Thread.sleep(3000);
	}
	
	@DataProvider
	public static Object[][] EnterData() throws Exception
	{
		Getdata obj=new Getdata();
		Object data[][]= obj.gettingdata("SignUp");
		return data;
		
	}
	
	@Test(dataProvider="EnterData",priority=1)
	public void setData(String Name, String Phone, String Email, String City, String Username,String Password) throws Exception
	{
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(Name);
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(Phone);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Email);
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(City);
		driver.findElement(By.xpath("//div[@id='load_box']//input[@name='username']")).sendKeys(Username);
		driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[7]/input//div[@id='load_box']//input[@name='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//div[@id='load_box']//input[@class='button']")).click();
		Thread.sleep(2000);
		
	}
}
