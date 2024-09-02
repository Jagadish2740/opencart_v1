package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.My_AccountPage;
import testBase.BaseClass;

public class TC_002_Login_Test extends BaseClass{
	
	
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		
		logger.info("******* Starting TC_002_login_Test ********");
		try {
		Homepage hp = new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		
		Loginpage lp = new Loginpage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPass(p.getProperty("password"));
		lp.clicklogin();
		
		
		My_AccountPage map = new My_AccountPage(driver);
		
		boolean page =map.isMyAccountPageExits();
		Assert.assertTrue(page); 
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("******* Finished TC_002_login_Test ********");
		
		
		
		
		
		;
		
	}
	

}
