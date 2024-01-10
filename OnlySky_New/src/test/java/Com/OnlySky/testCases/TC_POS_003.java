package Com.OnlySky.testCases;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import testrail.APIException;


public class TC_POS_003 extends TC_LoginTest_001 {
	@Test(description="Redirect to the POS option from the dashboard")
	public void pos() throws MalformedURLException, IOException, APIException{
	try {
		log.warn("Going to POS options");
		
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
		Thread.sleep(1000);
		WebElement posmenu = driver.findElement(By.xpath("//*[@id=\"navbarNav\"]/ul/li[4]/a"));
		posmenu.click();// to click on POS button in dashboard
		Thread.sleep(1000);
		WebElement anon = driver.findElement(By.xpath("//a[normalize-space()='Anonymous Checkout']"));
		anon.click(); // to click on anonymous button
		Thread.sleep(1000);
		
		// Adding participates
		if(driver.findElement(By.xpath("//td[normalize-space()='Anonymous Guest']")).isDisplayed()){
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[2]/table/tbody/tr/td[5]/a[2]	")).click(); // Deleting anonymus defualt showing
			Thread.sleep(2000);
			System.out.println(driver.findElement(By.id("full_name")).getText() + "Guest showing by default");
			driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
			
		}else {
			System.out.println("Good to go with new deatils added");
		}
		
		Thread.sleep(3000);
		WebElement fname = driver.findElement(By.id("first_name"));
		fname.sendKeys("Jhon");
		WebElement lname = driver.findElement(By.id("last_name"));
		lname.sendKeys("Jane");
		driver.findElement(By.id("birth_month")).sendKeys("12");
		driver.findElement(By.id("birth_day")).sendKeys("31");
		driver.findElement(By.id("birth_year")).sendKeys("1995");
//		driver.findElement(By.id("group_size")).sendKeys("1"); // no need to use 
		
		
		
		// check the toggle is enabled or not
//		if(driver.findElement(By.xpath("//tbody//span[@class='slider round']")).isEnabled()) {
//			
//			System.out.println("Toggle is enable no action performed");
//		}else {
//			driver.findElement(By.xpath("//tbody//span[@class='slider round']")).click();
//			System.out.println("Toggle is not enabled and clicked on it");
//			
//		}
		
		driver.findElement(By.xpath("//button[@type='submit']")).submit();// to click on Add Submit button
		
		driver.findElement(By.id("date-picker")).click();
		driver.findElement(By.className("today")).click();// selected date
		
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id=\"products\"]/div[2]/div[3]/div[1]/div")).click(); // Womens Wednesday
//		WebElement wednesday = null;
//		if(wednesday == driver.findElement(By.xpath("//*[@id=\\\"products\\\"]/div[2]/div[3]/div[1]/div"))) {
//			wednesday.isDisplayed();
//			wednesday.click();
//			System.out.println("first condition matched");
//			
//		}else {
//			driver.findElement(By.xpath("//button[normalize-space()='Group Ski Lesson - 90 Minute']")).click();
//			System.out.println("2nd condition matched");
//		}
		
		driver.findElement(By.xpath("//*[@id=\"products\"]/div[2]/div[3]/div/div/button")).click();
		
		Thread.sleep(1000);
		
		
//		WebElement slot1 = driver.findElement(By.xpath(""))
		
		
		WebElement slot1 = driver.findElement(By.xpath("//*[@id=\"a1cc79ff\"]/form/div[2]/div/div[1]/label/a"));
		slot1.click();
		Thread.sleep(2000);
//		
		
		Thread.sleep(2000);
		// click on add to cart button
		driver.findElement(By.xpath("//*[@id=\"a1cc79ff\"]/form/div[3]/div/a[2]")).click();
		
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"itinerary\"]/div[3]/div/a[1]")).click(); //click on finalize button
		Thread.sleep(4000);
		
		// Enter user details while making an order
		driver.findElement(By.xpath("(//input[@id='first_name'])[2]")).sendKeys("Dhruva"); 
		driver.findElement(By.xpath("(//input[@id='last_name'])[2]")).sendKeys("Pathak");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("dhruva@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"phone_number\"]")).sendKeys("9090909090");
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		
		System.out.println("Test Run Successfull");
		
		
		
		
		
		
		
	}catch(Exception ex) {
		tr.runtestcase("6","8",5);
		log.warn("error occured: "+ex.getMessage());
        Assert.fail("Caught an exception: " + ex.getMessage());
	}
		
	}


}
