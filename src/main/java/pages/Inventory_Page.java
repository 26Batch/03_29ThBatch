package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.HandleDropDwon;

public class Inventory_Page extends TestBase
{
	//Object Repository
	//add xpath
	@FindBy(xpath="//span[text()='Products']") private WebElement productLable;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backpackProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement boltTShirtProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement jacketProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement onesieProduct;
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement TShirtRedProduct;
	//remove xpath 
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement backpackRemoveProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement bikeLightRemoveProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement boltTShirtRemoveProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement jacketRemoveProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-onesie']") private WebElement onesieRemoveProduct;
	@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement RedTShirtRemoveProduct;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement cartIcon;
	@FindBy(xpath="//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement linkdInLogo;	
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement productDropDown;	
	public Inventory_Page()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyProductLable()
	{
		return productLable.getText();
	}
	public boolean verifyTwitterLogo()
	{
		return twitterLogo.isDisplayed();
	}
	public String add6Product()
	{
		HandleDropDwon.handleSelectClass(productDropDown,"Price (low to high)");
		backpackProduct.click();
		bikeLightProduct.click();
		boltTShirtProduct.click();
		jacketProduct.click();
		onesieProduct.click();
		TShirtRedProduct.click();
		return cartCount.getText();
	}
	public String remove2Product()
	{
		add6Product();
		backpackRemoveProduct.click();
		bikeLightRemoveProduct.click();
		return cartCount.getText();	
	}
	public void clickcartIcon()
	{
		cartIcon.click();
	}
}









