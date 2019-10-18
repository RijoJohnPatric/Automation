package appPages;

import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import coreLib.ComFunc;

public class Registration 
{

	 WebDriver driver;
	
	 By Menu = By.id(ComFunc.readElementPropertyFile("MENU_HOVER_ID"));
	 By NewReg = By.xpath(ComFunc.readElementPropertyFile("NEW_REGISTRATION_XP"));
	 By Salutation = By.id(ComFunc.readElementPropertyFile("SALUTATION_ID"));
	 By FirstName = By.id(ComFunc.readElementPropertyFile("FIRST_NAME_ID"));
	 By MiddleName = By.id(ComFunc.readElementPropertyFile("MIDDLE_NAME_ID"));
	 By SurName = By.id(ComFunc.readElementPropertyFile("SURNAME_ID"));
	 By Gender = By.id(ComFunc.readElementPropertyFile("GENEDER_ID"));
	 By Emirates = By.id(ComFunc.readElementPropertyFile("EMIRATES_ID"));
	 By Nationality = By.id(ComFunc.readElementPropertyFile("NATIONALITY_ID"));
	 By VisaStatus = By.id(ComFunc.readElementPropertyFile("VISA_STATUS_ID"));
	 By CountyOfRes = By.id(ComFunc.readElementPropertyFile("COUNTRY_OF_RES_ID"));
	 By Doctor = By.id(ComFunc.readElementPropertyFile("DOCTOR_ID"));
	 By AddDoc = By.id(ComFunc.readElementPropertyFile("ADD_DOC_ID"));
	 
	 
	public Registration(WebDriver driver)
	{
		this.driver= driver;
	}
	public void patientRegistration() throws InterruptedException
	{
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(Menu)).perform();
		
		driver.findElement(NewReg).click();
		
		//Select Salution
		ComFunc.dropDownByVisibleText(driver.findElement(Salutation), "Mr");
		
		//Enter First name, Middle Name and Surname
		driver.findElement(FirstName).sendKeys(ComFunc.readDataPropertyFile("FIRSTNAME"));
		driver.findElement(MiddleName).sendKeys(ComFunc.readDataPropertyFile("MIDDLENAME"));
		driver.findElement(SurName).sendKeys(ComFunc.readDataPropertyFile("SURNAME"));		
		
		//Select Gender
		ComFunc.dropDownByValue(driver.findElement(Gender), "M");
		
		//Enter random Date Of Birth
		class RandomDateOfBirth 
		{
		    public void main(String[] args) 
		    {
		        GregorianCalendar gc = new GregorianCalendar();
		        int year = randBetween(1900, 2010);
		        gc.set(gc.YEAR, year);
		        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
		        gc.set(gc.DAY_OF_YEAR, dayOfYear);
		        System.out.println(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));

		    }

		    public int randBetween(int start, int end) 
		    {
		        return start + (int)Math.round(Math.random() * (end - start));
		    }
		}
		
		driver.findElement(Emirates).sendKeys(ComFunc.readDataPropertyFile("EMIRATES"));
		driver.findElement(Nationality).sendKeys(ComFunc.readDataPropertyFile("NATIONALITY"));
		ComFunc.dropDownByValue(driver.findElement(VisaStatus), "V003");
		driver.findElement(Doctor).sendKeys("all");
//		Actions actions = new Actions(driver);
//		action.moveToElement()
		driver.findElement(Doctor).sendKeys(Keys.DOWN);
		driver.findElement(Doctor).sendKeys(Keys.ENTER);
		driver.findElement(AddDoc).click();	
		
	}
	

}
