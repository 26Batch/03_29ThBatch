package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutComplete extends TestBase
{ 
	@FindBy(xpath="//span[text()='Checkout: Complete!']") private WebElement chekcOutzcompletelable; 
	@FindBy(xpath="///img[@alt='Pony Express']") private WebElement ponyImg;
	@FindBy(xpath="//h2[@class='complete-header']") private WebElement headerText; 
	@FindBy(xpath="//div[@class='complete-text']") private WebElement completeText;
	@FindBy(xpath="//button[@name='back-to-products']") private WebElement backProductBtn; 
	public CheckOutComplete()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyURL()
	{
		return driver.getCurrentUrl();
	}
	public boolean verifyImg()
	{
		return ponyImg.isDisplayed();
	}


}
