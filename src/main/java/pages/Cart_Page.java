package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Cart_Page extends TestBase
{
	@FindBy(xpath="//span[text()='Your Cart']") private WebElement cartPageLable;
	@FindBy(xpath="//button[@id='checkout']") private WebElement checkoutBtn;
	public Cart_Page()
	{
		PageFactory.initElements(driver,this);
	} 
	public String verifyCartPageUrl()
	{
		return driver.getCurrentUrl();
	} 
	public String verifyCartPageLable()
	{
		return cartPageLable.getText();
	}
	public void clickOnCheckoutBtn()
	{
		checkoutBtn.click();
	}
	

}
