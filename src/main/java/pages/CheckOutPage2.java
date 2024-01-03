package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutPage2 extends TestBase
{ 
	@FindBy(xpath="//span[@class='title']") private WebElement chekcOutpage2lable; 
	@FindBy(xpath="//button[@name='finish']") private WebElement finishBtn;
public CheckOutPage2()
{
	PageFactory.initElements(driver,this);
}
public String verifyLable()
{
	return chekcOutpage2lable.getText();
}
public String clickOnFinishBtn()
{
	finishBtn.click();
	return driver.getCurrentUrl();
}


}
