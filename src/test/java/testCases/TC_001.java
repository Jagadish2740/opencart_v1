package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Account_registration;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC_001 extends BaseClass{
	@Test(groups={"Regression","Master"})
	public void account_registration(){

		logger.info("*********** Starting TC_001 test ***************");


		try {


			Homepage hp = new Homepage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account");
			hp.clickRegister();
			logger.info("Clicked on Register");

			Account_registration ac = new Account_registration(driver);
			logger.info("Providing Customer Details.....");
			ac.name(randomString().toUpperCase());
			ac.lname(randomString().toUpperCase());
			ac.mail(randomString()+"@gmail.com");
			ac.mobile(randomnum());
			String password =randomAlphanum();
			ac.pass1(password);
			ac.pass2(password);
			ac.agre();
			ac.butt();
			logger.info("Validating expected Message......");
			String confmsg= ac.getCnfmsg();
			if(confmsg.equals("Your Account Has Been Created!"))
					{
				Assert.assertTrue(true);
			}
			else
   			{
				logger.error("Test Failed.......");
				logger.debug("Debug logs........");
				Assert.assertTrue(false);
			}
			
			
			//Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		}
		catch(Exception e) 
		{
	
			Assert.fail();
		}
		
		logger.info("********* Finished TC_001 Test ***********");

	}

}
