package appTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import appPages.Login;
import appPages.Registration;
import coreLib.BaseClass;
import coreLib.ComFunc;

public class TestScript extends BaseClass
	{
	
	//Initialization of objects for Login 
	public Login objLogin;
	public Registration objReg;
	
	
	//Creation of Object 
	@BeforeClass
	public void Objects()
	{
		objLogin = new Login(driver);
		objReg = new Registration(driver);
	}
	
	//Test case for Login Credential
		@Test(priority = 0)
		public void runUserLogin()
		{
			String strUserName = ComFunc.readDataPropertyFile("USERNAME_OP");
			String strPassword = ComFunc.readDataPropertyFile("PASSWORD_OP");
			
			objLogin.UserLogIn(strUserName, strPassword);
			objLogin.SelectCounter();
			objLogin.opUserAssertion();
			System.out.println("Assertion Passed");
		}
		
		@Test(priority = 1)
		public void runRegistration() throws InterruptedException
		{
			objReg.patientRegistration();
		}
	}


