package Com.OnlySky.testCases;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import testrail.APIException;


import java.io.IOException; 
import java.net.MalformedURLException;

public class TC_StoreFront_002 extends TC_LoginTest_001{
	
	@Test(description = "Book a Private Ski Lesson for 1 guest and complete the booking.")
    public void bookPrivateSki() throws InterruptedException, MalformedURLException, IOException, APIException  {
    	try {
    	log.warn("going to book ski");
    	Thread.sleep(2000);
    	
    	driver.findElement(By.className("activity-name")).click();

        driver.findElement(By.className("today")).click();  //select the today date
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div[1]/div[1]/select")).click();
        
        
        Thread.sleep(2000);
        //WebElement secondOption = driver.findElement(By.xpath("(*//select)[1]/option[2]"));
      //  WebElement secondOption = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/div[1]/div[1]/select/option[2]"));
        WebElement secondOption = driver.findElement(By.xpath("(//option[@value='f10022c0'][contains(text(),'9:00 AM')])[4]"));
        secondOption.click();
        
        Thread.sleep(2000);
       // driver.findElement(By.className("lesson-time-select")).click();
        
        
         // Incremental button
        driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(3) > "
        		+ "div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > "
        		+ "div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > "
        		+ "div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > "
        		+ "div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > a:nth-child(3)") ).click();
        
        
        Thread.sleep(2000);
        
         driver.findElement(By.xpath("//body//div//div//div//div//div//div//div//div"
         		+ "//div//div//div//div//div//div//div//button[contains(text(),"
         		+ "'+ Add to cart')]")).click();
         Thread.sleep(15000);
         
         //add switch to switch on popup 
         

         driver.findElement(By.id("first_name")).sendKeys("jane");
         driver.findElement(By.id("last_name")).sendKeys("jane");
         driver.findElement(By.id("birth_month")).sendKeys("10");
         driver.findElement(By.id("birth_day")).sendKeys("15");
         driver.findElement(By.id("birth_year")).sendKeys("2009");
         
         WebElement genderSelect = driver.findElement(By.id("gender"));

         // Wrap the select element with Select class
         Select select = new Select(genderSelect);

         // Select the "Male" option by value
         select.selectByValue("Male");
         driver.findElement(By.xpath("(//a[contains(text(),'Continue')])")).click();
         Thread.sleep(1000);
         driver.findElement(By.xpath("(//a[contains(text(),'checkout')])")).click();
         
    	 log.warn("clicking next button");

         WebElement nextbtn= driver.findElement(By.xpath("//*[@id=\"ecomm3-checkout\"]/div[1]/div/div/div[4]/div[2]/div/div[3]/button")); 
         Thread.sleep(2000);
         JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
         jsExecutor.executeScript("arguments[0].click();", nextbtn);
         Thread.sleep(2000);

         WebElement sendbtn= driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div/div/div[3]/div[2]/div/div[1]/div/div/div[2]/a[2]"));
          
     	 log.warn("clicking send button");

         jsExecutor = (JavascriptExecutor) driver;
         jsExecutor.executeScript("arguments[0].click();", sendbtn);
         Thread.sleep(2000);

         element=driver.findElement(By.xpath("/html/body/div[3]/div/div/form/div[1]/div/div/div/div[1]/input"));
         element.sendKeys("dhruva@gmail.com");
         
         element.submit();
         Thread.sleep(5000);

     	 log.warn("clicking next_1 button");

         element= driver.findElement(By.cssSelector("#ecomm3-checkout > div.col-lg-8.col-md-10.col-sm-12.mx-auto > "
         		+ "div > div > div.waiver-step-div.mx-auto > div.waiver-step > div > "
         		+ "div:nth-child(2) > button.next-checkout-step.btn.ecomm3-btn.pull-right")); 
         element.click();
        // jsExecutor.executeScript("arguments[0].click();", nextbtn);
         
         driver.findElement(By.id("customer_first_name")).sendKeys("dhruva");
         driver.findElement(By.id("customer_last_name")).sendKeys("jana");
         driver.findElement(By.id("customer_email")).sendKeys("dhruva@gmail.com");
         driver.findElement(By.id("customer_phone_number")).sendKeys("+9181213469");
         
      
         Thread.sleep(1000);
         driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div/div/div[2]/div[1]/button[2]")).click();
         Thread.sleep(1000);
         driver.findElement(By.id("formatted-full-price")).click();
         Actions actions = new Actions(driver);


       // element= driver.findElement(By.xpath("/html/body/div/form/div/div[2]/span[1]/span[2]/div/div[2]/span"));
        actions.sendKeys(Keys.TAB).build().perform();
        Thread.sleep(1000);

        actions.sendKeys(Keys.TAB).build().perform();
        actions.sendKeys("").perform();
        
        Thread.sleep(2000);
        actions.sendKeys("4242424242424242").perform();
        Thread.sleep(3000);
        actions.sendKeys("02").perform();
        Thread.sleep(3000);
        actions.sendKeys("26").perform();
        Thread.sleep(3000);
        actions.sendKeys("837").perform();
        Thread.sleep(1000);
        actions.sendKeys("12121").perform();
////        actions.sendKeys("243122").perform();
//        Thread.sleep(5000);
//        actions.sendKeys(Keys.TAB).build().perform();
//        Thread.sleep(5000);
//        actions.sendKeys(Keys.TAB).build().perform();
//        Thread.sleep(5000);
//        actions.sendKeys(Keys.ENTER).build().perform();
//        Thread.sleep(50000);
//        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"card_element\"]/div/iframe")));
        //Thread.sleep(2000);
      //  driver.findElement(By.id("recaptcha-element")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"checkout-btn\"]")).click();
       
        Thread.sleep(10000);
        driver.findElement(By.xpath("//a[normalize-space()='Complete']")).click();
        
        
        
//        WebElement tdElement = driver.findElement(By.xpath("//h2[normalize-space()='Thank You For Your Order!']"));
//        String expectedMessage = "Thank you for your order!";
//     // Get the text content of the <td> element
//        String actualText = tdElement.getText();
//        Assert.assertEquals(actualText, expectedMessage, "Received message doesn't match expected message");   
//        // Expected text
//        String expectedText = "Thank You For Your Order!";  
        
        String acttitle=driver.getTitle();
		String exptitle = "Thank You!";
		if(acttitle.equalsIgnoreCase(exptitle)) {
			System.out.println("Booking made successFully ");
			
		}else {
			System.out.println("Booking not made successfull");
		}
        
        
        
        tr.runtestcase("6","10",1);
    	}catch(Exception ex) {
    		 tr.runtestcase("6","8",5);
    		log.warn("error occured: "+ex.getMessage());
            Assert.fail("Caught an exception: " + ex.getMessage());
    	}
    	
    	Thread.sleep(15000);
    	driver.quit();

    }
   
}
