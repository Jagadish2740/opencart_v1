package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.My_AccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_login_data_driven extends BaseClass{

	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups="Datadriven")
	public void verify_login_ddt(String email, String pwd, String exp) {

		logger.info("****** Starting TC_003 login test *********");
		try {
			Homepage hp = new Homepage(driver);
			hp.clickMyAccount();
			hp.clickLogin();



			Loginpage lp = new Loginpage(driver);
			lp.setEmail(email);
			lp.setPass(pwd);
			lp.clicklogin();


			My_AccountPage map = new My_AccountPage(driver);

			boolean page =map.isMyAccountPageExits();

			if(exp.equalsIgnoreCase("Valid")) {
				if(page==true) {
					Assert.assertTrue(true);
					map.cliclogout();
				}
				else {
					Assert.assertTrue(false);
				}

			}
			if(exp.equalsIgnoreCase("Not Valid")) {
				if(page==true) 
				{
					map.cliclogout();
					Assert.assertTrue(false);
				}

				else 
				{
					Assert.assertTrue(true);
				}

			}
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("****** Finished TC_003_login_Test ****");
	}

}
