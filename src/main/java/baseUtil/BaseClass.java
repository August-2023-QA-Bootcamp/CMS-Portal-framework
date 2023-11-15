package baseUtil;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;

public class BaseClass {
	// Why default type is not ok for below 2 line? 
	// because different package accessibility is not possible for default type
	public WebDriver driver; // or we can use protected type
	// public ChromeDriver driver; // or we can use protected type
	// public FirefoxDriver driver; // or we can use protected type
	// public EdgeDriver driver; // or we can use protected type
	public ChromeDriver driver; // or we can use protected type
	public HomePage homePage; // or we can use protected type
	
	// Before start a test what need to do?
	@BeforeMethod
	public void setUP() {
		// First job is to recognize the location of driver from your device
		// right click on chromedriver.exe --- properties -- copy the location an paste below
		// System is a class and setProperty is a method of System Class
		// 1st way, to show the location of chrome driver
		// This is an absolute path
		// System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tofael\\eclipse-workspace\\gov.cms.portal\\driver\\chromedriver.exe");
		
		// 2nd way, to show the location of the chrome driver
		// This is a dynamic way (relative path)
		// user.dir means --> System set the property to User Directory
		// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		
		// 3rd and final way, to show the location of chrome driver
		// This is a dynamic path (relative path)
		// I will use this one till end of the course
		
		/*
		// For Chrome Driver
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver(); 	// We instantiated the driver here
		*/
		
		/*
		// For Firefox driver
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		driver = new FirefoxDriver();
		*/	
		
		/*
		// For edge Driver
		System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
		driver = new EdgeDriver();
		*/
		
		// When physical driver absent, or driver is not  working because of version issue, then you can use webdrivermanager
		// webdriver manager doesn't need any physical driver
		// From below line, the most updated version of chrome browser will be initialized, when no version is mentioned	
		
		/*
		WebDriverManager.chromedriver().setup(); // Then you don't need any physical driver in the driver folder
		driver = new ChromeDriver();
		*/
		
		
		// 119.0.6045.105 -- This is the current stable version
		// 118.0.5962.0 --- older version
		// 116.0.5845.96 --- older version
		// 115.0.5765.0 --- older version
		// 114.0.5735.90 --- older version
		// 113.0.5672.63 --- older version
		// 111.0.5563.64  --- older version  
		// older version sometimes used for stability of browser, sometime the request from the Authority
		// if you choose version, then it will use that specific version of driver
		
		/*
		WebDriverManager.chromedriver().driverVersion("118.0.5962.0").setup();
		driver = new ChromeDriver();
		*/
		
		// WebDriverManager is used for the most updated firefoxdriver()
		// if you wanna use a specific version, you can use driverVersion(), like line 82
		
		/*
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		*/
		
		// WebDriverManager is used for most updated edgedriver()
		// if you wanna use a specific version, you can use driverVersion(), like line 82
		
		/*
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		*/
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		
		// We instantiated the driver here
		driver = new ChromeDriver();

		// maximize method is used to maximize the window -- mostly used
		driver.manage().window().maximize();
		// We can also use fullscreen() instead of maximize()
		// driver.manage().window().fullscreen();
		// deleteAllCookies do delete the cookies
		driver.manage().deleteAllCookies();
		// get method is used to get the targeted url
		driver.get("https://portal.cms.gov/portal/");
		// PageLoadTimeout is used to wait to load the page for curtain amount of time
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		// Implicitly wait is used to wait for each web element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		homePage = new HomePage(driver);
	}
	
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}

}