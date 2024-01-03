package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class LoginPageTest extends TestBase
{
	LoginPage login;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException, InterruptedException
	{
		initialization(); 
		login=new LoginPage();
	}
	@Test (enabled = true,priority = 1,groups = {"Retesting"})
	public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0,0); //Swag Labs(0,0)
		String actTitle=login.verifyTitleOfApplication();
		Assert.assertEquals(expTitle, actTitle);
	}
	@Test(enabled = true,priority = 3,groups = {"Sanity"})
	public void verifyURLOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL= ReadData.readExcel(0,1);//https://www.saucedemo.com/(0,1) 
		String actURL=login.verifyURLOfApplication();
		Assert.assertEquals(actURL,expURL);
	}
	@Test(enabled = true,priority = 2,groups = {"Sanity","Regreesion"})
	public void loginToApplicationTest() throws IOException
	{
		String expURL=ReadData.readExcel(0,2); //https://www.saucedemo.com/inventory.html(0,2)
		String actURL=login.loginToApplication(); 
		Assert.assertEquals(expURL, actURL); 
		Reporter.log("After Login inventory Page should be come = " + actURL);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.screenshot(it.getName());
		}
		driver.close();
	}

}
