package TestUtil;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class CommonUtils {
	
	static WebDriver driver;
	
	public void waitdriver()
	{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
	}
	public static void maximize()
	{
		driver.manage().window().maximize();
	}
	

}
