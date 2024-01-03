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
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class Inventory_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException, InterruptedException
	{
		initialization(); 
		login=new LoginPage();
		invent=new Inventory_Page();
		login.loginToApplication();
	}
	@Test(enabled=true,groups = {"Retesting"})
	public void verifyProductLableTest() throws EncryptedDocumentException, IOException
	{
		String expLable=ReadData.readExcel(0,3);//Products(0,3)
		String actLable=invent.verifyProductLable();
		Assert.assertEquals(expLable,actLable);
	}
	@Test(enabled=true,groups = {"Sanity"})
	public void verifyTwitterLogoTest()
	{
		boolean result=invent.verifyTwitterLogo();
		Assert.assertEquals(result,true);
		Reporter.log("Visibility of TwitterLogo" + result);
	}
	@Test(enabled=true,groups = {"Sanity","Regreesion"},invocationCount = 3)
	public void add6ProductTest() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0,4);//6(0,4)
		String actCount=invent.add6Product();
		Assert.assertEquals(expCount,actCount);
	}
	@Test(enabled=true,groups = {"Sanity","Regreesion"})
	public void remove2ProductTest() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0,5);//4(0,5)
		String actCount=invent.remove2Product();
		Assert.assertEquals(expCount,actCount);
		Reporter.log("Number of product after removing = " + actCount);
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
