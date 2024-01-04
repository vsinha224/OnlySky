package Com.OnlySky.testCases;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import testrail.APIException;


public class TC_book_4 extends TC_LoginTest_001 {
	@Test(description="Redirect to the BBI option from the dashboard")
	public void book() throws MalformedURLException, IOException, APIException{
	try {
		log.warn("Going to Book By Instructor options");
		
		// to redirect in dashboard
		if(driver.getTitle().equals("Winter Peak Ski Area")) {
			System.out.println("No action perform on menu");
			
		}
		else {
		Thread.sleep(2000);
		driver.findElement(By.className("dropdown-toggle")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Dashboard']")).click();
		System.out.println("Action performed to get dashboard");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[2]/a")).click();
		
		Thread.sleep(3000);
		
		// To click on book now in book instutor page
//		driver.findElement(By.xpath("//*[@id=\"update-content\"]/div[2]/div[1]/div/div[4]/a[1]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"update-content\"]/div[2]/div[1]/div/div[4]/a[1]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.id("date_pick")).click();//sendKeys("2024-01-02");
		Thread.sleep(4000);		
		
		//Try to select day
		 driver.findElement(By.xpath("//td[@class='day'][normalize-space()='11']")).click();
		
		driver.findElement(By.id("activity-pick")).click(); // to click on activity 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//option[@value='92e8baf8']")).click(); // pick activity
		
		Thread.sleep(10000);
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"start-time\"]")).click();// click on start - time
		
		
			driver.findElement(By.xpath("//option[@value='720']")).click();
			
				
		Thread.sleep(2000);
		WebElement available =null;
		if(available ==driver.findElement(By.xpath("//*[@id=\"availability\"]/div[3]/div[2]/label/span"))){
			available.isDisplayed();
			available.click();
			System.out.println("As 1st slot is not available so time is also not showing");
		}else {
			System.out.println("2nd slot time selecting and moving forward for booking");
			driver.findElement(By.xpath("(//span[@class='checkmark lesson-time'])[1]")).click();
		}
		//driver.findElement(By.xpath("//*[@id=\"availability\"]/div[3]/div[2]/label/span")).click();
		
		driver.findElement(By.id("begin-booking")).click(); // book button
		
		Thread.sleep(4000);
		
		// start filling datils on 1st popup
		driver.findElement(By.id("first_name")).sendKeys("Jane");
		driver.findElement(By.id("last_name")).sendKeys("Doe");
		driver.findElement(By.id("email")).sendKeys("dhruva@gmail.com");
		driver.findElement(By.id("phone_number")).sendKeys("9098989098");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		
		Thread.sleep(10000);
		// participate details
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Dhruva");
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Pathak");
		Thread.sleep(1000);
		driver.findElement(By.id("birth_month")).sendKeys("12");
		Thread.sleep(1000);
		driver.findElement(By.id("birth_day")).sendKeys("31");
		Thread.sleep(1000);
		driver.findElement(By.id("birth_year")).sendKeys("1995");
		
		Thread.sleep(2000);
		driver.findElement(By.id("gender")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//option[@value='Male']")).click();
		
		driver.findElement(By.xpath("(//button[normalize-space()='Continue'])[1]")).click();// click on continue button
		
		//Itenary summery popup
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='tip-10']")).click();// to click on tip 10
		
		Thread.sleep(5000);
		driver.findElement(By.id("checkout-bookinst")).click();
		Thread.sleep(2000);
		
		//Checkout page
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("dhruva@gmail.com");
		
		// entering credit card details
		
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		actions.sendKeys("4242424242424242").perform();
		Thread.sleep(3000);
		actions.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		actions.sendKeys("02").perform();
		Thread.sleep(3000);
		actions.sendKeys("26").perform();
		Thread.sleep(3000);
		actions.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		actions.sendKeys("837").perform();
		Thread.sleep(3000);	
		actions.sendKeys(Keys.TAB).build().perform();
		actions.sendKeys("Dhruva").perform();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='SubmitButton-IconContainer']")).click();
		
//		driver.findElement(By.xpath("//a[normalize-space()='Complete']")) // if present in success page
		Thread.sleep(7000);
		//driver.findElement(By.xpath("//a[normalize-space()='Complete']")).click(); // to click on complete button on payment successfull page
		driver.findElement(By.xpath("//a[normalize-space()='Complete']")).click();
		// To get the thank you title and print success msg
		String acttitle=driver.getTitle();
		String exptitle = "Thank You!";
		if(acttitle.equalsIgnoreCase(exptitle)) {
			System.out.println("Payment made successFully ");
			
		}else {
			System.out.println("Payment not made successfull");
		}
		
	}
	catch(Exception ex) {
		tr.runtestcase("6","8",5);
		log.warn("error occured: "+ex.getMessage());
        Assert.fail("Caught an exception: " + ex.getMessage());
	}
		
	}


}
