package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.CheackOutPage1;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshot;

public class CheackOutPage1Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	Cart_Page cart;
	CheackOutPage1 check1;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization(); 
		login=new LoginPage();
		invent=new Inventory_Page();
		cart=new Cart_Page();
		check1=new CheackOutPage1();
		login.loginToApplication(); 
		invent.add6Product();
		invent.clickcartIcon();
		cart.clickOnCheckoutBtn();
	} 
	@Test
	public void verifyURLTest()
	{
		String expURL="https://www.saucedemo.com/checkout-step-one.html";
		String actURL=check1.verifyURL();
		Assert.assertEquals(expURL,actURL);
	}
	@Test
	public void inputInfoTest()
	{
		String expURL="https://www.saucedemo.com/checkout-step-two.html"; 
		String actURL=check1.inputInfo();
		Assert.assertEquals(expURL,actURL);
	}
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.screenshot(it.getName());
		}
		driver.close();
	}
	

}
