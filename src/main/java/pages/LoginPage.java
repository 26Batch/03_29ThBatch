package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase
{ 
	//object repository 
	@FindBy(xpath="//input[@id='user-name']") private WebElement userNameTxtBox; 
	@FindBy(xpath="//input[@id='password']") private WebElement passwordTxtBox; 
	@FindBy(xpath="//input[@id='login-button']") private WebElement loginBtn;
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}//constructor 
	public String loginToApplication() throws IOException
	{
		userNameTxtBox.sendKeys(ReadData.readPropertyFile("Username"));
		passwordTxtBox.sendKeys(ReadData.readPropertyFile("Password"));
		loginBtn.click();
		return driver.getCurrentUrl();	
	}
	public String loginToApplicationMultiCreds(String un,String pass)
	{
		userNameTxtBox.sendKeys(un);
		passwordTxtBox.sendKeys(pass);
		loginBtn.click();
		return driver.getCurrentUrl();
	}
	public String verifyTitleOfApplication()
	{
		return driver.getTitle();
	}
	public String verifyURLOfApplication()
	{
		return driver.getCurrentUrl();
	}
}
