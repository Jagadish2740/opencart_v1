package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Account_registration extends BasePage {

	public Account_registration(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement fname;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lname;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement phone;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement pass;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement cnfpass;
	@FindBy(xpath="//input[@name='agree']")
	WebElement agree;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement button;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement cnfmsg;
	
	
	public void name(String name) {
		fname.sendKeys(name);
	}
	public void lname(String name1) {
		lname.sendKeys(name1);
	}
	public void mail(String mail) {
		email.sendKeys(mail);
	}
	public void mobile(String phone1) {
		phone.sendKeys(phone1);
	}
	public void pass1(String pass1) {
		pass.sendKeys(pass1);
	}
	public void pass2(String pass2) {
		cnfpass.sendKeys(pass2);
	}
	
	public void agre() {
		agree.click();
	}
	
	public void butt() {
		button.click();
	}
	
	public String getCnfmsg() {
		try {
			return(cnfmsg.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}
	}
	
	

}
