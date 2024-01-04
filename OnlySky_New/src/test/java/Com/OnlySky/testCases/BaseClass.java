package Com.OnlySky.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import testrail.Testrail;
import utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL = readconfig.getApplicationURL() ;
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	
	
    public static Logger log;
	WebElement element;
    WebDriverWait wait ;
    Testrail tr;
    
	
	@BeforeClass
	public void setup() throws InterruptedException
	{
		
		 // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
        // Initialize the ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
  	    log= LogManager.getLogger(BaseClass.class);
  	    //driver.get("https://winter.staging.theonlysky.com/ecomm3/products/view/");
        //loginPage = new LoginPage(driver);
  	  
        loginWithStoredCredentials();
        // Click the login button
        clickLoginButton();
        tr= new Testrail();
		
	}
    
    
	WebDriver ldriver;
	
	public void LoginPage(WebDriver rdriver){
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
		
		
	}
	
	@FindBy(className = "ml-1")
	 WebElement signInLink;
	
	 @FindBy(id = "email")
      WebElement emailInput;
	
	 @FindBy(id = "password")
	  WebElement passwordInput;
	
	  @FindBy(id = "login_submit")
	  WebElement loginButton;
	  
	  
	  //create an action method
	  public void clickSignInLink() {
	    	try {
	    	signInLink.click();
	    	}
	    	catch(Exception ex) {
				  
				log.info("Error in clicking signin link:"+ex.getMessage());
	    	}
	    }
	  public void enterUsername(String username) {
	    	try {
	           emailInput.sendKeys(username);
	    	}catch(Exception ex) {
				  log.info("Error in inputting email username:"+ex.getMessage());
	    	}
	    }
	    
	    // Enter password
	    public void enterPassword(String password) {
	    	try {
	               passwordInput.sendKeys(password);
	    	}catch(Exception ex)
	    	{
				  log.info("Error in inputting pasword:"+ex.getMessage());
	    	}
	    }
	    
	 // Click the login button
	    public void clickLoginButton() {
	    	try {
	        loginButton.click();
	    	}catch(Exception ex) {
				  log.info("Error in click log in button:"+ex.getMessage());
	    	}
	    }
	
	    

	    // Method to perform login with credentials from properties file
	       public void loginWithStoredCredentials() throws InterruptedException {
	       	String url = readconfig.getApplicationURL();

	           if (url == null || url.isEmpty()) {
	               log.error("URL is not specified in config.properties");
	               return;
	           }

	           // Navigate to the specified URL
	           try {
	               driver.get(url);
	           } catch (Exception ex) {
	               log.error("Error navigating to URL:", ex);
	           }
	       
	       
	       	clickSignInLink();
	       	Thread.sleep(1000);
	           log.info("now enter the username");
	           enterUsername(readconfig.getUsername());
	           enterPassword(readconfig.getPassword());
	           clickLoginButton();
	       }
	    
	    
	    
	
	
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(15000);
		driver.quit();
	}

}
