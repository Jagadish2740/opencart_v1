package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage {

	public Homepage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement register;
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement login;
	
	 public void clickMyAccount() {
		 lnkMyaccount.click();
	 }
	 
	 public void clickRegister() {
		 register.click();
	 }
	 public void clickLogin() {
		 login.click();
	 }
}
