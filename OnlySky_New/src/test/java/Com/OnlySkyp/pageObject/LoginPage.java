package Com.OnlySkyp.pageObject;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	WebElement element;
    WebDriverWait wait ;
    Logger log;
	
    
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
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
//	    public void loginWithStoredCredentials() throws InterruptedException {
//
//	    	clickSignInLink();
//	    	Thread.sleep(1000);
//	        log.info("now enter the username");
//	        enterUsername(properties.getProperty("username"));
//	        enterPassword(properties.getProperty("password"));
//	        clickLoginButton();
//	    }
	  
}
	
//	private LoginPage loginPage;
//    public static Logger log =LogManager.getLogger(LoginPage.class);
//
//
//    private final Properties properties;
//
//    WebDriver driver;
//    
//    @FindBy(className = "ml-1")
//    private WebElement signInLink;
//
//    @FindBy(id = "email")
//    private WebElement emailInput;
//
//    @FindBy(id = "password")
//    private WebElement passwordInput;
//
//    @FindBy(id = "login_submit")
//    private WebElement loginButton;
//    
//    public LoginPage(WebDriver driver) {
//        PageFactory.initElements(driver, this);
//        this.properties = loadProperties();
//        this.driver=driver;
//      
//    }
//    
//    
// // Click on the "Sign in" link
//    public void clickSignInLink() {
//    	try {
//    	signInLink.click();
//    	}
//    	catch(Exception ex) {
//			  log.info("Error in clicking signin link:"+ex.getMessage());
//    	}
//    }
//    
//    // Enter username
//    public void enterUsername(String username) {
//    	try {
//           emailInput.sendKeys(username);
//    	}catch(Exception ex) {
//			  log.info("Error in inputting email username:"+ex.getMessage());
//    	}
//    }
//    
//    // Enter password
//    public void enterPassword(String password) {
//    	try {
//               passwordInput.sendKeys(password);
//    	}catch(Exception ex)
//    	{
//			  log.info("Error in inputting pasword:"+ex.getMessage());
//    	}
//    }
//    
// // Click the login button
//    public void clickLoginButton() {
//    	try {
//        loginButton.click();
//    	}catch(Exception ex) {
//			  log.info("Error in click log in button:"+ex.getMessage());
//    	}
//    }
//    
//   
//    
//    
// // Method to perform login with credentials from properties file
//    public void loginWithStoredCredentials() throws InterruptedException {
//    	String url = properties.getProperty("url");
//
//        if (url == null || url.isEmpty()) {
//            log.error("URL is not specified in config.properties");
//            return;
//        }
//
//        // Navigate to the specified URL
//        try {
//            driver.get(url);
//        } catch (Exception ex) {
//            log.error("Error navigating to URL:", ex);
//        }
//    
//    
//    	clickSignInLink();
//    	Thread.sleep(1000);
//        log.info("now enter the username");
//        enterUsername(properties.getProperty("username"));
//        enterPassword(properties.getProperty("password"));
//        clickLoginButton();
//    }
//    
//
//    private Properties loadProperties() {
//        Properties prop = new Properties();
//        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
//            if (input == null) {
//                System.out.println("Sorry, unable to find config.properties");
//                return prop;
//            }
//            // load a properties file from class path, inside static method
//            prop.load(input);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        return prop;
//    }



