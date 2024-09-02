package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends BasePage {

	public Loginpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	@FindBy(xpath="//input[@value='Login']")
	WebElement login;
	
	public void setEmail(String mail) {
		email.sendKeys(mail);
	}
	public void setPass(String pass) {
		password.sendKeys(pass);
	}
	public void clicklogin() {
		login.click();
	}

}
