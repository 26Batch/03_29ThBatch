package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheackOutPage1 extends TestBase
{
	@FindBy(xpath="//input[@id='first-name']") private WebElement firstNameTxtBox;
	@FindBy(xpath="//input[@id='last-name']") private WebElement lastNameTxtBox;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement zipCodeTxtBox;
	@FindBy(xpath="//input[@id='continue']") private WebElement continueBtn;
	public CheackOutPage1()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyURL()
	{
		return driver.getCurrentUrl();
	}
	public String inputInfo()
	{
		firstNameTxtBox.sendKeys("Harry");
		lastNameTxtBox.sendKeys("Potter");
		zipCodeTxtBox.sendKeys("411098");
		continueBtn.click();
		return driver.getCurrentUrl();
	}
}
