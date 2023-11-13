package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

// new, you have to manually write it to get access of common method
// this is possible when they are static in nature, * means all
// This is called static import
import static common.CommonActions.*;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		// PageFactory help to instantiate WebElements
		PageFactory.initElements(driver, this);
		// If no PageFactory class, Web element can't instantiated and will show NullPointerException
		// do java comment for line 20 to see the exception
	}
	
	// 1st way: Most common way to write the WebElement (@FindBy), you must know how to do that
	// Use of unique 'Id' attribute as locator
	@FindBy (id = "cms-login-submit")
	WebElement loginButton;
	
	@FindBy (name = "user-d")
	WebElement userId;
	
	// 2nd way to write the WebElement: not common, here I used for the 'password'
	// Just to make you guys familiar, if you see in your job
	// Use of unique 'name' attribute as locator
	@FindBy (how = How.NAME, using = "pass-d")
	WebElement password;
	
	// Use of unique  'class' attribute as locator
	// FYI: Never take a class value as unique if they have white space between words. 
	// Example: class value of user id, this is unique, but a compound class --> "cms-login-field ng-dirty ng-touched ng-invalid"
	@FindBy (className = "cms-newuser-reg")
	WebElement newUserRegistration;
	
	@FindBy (xpath = "//em[@id='cms-homepage-header-logo-unauth' and @class='cms-icon cms-sprite-loggedout ms-3']")
	WebElement logo;
	
	// Used it to show the common action method exception: NoSuchElementException
	@FindBy (className = "-newuser-reg")
	WebElement wrongNewUserRegistration;
	
	@FindBy(id = "cms-forgot-userid")
	WebElement forgotUserId;
	
	// 3rd way to write the WebElement by "By Class" : Not common, here I used unlock web element from the home page
	// instead of xpath, we can use id, name, class etc as locator.
	By unlock = By.xpath("//a[text()='unlock']"); 
	// Here, unlock is the WebElement name, By is a class
	
	public void clickLoginButton() throws InterruptedException {
		loginButton.click();
		Thread.sleep(5000);
	}
	
	public void clickUserId () {
		userId.click();
	}
	
	public void clickPassword () {
		password.click();
	}
	
	public void clickNewUserRegistration() {
		newUserRegistration.click();
		// We used try catch block to throw exception
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickLogo() throws InterruptedException {
		logo.click();
		Thread.sleep(5000);
	}
	
	// We are using sendKeys() method to input the text in any field
	public void inputTextInUserIdField () {
		userId.sendKeys("August 2023 QA Bootcamp"); // value always inside  " ", even if you use int type
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickWrongNewUserRegistration() {
		wrongNewUserRegistration.click();
		// We used try catch block to throw exception
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	// Use of common method clickElement(WebElement)
	public void clickForgotUserId() {
		clickElement(forgotUserId);
	}
	
	// We are using both common action here
	public void inputTextInUserIdAndPasswordFieldThenClickLoginButton() throws InterruptedException {
		inputText(userId, "May 2023 QA Bootcamp");
		inputText(password, "Enthrall@042023");
		Thread.sleep(3000);
		clickElement(loginButton);
		Thread.sleep(4000);
	}
	
	// Not common, just for your reference
	public void clickUnlock() throws InterruptedException {
		Thread.sleep(5000);
		// This is the new way to call the web element
		driver.findElement(unlock).click();
		Thread.sleep(5000);
	}
	

}
