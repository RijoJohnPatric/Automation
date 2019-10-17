package coreLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ComFunc extends BaseClass
{
		//Function to read Element Property file 
		public static String readElementPropertyFile(String webElem)
		{
			//********************************************************************************
			// Function	Name	  : readElementPropertyFile
			// Summary	          : To get element from Element.properties
			// Author             : Rijo J Patric
			// Date				  : 22-08-2019
			// Parameter 1		  : webElem - Variable name of Element
			// Last Modified Date :
			// Last Modified Name : 
			//********************************************************************************			
						
			Properties prop = new Properties();
			File file = new File("F:\\Sel_Workspace\\MavenPro\\configs\\Element.properties");
			String strData = "";
			FileInputStream fileInput = null;
			
			try 
			{
				fileInput = new FileInputStream(file);
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			
			try
			{
				prop.load(fileInput);
				strData = prop.getProperty(webElem);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
			return strData;
		}
		
		//Function to read Data Property file 		
		public static String readDataPropertyFile(String testData)
		{
			//********************************************************************************
			// Function	Name	  : readDataPropertyFile
			// Summary	          : To get element from Element.properties
			// Author             : Rijo J Patric
			// Date				  : 22-08-2019
			// Parameter 1		  : webElem - Variable name of Element
			// Last Modified Date :
			// Last Modified Name : 
			//********************************************************************************
			
			Properties prop = new Properties();
			File file = new File("F:\\Sel_Workspace\\MavenPro\\configs\\Data.properties");
			String strData ="";
			FileInputStream fileInput = null;
			
			try
			{
				fileInput = new FileInputStream(file);
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			
			try
			{
				prop.load(fileInput);
				strData = prop.getProperty(testData);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
			return(strData);
		}
		
		
		//Function Drop down by Select by Index
		public static void dropDownByIndex(WebElement ele, int i)
		{
			Select select = new Select(ele);
			select.selectByIndex(i);		
		}
		
		//Function Drop down by Select by Visible Text
		public static void dropDownByVisibleText(WebElement ele, String text)
		{
			Select select = new Select(ele);
			select.selectByVisibleText(text);		
		}
		
		//Function Drop down by Select by Value
		public static void dropDownByValue(WebElement ele, String value)
		{
			Select select = new Select(ele);
			select.selectByValue(value);	
		}
		
		//Fucntion for Assertion
		public static void stringAssert(WebElement asserEle, String expText)
		{
			String actualValue = asserEle.getText();
			Assert.assertEquals(actualValue, expText);
		}
	}


