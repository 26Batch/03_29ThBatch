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
import pages.Cart_Page;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class Cart_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	Cart_Page cart;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException, InterruptedException
	{
		initialization(); 
		login=new LoginPage();
		invent=new Inventory_Page();
		cart=new Cart_Page();
		login.loginToApplication(); 
		invent.add6Product();
		invent.clickcartIcon();
	} 
	@Test (enabled=true,groups = {"Sanity"})
	public void verifyCartPageUrlTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,6);//https://www.saucedemo.com/cart.html(0,6)
		String actURL=cart.verifyCartPageUrl();
		Assert.assertEquals(expURL, actURL); 
		Reporter.log("Current Page URL of Cart_Page = " + actURL);
	}
	@Test(enabled=true,groups = {"Retesting"})
	public void verifyCartPageLableTest() throws EncryptedDocumentException, IOException
	{
		String expText=ReadData.readExcel(0,7);//Your Cart(0,7)
		String actText=cart.verifyCartPageLable();
		Assert.assertEquals(expText,actText);
		Reporter.log("Cart Page lable = " + actText);
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
