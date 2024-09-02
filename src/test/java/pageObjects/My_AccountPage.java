package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class My_AccountPage extends BasePage{

	public My_AccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement heading;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logout;
	
	public boolean isMyAccountPageExits() {
		try {
		return(heading.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	
	
	public void cliclogout() {
		logout.click();
	}

}



