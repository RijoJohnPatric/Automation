package coreLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	public static WebDriver driver;
	
		//*****************************************************************************
		// Function	Name	  : initialze
		// Summary	          : Chrome driver Initialization Function
		// Author             : Rijo J Patric
		// Date				  : 22-08-2019 
		// Last Modified Date :
		// Last Modified Name : 
		//*****************************************************************************
	
	@BeforeTest 
	public void initialze()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Sel_Workspace\\MavenPro\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://mediwarecloud.com/MediwareQC/login.aspx");
		driver.manage().window().maximize();
		
	}
	
	
	
	

}
