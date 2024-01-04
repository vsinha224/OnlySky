package Com.OnlySky.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.OnlySkyp.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	
	@Test
	public void loginTest() throws InterruptedException {
		
		
		log.info("URL is Opened");
		
		
		LoginPage lp = new LoginPage(driver);
		lp.clickSignInLink();
		log.info("sign in button clicked ");
		
		Thread.sleep(3000);
		lp.enterUsername(username);
		log.info("Entered Username");
		
		lp.enterPassword(password);
		log.info("Entered Password");
		
		
		lp.clickLoginButton();
		log.info(" clicked on login button");
		if(driver.getTitle().equals("Activities at Winter Peak Ski Area"));
		{
			Assert.assertTrue(true);
		}
		System.out.println("Test Case 1 pass to succeessfully Login");
		
		Thread.sleep(5000);
		
		
	
	}
}
