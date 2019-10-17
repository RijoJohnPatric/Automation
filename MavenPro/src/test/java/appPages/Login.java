package appPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreLib.ComFunc;

public class Login
	{
		WebDriver driver;
		
		//Declaration of WebElements
		By UserName = By.id(ComFunc.readElementPropertyFile("USERNAME_OP_ID"));
		By PassWord = By.id(ComFunc.readElementPropertyFile("PASSWORD_OP_ID"));
		By LoginBtn = By.id(ComFunc.readElementPropertyFile("LOGIN_BUTTON_ID"));
		By CounterOP = By.id(ComFunc.readElementPropertyFile("OP_COUNTER_ID"));
		By SelectBtn = By.xpath(ComFunc.readElementPropertyFile("SELECT_COUNTER_BUTTON_XPATH"));
		By UserAssert = By.id(ComFunc.readElementPropertyFile("ASSERT_OPUSER_ID"));
		
		//Create constructor
		public Login(WebDriver driver)
		{
			this.driver = driver;
		}
		
		//Function for Login Credential
		public void UserLogIn(String strUserName, String strPassword)
		{
			driver.findElement(UserName).sendKeys(strUserName);
			driver.findElement(PassWord).sendKeys(strPassword);
			driver.findElement(LoginBtn).click();
		}
		
		//Function for selecting Counter
		public void SelectCounter()
		{
			String counterOP = ComFunc.readDataPropertyFile("COUNTER_OP_VALUE");
			ComFunc.dropDownByValue(driver.findElement(CounterOP), counterOP);
			driver.findElement(SelectBtn).click();	
		}
		
		//Assertion 
		public void opUserAssertion()
		{
			ComFunc.stringAssert(driver.findElement(UserAssert), ComFunc.readDataPropertyFile("USERNAME_PRINT"));
		}
	}
