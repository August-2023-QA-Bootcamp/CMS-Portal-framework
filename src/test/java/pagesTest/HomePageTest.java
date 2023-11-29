package pagesTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseUtil.BaseClass;

public class HomePageTest extends BaseClass {
	
	// The test executed based on alphabetical order, if no priority given
	// (enabled = true) means The test case is not disable, it can run
	// (enabled = false) means The test case is disable, it is not running
	// priority = 1 means, this test case will run first, 2 means second .... ... so on
	
	@Test (enabled = false, priority = 2)
	public void clickLoginButtonTest() throws InterruptedException { 
		homePage.clickLoginButton();
	}
	
	@Test(enabled = false, priority = 1)
	public void clickUserIdTest() {
		homePage.clickUserId();
	}
	
	@Test(enabled = false)
	public void clickPasswordTest() {
		homePage.clickPassword();
	}
	
	@Test (enabled = false)
	public void clickNewUserRegistrationTest() {
		homePage.clickNewUserRegistration();
	}
	
	@Test (enabled = false)
	public void clickLogoTest() throws InterruptedException {
		homePage.clickLogo();
	}
	
	@Test(enabled = false)
	public void inputTextInUserIdFieldTest() {
		homePage.inputTextInUserIdField();
	}
	
	@Test(enabled = false)
	public void clickForgotUserIdTest() {
		homePage.clickForgotUserId();
	}
	
	// Test for implicit wait and it shows No such element exception
	@Test(enabled = false)
	public void clickWrongNewUserIdTest() {
		homePage.clickWrongNewUserRegistration();
	}
	
	// This test case will fail, when you remove Pagefactory class from code form HomePage to test this
	// When PageFactory class is absent, you will find NullPointerException
	@Test (enabled = false)
	public void nullPointerExceptionTest() throws InterruptedException {
		homePage.clickNewUserRegistration();
	}
	
	@Test(enabled = false)
	public void inputTextInUserIdAndPasswordFieldThenClickLoginButtonTest() throws InterruptedException {
		homePage.inputTextInUserIdAndPasswordFieldThenClickLoginButton();
	}
	
	@Test(enabled = false)
	public void clickUnlockTest() throws InterruptedException {
		homePage.clickUnlock();
	}
	
	// From here, we are not creating method in HomePage Class to test
	
	// Important: Use of xpath as locator
	// Web Element: New User Registration Button
	// We can use a web element directly in the test class, that is also common, but different people like different way
	@Test (enabled = false)
	public void use_of_xpath_as_locator_in_new_user_registration_button() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(), 'New')]")).click();
		Thread.sleep(4000);
	}
	

	// This is best scripted in ebay (I will show it later)
	// Important: Use of linkText as locator
	// Web Element: forgot User Id
	@Test(enabled = false)
	public void use_of_linkText_as_locator_in_forgot_user_id_hyperlink() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.linkText("User ID")).click();
		Thread.sleep(4000);
	}
	
	// Important: Use of partialLinkText as locator
	// Web Element: forgot Password
	@Test(enabled = false)
	public void use_of_partialLinkText_as_locator_in_forgot_password_hyperlink() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("Passwor")).click();
		Thread.sleep(4000);
	}
	
	// logo: class attribute value:  cms-icon cms-sprite-loggedout ms-3
	// Exception 'InvalidSelectorException': 'Compound class names not permitted',
	// so even if you see class value is unique but separated by space, avoid this as class name locator
	// This scenario will show error and will failed everywhere

	@Test(enabled = false)
	public void why_we_use_cssSelector_as_locator_in_logo () {
		driver.findElement(By.className("cms-icon cms-sprite-loggedout ms-3")).click();
	}

	// Web Element: New User Registration Button
	// Important: Use of cssSelector as locator
	// cssSelector is very important for interview
	// cssSelector by class --> inside the string, first put html tag, then dot, then write value of the class attribute 
	@Test(enabled = false)
	public void role1_use_of_cssSelector_as_locator_in_new_user_registration_button () {
		driver.findElement(By.cssSelector("a.cms-newuser-reg")).click();
	}
	
	// Important: Use of cssSelector as locator
	// Web Element: login Button
	// if you wanna create cssSelector by id 
	// first html tag, then # (hash), then write the value of id attribute inside the string
	@Test(enabled = false)
	public void role2_use_of_cssSelector_as_locator_in_login_button() {
		driver.findElement(By.cssSelector("button#cms-login-submit")).click();
	}
	
	// Web Element: logo
	// Important: Use of cssSelector as locator
	// if the class (compound class) contain separate words [cms-icon cms-sprite-loggedout ms-3], 
	// they are actually different class, then
	// we have to close the gap between classes by putting dot/period between them
	// cssSelector by class --> htmltag.class name value 
	// remove the space between words in class value, and replace with dot/period
	@Test(enabled = false)
	public void role3_use_of_cssSelector_as_locator_in_logo () {
		driver.findElement(By.cssSelector("em.cms-icon.cms-sprite-loggedout.ms-3")).click();
	}
	
	// Above 3 is mostly used, 90% cases of css selector, also very common interview question
	// below 3 high level, no need to see if you feel they are tough
	
	// Use of cssSelector as locator
	// Web Element: login Button
	// high level, you can ignore
	// cssSelector by another attribute
	// --> htmltag[id/class/name attribute = 'value of the attribute' ] , in xpath - you use // and @, which is absent here 
	// and you can use any other attribute name except id and class
	@Test(enabled = false)
	public void role4_use_of_cssSelector_as_locator_in_login_button () {
		driver.findElement(By.cssSelector("button[name='Submit Login']")).click();
	}
	
	// Web Element: NUR Button
	// Not important, can ignore
	// cssSelector by another attribute
	// --> htmltag.value of class[id/class/name attribute = 'value of the attribute'] , in xpath you use // and @, which is absent here and you can use attribute except id and class
	// That's why we use title
	@Test(enabled = false)
	public void role5_use_of_cssSelector_as_locator_in_login_button() throws InterruptedException {
		driver.findElement(By.cssSelector("a.cms-newuser-reg[title='New User Registration']")).click();
		Thread.sleep(5000);
	}
	
	// Important: Use of cssSelector as locator
	// Web Element: login Button
	// Not important, can ignore
	// cssSelector by another attribute
	// --> htmltag#value of ID[attribute name='value'] , in xpath you use // and @, which is absent here and you can use attribute except id and class
	@Test(enabled = false)
	public void role6_use_of_cssSelector_as_locator_in_login_button () {
		driver.findElement(By.cssSelector("button#cms-login-submit[name='Submit Login']")).click();
	}
	
	// Important: Use of tagName as locator
	// tag name: we have to go to Amazon and look for table
	
	@Test (enabled = false)
	public void use_of_tagName_as_locator() {
		driver.findElement(By.tagName("header")).click(); // not a clickable element, just showed you
	}
	
	// Web Element: logo
	// isDisplayed() is an alternate of click() method which is boolean type
	// isDisplayed() is the method used to verify the presence of a web element within the web page.
	// Use of isDisplayed() available- image, link, button, text field, check box etc.
	@Test(enabled = false)
	public void use_of_isDisplayed_in_logo_image() {
		boolean elementDisplayed = driver.findElement(By.cssSelector("em.cms-icon.cms-sprite-loggedout.ms-3")).isDisplayed();
		System.out.println("Is the Logo displayed? Ans: " + elementDisplayed);
	}
	
	// Web Element: login Button
	// isEnabled() is the method used to verify if the web element is enabled or
	// disabled within the web page. isEnabled() is primarily used with buttons.
	// Use of isEnabled(), a boolean type method
	@Test(enabled = false)
	public void use_of_isEnabled_in_login_button() {
		boolean loginButtonEnabled = driver.findElement(By.name("Submit Login")).isEnabled();
		System.out.println("Is the Login Button Enabled? Ans: " + loginButtonEnabled);
	}
	
	// Web Element: check box in login page
	@Test (enabled = false)
	public void use_of_isSelected_in_check_box () throws InterruptedException {
		boolean checkBoxSelected = driver.findElement(By.xpath("//label[@id='cms-label-tc']")).isSelected();
		System.out.println("Is the CheckBox selected? Ans: " + checkBoxSelected);
		driver.findElement(By.xpath("//label[@id='cms-label-tc']")).click();
		Thread.sleep(5000);
	}
	
	//TODO  Nasir: select No, evaluating No, select Yes, evaluating Yes, why Still False?
	// Web Element: Radio button in Forgot User ID 
	@Test (enabled = false)
	public void use_of_isSelected_in_radio_button () throws InterruptedException {
		// first click on Forgot User ID
		homePage.clickForgotUserId();
		Thread.sleep(4000);
		// another role for creating xpath below
		driver.findElement(By.xpath("(//label[@class='check-radio'])[2]")).click();
		Thread.sleep(4000);
		boolean radioButtonYesSelected = driver.findElement(By.xpath("(//label[@class='check-radio'])[2]")).isSelected();
		System.out.println("Is the Radio button selected? Ans: " + radioButtonYesSelected);
		driver.findElement(By.xpath("(//label[@class='check-radio'])[1]")).click();
		Thread.sleep(4000);
		boolean radioButtonNoSelected = driver.findElement(By.xpath("(//label[@class='check-radio'])[1]")).isSelected();
		System.out.println("Is the Radio button selected? Ans: " + radioButtonNoSelected);
	}
	
	@Test(enabled = false)
	public void use_of_isEnabled_in_login_button02() throws InterruptedException {
		driver.findElement(By.name("user-d")).isDisplayed();
		driver.findElement(By.name("user-d")).sendKeys("August 2023 QA Bootcamp");
		Thread.sleep(4000);
		driver.findElement(By.name("pass-d")).isDisplayed();
		driver.findElement(By.name("pass-d")).sendKeys("ABC@123");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//label[@id='cms-label-tc']")).isSelected();
		driver.findElement(By.xpath("//label[@id='cms-label-tc']")).click();
		Thread.sleep(4000);
		driver.findElement(By.name("Submit Login")).isEnabled();
		driver.findElement(By.name("Submit Login")).click();
		Thread.sleep(4000);
	}
	
	// how can you find the title of the page?
	// Basically inside <head> tag, <title> tag is present, you can get it from there or
	// right click on an empty place of any page -- click "view page source" -- ctrl+f (to find) 
	// -- Type 'title' -- find the <title> tag
	@Test(enabled = false)
	public void use_of_getTitle_method_in_home_page() {
		System.out.println("The Title of the page is: " + driver.getTitle());
	}
	
	// We use New User Registration	
	@Test(enabled = false)
	public void use_of_getCurrentURL_method () throws InterruptedException {
		driver.findElement(By.className("cms-newuser-reg")).click();
		Thread.sleep(4000);
		System.out.println("The current URL is: " + driver.getCurrentUrl());
		System.out.println("The Title of the page is: " + driver.getTitle());
	}
	
	//  Please see line 283 to learn getText()
	@Test(enabled = false)
	public void use_of_getText_method_in_login_button() throws InterruptedException {
		driver.findElement(By.name("user-d")).isDisplayed();
		driver.findElement(By.name("user-d")).sendKeys("August 2023 QA Bootcamp");
		Thread.sleep(4000);
		driver.findElement(By.name("pass-d")).isDisplayed();
		driver.findElement(By.name("pass-d")).sendKeys("ABC@123");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//label[@id='cms-label-tc']")).isSelected();
		driver.findElement(By.xpath("//label[@id='cms-label-tc']")).click();
		Thread.sleep(4000);
		driver.findElement(By.name("Submit Login")).isEnabled();
		WebElement loginButton = driver.findElement(By.name("Submit Login"));
		System.out.println("The text for the WebElement is: " + loginButton.getText());
		driver.findElement(By.name("Submit Login")).click();
		Thread.sleep(4000);
	}
	
	// Here We used User ID field
	// getAttribute() actually give the value of the Attribute, not common
	@Test(enabled = false)
	public void use_of_getAttribute_method () throws InterruptedException {
		driver.findElement(By.name("user-d")).isDisplayed(); 
		Thread.sleep(4000);
		// TODO Nasir: placeholder is not working, need to fix
		String value01 = driver.findElement(By.xpath("//input[@id='cms-login-userId']")).getAttribute("placeholder");
		String value02 = driver.findElement(By.xpath("//input[@id='cms-login-userId']")).getAttribute("class");
		String value03 = driver.findElement(By.xpath("//input[@id='cms-login-userId']")).getAttribute("id");
		String value04 = driver.findElement(By.xpath("//input[@id='cms-login-userId']")).getAttribute("title");
		System.out.println("The value of the placeholder attribute is: " + value01);
		System.out.println("The value of the class attribute is: " + value02);
		System.out.println("The value of the id attribute is: " + value03);
		System.out.println("The value of the title attribute is: " + value04);
	}
	
	// Use of clear() in line 313
	// Using User Id field
	// Some web site don't clear automatically, so you must test clear() in each text field
	@Test(enabled = false)
	public void use_of_sendKeys_method_then_clear() throws InterruptedException {
		driver.findElement(By.name("user-d")).isDisplayed();
		driver.findElement(By.name("user-d")).sendKeys("May 2023 QA Bootcamp");
		Thread.sleep(4000);
		driver.findElement(By.name("user-d")).clear();
		Thread.sleep(4000);
		driver.findElement(By.name("user-d")).sendKeys("August 2023 QA Bootcamp");
		Thread.sleep(4000);
		driver.findElement(By.name("user-d")).clear();
		Thread.sleep(4000);
	}
	
	// use of Keys.ENTER
	// Click on forgot password field, then send a value inside "Enter user id" field and click by Enter key
	@Test(enabled = false)
	public void use_of_sendKeys_method_then_click_by_enter_key_of_the_laptop () throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(), 'Pas')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("cms-forgotpwd-userId")).sendKeys("enthrall_12", Keys.ENTER);
		Thread.sleep(4000);
	}
	
	// use of Keys.RETURN
	// Click on forgot password field, then send a value inside "Enter user id" field and click by Enter key
	@Test(enabled = false)
	public void use_of_sendKeys_method_then_click_by_return_key_of_the_laptop () throws InterruptedException {
		driver.findElement(By.id("cms-forgot-password")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("cms-forgotpwd-userId")).sendKeys("enthrall_12", Keys.RETURN);
		Thread.sleep(4000);
	}

	// use of navigate()
	// Interview Question
	@Test(enabled = false)
	public void use_of_navigate_method () throws InterruptedException {
		Thread.sleep(5000);
		driver.navigate().to("https://portal.cms.gov/portal/help/digital/home");
		Thread.sleep(4000);
		driver.navigate().back();
		Thread.sleep(4000);
		driver.navigate().forward();
		Thread.sleep(4000);
		driver.navigate().refresh();
		Thread.sleep(4000);
	}
	
	// Very important interview question
	// How can you reset a window size? or they can ask how you can change the screen size by selenium
	
	@Test(enabled = false)
	public void set_a_specific_size_for_window() throws InterruptedException {
		Thread.sleep(4000);
		// Will get the size of cms window
		System.out.println("The size of the maximize screen is: "+ driver.manage().window().getSize());
		dimension = new org.openqa.selenium.Dimension(1000, 700);
		driver.manage().window().setSize(dimension);
		Thread.sleep(4000);
		System.out.println("The size of the set screen is: "+ driver.manage().window().getSize());
		
		// Extra related to this method, although you can skip
		Thread.sleep(4000);
		driver.navigate().to("https://www.cvs.com");
		Thread.sleep(4000);
		System.out.println("The size of the set screen is: "+ driver.manage().window().getSize());
		driver.manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("The size of the maximize screen is: "+ driver.manage().window().getSize());
		Thread.sleep(5000);
		driver.manage().window().setSize(dimension); // just to show again the set size
		Thread.sleep(5000);
		System.out.println("The size of the set screen is: "+ driver.manage().window().getSize());
		Thread.sleep(5000);
		driver.manage().window().fullscreen();
		Thread.sleep(5000);
		System.out.println("The size of the full screen is: "+ driver.manage().window().getSize());	
	}
	
	// Sets the amount of time to wait for an asynchronous script to finish execution before throwing an error. 
	// not important at all
	@SuppressWarnings("deprecation")
	@Test(enabled = false)
	public void use_of_set_script_timeout_for_window() {
		driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(15));
		// setScriptTimeout () method deprecated, so giving you warning, this method is going to be out from selenium
        // you use @SuppressWarnings("deprecation")
		driver.get("https://www.ebay.com");	
	}
	
	// We have to make a method for this in HomePage
	@Test(enabled = false)
	public void logoDisplayedTest01() {
		homePage.logoDisplayed(); // Actual Outcome by selenium
		Assert.assertTrue(true); // Expected Outcome
	}
	
	@Test(enabled = false)
	public void logoDisplayedTest02() {
		homePage.logoDisplayed();  // Actual Result or outcome which doesn't match with your below expectation
		Assert.assertTrue(false); // Expected Result // java.lang.AssertionError: expected [true] but found [false]
		// Although the outcome is true, but because of difference between expected vs actual is not same, the test case failed
	}
	
	// same as above, just we added message
	@Test(enabled = false)
	public void logoDisplayedTest03() {
		homePage.logoDisplayed();  // Actual Result: true
		Assert.assertTrue(false, "Application Logo is not Displayed");
		// Assert.assertFalse(false, "Application Logo is not Displayed"); // false false means true
		// Assert.assertTrue(true, "Application Logo is not Displayed"); // So, the message will show up when failed
	}
	
	@Test (enabled = false)
	public void logoDisplayedTest04 () {
		homePage.logoDisplayed(); // Actual Result : true
		Assert.assertFalse(true, "Application Logo is Displayed, but expected result is not to dispaly ..... ..... ");
		// java.lang.AssertionError: Application Logo is not Displayed ..... .....  expected [false] but found [true]
		// error message will be appeared when the assertion failed 
	}
	
	// A regular title test in line 260
	@Test(enabled = false)
	public void use_of_getTitle_method01() throws InterruptedException {
		String actual = driver.getTitle();
		Thread.sleep(5000);	
		System.out.println("The title of the Page is: " + actual);
	}
	
	// will pass
	@Test(enabled = false)
	public void use_of_getTitle_method_with_assertion01() throws InterruptedException {
		String actual = driver.getTitle();
		System.out.println("The title of the Page is: " + actual);		
		String expected = "CMS Enterprise Portal"; // Our expected Title
		Assert.assertEquals(actual, expected, "Home Page Title doesn't match");
		// Hard Assertion will not go to next line if failed, but move to next line when passed
		String currentURL = driver.getCurrentUrl();
		System.out.println("The current url is: " + currentURL);
	}
	
	// Will fail
	@Test(enabled = false)
	public void use_of_getTitle_method_with_assertion02() throws InterruptedException {
		String actual = driver.getTitle();
		System.out.println("The title of the Page is: " + actual);		
		String expected = "CMS Enterprise Portal           "; // Our expected Title
		Assert.assertEquals(actual, expected, "Home Page Title doesn't match");
		// Hard Assertion will not go to next line if failed, but move to next line when passed
		String currentURL = driver.getCurrentUrl();
		System.out.println("The current url is: " + currentURL);
	}
	
	// Will Pass
	@Test(enabled = false)
	public void use_of_getTitle_method_with_assertion03() throws InterruptedException {
		String actual = driver.getTitle();
		System.out.println("The title of the Page is: " + actual);		
		String expected = "CMS Enterprise Portal           "; // Our expected Title
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual, expected, "Home Page Title doesn't match");	
		// Soft Assertion, execution will not stopped here if Assertion is failed in above line
		String currentURL = driver.getCurrentUrl();
		System.out.println("The current url is: " + currentURL);
	}

	// Very very important for use in framework and also a interview question
	@Test(enabled = false)
	public void use_of_mouse_hoverAction_on_ourLocations () throws InterruptedException {
		Thread.sleep(4000);
		driver.navigate().to("https://www.mountsinai.org/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
		WebElement ourLoations = driver.findElement(By.xpath("//a[normalize-space(text()) = 'Our Locations' and @class='hidden-xs dropdown']"));
		Thread.sleep(4000);
		// Actions actions = new Actions(driver); // We don't need it here
		// Because Actions class is instantiated in base class, actions object came form there
		actions.moveToElement(ourLoations).build().perform();
		Thread.sleep(6000);	
		
	}
	
	// Regular click method
	@Test(enabled = false)
	public void use_of_click_method_in_loginButtonTest () throws InterruptedException {
		driver.findElement(By.id("cms-login-submit")).click();
		Thread.sleep(3000);
	}
	
	// interview question: what are the alternative of click(), but they are not expecting this answer, they are looking for javascriptExecutor
	// alternate of click()
	@Test(enabled = false)
	public void alternate_of_click_method_in_loginButtonTest01() throws InterruptedException {
		driver.findElement(By.id("cms-login-submit")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
	
	// alternate of click()
	@Test(enabled = false)
	public void alternate_of_click_method_in_loginButtonTest02() throws InterruptedException {
		driver.findElement(By.id("cms-login-submit")).sendKeys(Keys.RETURN);
		Thread.sleep(3000);
	}
	
	// Important interview question + they ask you to write the code in MS word
	// so, practice it by paper pen, then in ms word
	// alternate of click()
	@Test(enabled = false)
	public void alternate_of_click_method_in_loginButtonTest03() throws InterruptedException {
		WebElement loginButton = driver.findElement(By.id("cms-login-submit"));
		// JavascriptExecutor js = (JavascriptExecutor) driver; // We don't need it here
		// Because JavascriptExecutor Interface is instantiated in base class, js object came form there
		js.executeScript("arguments[0].click()", loginButton);
		// arguments[0] means, find the web element of index 0, first occurrence
		Thread.sleep(4000);
	}
	
	// alternate of click()
	// "arguments[0].click()" ---> above is easy to memorize, memorize it, if you want
	// follow the above one, because you can use any kind of locator 
	// (specially xpath is difficult to create by below one)
	// don't follow this one, but if you ever see it, i hope you can recognize it
	@Test(enabled = false)
	public void alternate_of_click_method_in_loginButtonTest04() throws InterruptedException {
		js.executeScript("document.getElementById('cms-login-submit').click();");
		Thread.sleep(4000);
	}
	
	// From here till line 578, this is high level, so just see, don't take them seriously
	// alternative to click an web element in many ways (never memorize, a collection of code)
	
	// Not important
	
	// alternate of click()
	@Test(enabled = false)
	public void homepageLoginButtonTest06() {
		WebElement homepageLoginButton = driver.findElement(By.xpath("//button[@id='cms-login-submit']"));
		actions.click(homepageLoginButton).perform();
	}
	
	// Not important
	// alternate of click()
	@Test(enabled = false)
	public void homepageLoginButtonTest07() {
		WebElement homepageLoginButton = driver.findElement(By.xpath("//button[@id='cms-login-submit']"));
		actions.moveToElement(homepageLoginButton).click().perform();
	}

	// Not important
	// alternate of click()
	@Test(enabled = false)
	public void homepageLoginButtonTest08() {
		WebElement homepageLoginButton = driver.findElement(By.xpath("//button[@id='cms-login-submit']"));
		actions.clickAndHold(homepageLoginButton).release().perform();
	}

	// Not important
	// alternate of click()
	@Test(enabled = false)
	public void homepageLoginButtonTest09() {
		WebElement homepageLoginButton = driver.findElement(By.xpath("//button[@id='cms-login-submit']"));
		actions.sendKeys(homepageLoginButton, Keys.RETURN).perform();
	}
	
	// login process regular to compare with line 579
	@Test(enabled = false)
	public void use_of_sendKeys_method_then_click() throws InterruptedException {
		driver.findElement(By.name("user-d")).sendKeys("August 2023 QA Bootcamp");
		Thread.sleep(4000);
		driver.findElement(By.name("pass-d")).sendKeys("ABC@123");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//label[@id='cms-label-tc']")).click();
		Thread.sleep(4000);
		driver.findElement(By.name("Submit Login")).click();
		Thread.sleep(4000);
	}
	
	// login process by JavascriptExecutor
	// alternative of sendKeys(), please remember
	@Test(enabled = false)
	public void use_of_sendKeys_method_by_javascriptExecutor_then_click() throws InterruptedException {
		WebElement userId = driver.findElement(By.name("user-d"));
		WebElement password = driver.findElement(By.name("pass-d"));
		WebElement checkBox = driver.findElement(By.xpath("//label[@id='cms-label-tc']"));
		WebElement loginButton = driver.findElement(By.name("Submit Login"));
		
		// how to send text inside a field by JavascriptExecutor, alternate of sendKeys()
		js.executeScript("arguments[0].value = 'August 2023 QA Bootcamp' ", userId); // Memorize it
		Thread.sleep(4000);
		js.executeScript("arguments[0].value = 'Abc@123213' ", password);
		Thread.sleep(4000);
		js.executeScript("arguments[0].click()", checkBox); // Memorize it
		Thread.sleep(4000);
		js.executeScript("arguments[0].click()", loginButton);
		Thread.sleep(4000);		
	}

    // We practiced drop down feature in ForgotUserId Page
	
	// it will fail
	@Test(enabled = false)
	public void how_to_handle_hidden_element_by_regular_selenium_method() throws InterruptedException {
		Thread.sleep(5000);	
		driver.navigate().to("https://www.letskodeit.com/practice");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(4000);
		// identify the 'Hide' element and click on it [line 625]
		// The search field will be disappeared, but we can pass value on it, as we get info before
		driver.findElement(By.id("hide-textbox")).click();
		Thread.sleep(4000);
		// identify element and set/input text or value (line 628) by selenium
		driver.findElement(By.xpath("//input[@id='displayed-text']")).sendKeys("August 2023");
		// it will fail by below error message
		// org.openqa.selenium.ElementNotInteractableException: element not interactable
		// whenever you find element not interactable in console, that is for sure a hidden element
		
		}
		
		@Test(enabled = false)
		public void how_to_handle_hidden_element_by_javascriptExecutor() throws InterruptedException {
			Thread.sleep(5000);	
			driver.navigate().to("https://www.letskodeit.com/practice");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Thread.sleep(4000);
			// identify the 'Hide' element and click on it [line 644]
			// The search field will be disappeared, but we can pass value on it, as we get info before
			driver.findElement(By.id("hide-textbox")).click();
			Thread.sleep(4000);
			// identify element and set/input text or value by JavascriptExecutor
			WebElement searchField = driver.findElement(By.xpath("//input[@id='displayed-text']"));
			js.executeScript("arguments[0].value = 'August 2023' ", searchField);
			Thread.sleep(4000);
			// You really know what was the text written by the JavascriptExecutor
			
			// not important
			// Extra code
			// Extra not related to hidden elements and not important
			// To find out what you send as text, not necessary for this scenario
			// Just save the below code for future reference
			String s = (String) js.executeScript("return document.getElementById('displayed-text').value");
			System.out.print("Value entered in hidden field: " + s + "\n");
			
			// not important
			// How to get title of the page by JavaScript
			// How to read a JavaScript variable in Selenium WebDriver?
			// How to getTitle by Javascript, 
			String sText = js.executeScript("return document.title;").toString(); // fetching page title by javascript
			System.out.println("The title of the Page is: "+sText);
			

			// not related with this test
			// How to refresh by Javascript, 
			js.executeScript("history.go(0)"); // To do refresh by Javascript
		}
		
		// very very important
		// when the web element always failed in test, use explicitly wait, in this web site doesn't have that complex scenario
		// "unlock" web element 
		// using visibilityOfElementLocated() method , Number one
		// This is a very common scenario in industry to use explicitly wait
		@Test(enabled = false)
		public void use_of_explicitly_wait_01() throws InterruptedException {
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'unlock')]"))).click();
			Thread.sleep(4000);
		}
		
		// same webElement
		// using elementToBeClickable() method, number two
		@Test(enabled = false)
		public void use_of_explicitly_wait_02() throws InterruptedException {
			Thread.sleep(2000);
			WebElement element01 = driver.findElement(By.xpath("//a[contains(text(), 'unlock')]"));
			wait.until(ExpectedConditions.elementToBeClickable(element01)).click();
			Thread.sleep(4000);
		}
		
		// same webElement
		// using visibilityOf() method, number three
		@Test(enabled = false)
		public void use_of_explicitly_wait_03() throws InterruptedException {
			Thread.sleep(2000);
			WebElement element02 = driver.findElement(By.xpath("//a[contains(text(), 'unlock')]"));
			wait.until(ExpectedConditions.visibilityOf(element02)).click();
			Thread.sleep(4000);
		}
		
		// Try to remember this above 3 conditions name for interview, most time they asked it
		
		
		// Not important, you can use it to practice
		// "unlock" web element 
		// using presenceOfElementLocated() method
		@Test(enabled = false)
		public void use_of_explicitly_wait_04() throws InterruptedException {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cms-unlock-account"))).click();
			Thread.sleep(5000);
		
		}

		// Not important, you can use it to practice
		// "New User Registration" web element
		// using textToBePresentInElement() method
		// this is not a clickable method, just to recognize the web element
		@Test(enabled = false)
		public void use_of_explicitly_wait_05() throws InterruptedException {
			Thread.sleep(2000);
			WebElement nur = driver.findElement(By.xpath("//a[text()='New User Registration']")); 
			boolean outcome = wait.until(ExpectedConditions.textToBePresentInElement(nur, "New User Registration"));
			System.out.println(outcome);
			Thread.sleep(5000);
		}
		
		// important interview question
		// 1st way: Scroll by Actions class
		// scroll bottom and then top
		@Test (enabled = false)
		public void use_of_scroll_down_and_scroll_up_by_actions_class_01 () throws InterruptedException {
			Thread.sleep(5000);
			// for Scroll Down using Actions class, to go at the bottom of the page
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
			Thread.sleep(5000);
			// for Scroll Up using Actions class at the top of the page
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
			Thread.sleep(5000);
			//Keys.UP or Keys.Down doesn't change much but the test case passes, we will not use them
		}
		
		// important interview question
		// 2nd way: Scroll by javascriptExecutor
		// scroll in a certain position (not at the bottom or up)
		@Test (enabled = false)
		public void use_of_scroll_down_and_scroll_up_by_javascriptExecutor () throws InterruptedException {
			// This will scroll down the page by 1000 pixel vertically
			// here 0 is x axis, 1000 y axis
			// you choose your pixel accordingly to reach to that web element
			Thread.sleep(5000);	
			js.executeScript("window.scrollBy(0, 1300)", ""); // scroll down till 1000px
			// You can change the value to any pixel, and put your own to see the web element you wanna test
			Thread.sleep(5000);	
			js.executeScript("window.scrollBy(0, -1300)", ""); // scroll up till 1000px, but not necessary based on your test
			// minus when it goes opposite of down
			Thread.sleep(4000);
					
		}
			
		// not important, just to know
		@Test (enabled = false)
		public void use_of_scroll_down_and_scroll_up_by_robot_class () throws InterruptedException, AWTException {
			// For some reason, they are not going completely Up or Down
			Robot robot = new Robot();
			// Scroll Down using Robot class
			robot.keyPress(KeyEvent.VK_PAGE_DOWN); // Constant for the PAGE_DOWN virtual key.
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(5000);
			
			// Scroll Up using Robot class
	        robot.keyPress(KeyEvent.VK_PAGE_UP); // Constant for the PAGE_UP virtual key. 
	        robot.keyRelease(KeyEvent.VK_PAGE_UP);
	        Thread.sleep(5000);
	        
	        driver.navigate().back();
	        Thread.sleep(5000);
			
		}
		
		// scroll Into View The Element
		// This is very very important, standard interview question
		// This is better to use
		@Test(enabled = false)
		public void scrollIntoViewTheElement() throws InterruptedException {
			Thread.sleep(4000);
			// it's crossing the web element, but working
			WebElement enterprisePortal = driver.findElement(By.xpath("//h1[contains(text(), 'Enterprise Portal')]"));
			js.executeScript("arguments[0].scrollIntoView(true);", enterprisePortal); // Please memorize it, semicolon after method and method name starts with lower case and follow camel case feature
			Thread.sleep(5000);
		}
		
		// important for interview
		@Test(enabled = false)
		public void web_based_alert_accept_test () throws InterruptedException {
			Thread.sleep(5000);	
			driver.get("http://softwaretestingplace.blogspot.com/2017/03/javascript-alert-test-page.html");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(By.xpath("//button[contains(text(), 'Try it')]")).click();
			Thread.sleep(4000);
			Alert alert = driver.switchTo().alert(); // we can't use it in Base class, because after this it expects a popup, but in base class before each test no pop up
			Thread.sleep(4000);
			System.out.println("The text present in the alert is: " + alert.getText());
			alert.accept();
			Thread.sleep(4000);
			// line 813, not part of the accept function, 
			// we just added to know about, the text is present in the alert or not, also if you use it after 814, it might not retrieve the text
					
		}
		
		// important for interview
		@Test(enabled = false)
		public void web_based_alert_dismiss_test () throws InterruptedException {
			Thread.sleep(5000);	
			driver.get("http://softwaretestingplace.blogspot.com/2017/03/javascript-alert-test-page.html");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(By.xpath("//button[text()='Try it']")).click();
			Thread.sleep(4000);
			Alert alert = driver.switchTo().alert();
			Thread.sleep(4000);
			System.out.println("The text present in the alert is: " + alert.getText());
			alert.dismiss();
			Thread.sleep(4000);
			// line 832, not part of the accept function, 
			// we just added to know about, the text is present in the alert or not
				
		}
		
		// HW given
		// Another code for scrolling and then search for hidden web element [save this code]
		@Test(enabled = true)
		public void how_to_handle_hidden_element_by_javascriptExecutor02() throws InterruptedException {
			Thread.sleep(5000);	
			driver.navigate().to("https://enthrallit.com/");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			// Click on Selenium from Header
			Thread.sleep(4000);
			driver.findElement(By.xpath("//a[text()='Selenium']")).click();
			Thread.sleep(4000);
			// Scrolling to see the web element
			WebElement hideButton = driver.findElement(By.xpath("//button[@id='formButton3']"));
			js.executeScript("arguments[0].scrollIntoView(true);", hideButton); 
			Thread.sleep(5000);
			// identify the 'Hide' element and click on it
			// The search field will be disappeared, but we can pass value on it, as we get info before
			js.executeScript("arguments[0].click();", hideButton); 
			// identify element and set/input text or value by JavascriptExecutor
			WebElement serchField = driver.findElement(By.xpath("//input[@class='form-control']//parent::form[@id='form3']"));
			js.executeScript("arguments[0].value='January 2023' ", serchField);
			Thread.sleep(4000);
		}
		
		// Only important for interview
		@Test(enabled = false)
		public void authenticationPopUpTest () throws InterruptedException {
			Thread.sleep(5000);	
			String userName = "admin";
			String password = "admin";
			// original one is: "https://the-internet.herokuapp.com/basic_auth";
			// Updated one is: "https://admin:admin@the-internet.herokuapp.com/basic_auth";
			String url = "https://" + userName + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth";
			driver.get(url);
			Thread.sleep(5000);	
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Thread.sleep(5000);
			
			// The below part is not part of this test
			// identify and get text after authentication of popup
			String t = driver.findElement(By.tagName("p")).getText(); // we use tag name as a locator in our course
			System.out.println("The Text is: " + t);
		}
		
		// only important for interview
		@Test(enabled = false)
		public void use_of_right_click_action () throws InterruptedException {
			Thread.sleep(5000);	
			driver.get("https://demo.guru99.com/test/simple_context_menu.html");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebElement rcButton = driver.findElement(By.xpath("//span[contains(text(), 'right click me')]"));
			// Actions actions = new Actions(driver);
			actions.moveToElement(rcButton).contextClick().build().perform(); // right click action
			Thread.sleep(4000);
			
			// From Line 877, not part of testing, just completed the scenario
			// Just keep below code, Can't find the web element for Edit at present, the line 877 is from my collection.
			// Below 2 is not relevant to right click, just doing some extra, which we know already
			// Next: I want to click on Edit link on the displayed menu options
			WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']"));
			Thread.sleep(4000);
			edit.click(); // a regular click, not a right click
			Thread.sleep(4000);
			// Switch to the alert box and click on OK button
			Alert alert = driver.switchTo().alert();
			System.out.println("\nAlert Text:" + alert.getText());
			alert.accept();
			Thread.sleep(4000);
		}
		
		
		// only important for interview
		@Test(enabled = false)
		public void use_of_double_click_action () throws InterruptedException {
			Thread.sleep(5000);	
			driver.get("https://demo.guru99.com/test/simple_context_menu.html");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Thread.sleep(4000);
			WebElement dcButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
			actions.doubleClick(dcButton).build().perform(); // double click action
			Thread.sleep(4000);
			// Not part of the double click action
			// Switch to the alert box and click on OK button
			Alert alert = driver.switchTo().alert();
			System.out.println("\nAlert Text:" + alert.getText());
			alert.accept();
			Thread.sleep(4000);
		}
		
		// not important for interview
		@Test(enabled = false)
		public void use_of_drag_and_drop_action () throws InterruptedException {
			Thread.sleep(5000);	
			driver.get("https://demo.guru99.com/test/drag_drop.html");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			// Element which needs to drag (Bank)
			WebElement sourceLocator = driver.findElement(By.id("credit2")); // Web element of the Bank button, it will be dragged
			// Element where need to be dropped.(In 'Account' field of debit side)
			WebElement targetLocator = driver.findElement(By.xpath("//ol[@id='bank']")); // and it will be dropped here
			// We Use Actions class for drag and drop.
			actions.dragAndDrop(sourceLocator, targetLocator).build().perform();
			Thread.sleep(5000);
		}
		
		// not important
		@Test(enabled = false)
		public void use_of_slider_action () throws InterruptedException {
			Thread.sleep(5000);	
			driver.get("https://demoqa.com/slider/");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			// Retrieve WebElemnt 'slider' to perform mouse hover
			// This is the field where volume is increased
			WebElement slider = driver.findElement(By.cssSelector("input.range-slider.range-slider--primary"));
			// Move mouse to x offset 50 i.e. in horizontal direction
			Thread.sleep(5000);
			// to test the slider is working or not
			// dragAndDropBy (element, int xoffset, int yoffset)
			actions.dragAndDropBy(slider, 50, 0).build().perform(); // learn from here, 50 is in pixel which might not match with real volume change, real volume 60
			Thread.sleep(5000);
			// slider.click();
			System.out.println("Moved slider in horizontal directions");
		}
			
		
		// not important (alternate), also tough
		@Test(enabled = false)
		public void use_of_slider_action_alternate () throws InterruptedException {
			Thread.sleep(5000);	
			driver.get("https://demoqa.com/slider/");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			// Retrieve WebElemnt 'slider' to perform mouse hover
			// This is the field where volume is increased
			WebElement slider = driver.findElement(By.cssSelector("input.range-slider.range-slider--primary")); 
			// Move mouse to x offset 65 i.e. in horizontal direction
			Thread.sleep(5000);
			// More tough than above
			actions.clickAndHold(slider);
			Thread.sleep(5000);
			actions.moveByOffset(65, 0).build().perform(); // pixel 65, real volume 63
			Thread.sleep(5000);
			System.out.println("Moved slider in horizontal directions");
			
		}
		
		// Tough, try your best
		@Test(enabled = false)
		public void mouseHoverActionOnAboutUs() throws InterruptedException {
			Thread.sleep(4000);
			driver.navigate().to("https://www.mountsinai.org/");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
			WebElement aboutUs = driver.findElement(By.xpath("//a[normalize-space(text()) = 'About Us' and @class='hidden-xs dropdown']")); 
			Thread.sleep(4000);
			actions.moveToElement(aboutUs).build().perform();
			Thread.sleep(4000); // Until here, we did it before
			
			// Use of findElements()
			List<WebElement> listOfAboutUs = driver.findElements(By.xpath("//a[normalize-space(text()) = 'About Us' and @class='hidden-xs dropdown']//following-sibling::div//child::div//child::div"));
			
			for(int i =0; i <listOfAboutUs.size(); i++) {
				System.out.println(listOfAboutUs.get(i).getText());
			}
		}
		
		/*
		// same but another example from costco
		@Test(enabled = true)
		public void mouseHoverActionOnDeals() throws InterruptedException {
			Thread.sleep(5000);	
			driver.get("https://www.costco.com/");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebElement deals = driver.findElement(By.xpath("//a[@id='Home_Ancillary_2']"));
			Thread.sleep(5000);
			actions = new Actions(driver); 
			actions.moveToElement(deals).build().perform();
			Thread.sleep(5000);
			List<WebElement> listofDeals =  driver.findElements(By.xpath("//a[@id='Home_Ancillary_2']//child::div//child::div//child::div//child::div//child::div"));
			int numberOfElements = listofDeals.size();
			System.out.println("Number of web Elements: "+ numberOfElements);
			for(int i=0; i<numberOfElements; i++) {
				System.out.println(listofDeals.get(i).getText());
			}
			// repeating 3 times, there is an issue
			
		}
		*/
		
		// How to read the content of a Table 
		@Test(enabled = false)
		public void read_table () throws InterruptedException {
			Thread.sleep(5000);	
			driver.get("https://www.amazon.com");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Thread.sleep(5000);
			// Scrolled to the end of page
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
			Thread.sleep(5000);
			// WebElement table = driver.findElement(By.tagName("table")); // we can use tag name too
			WebElement table = driver.findElement(By.cssSelector("table.navFooterMoreOnAmazon")); 
			System.out.println(table.getText());
			Thread.sleep(5000);
		}
		
		// How to read the row of a Table 
		@Test(enabled = false)
		public void readAnyRowofTheTable () throws InterruptedException {
			Thread.sleep(5000);	
			driver.get("https://www.amazon.com");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Thread.sleep(5000);
			actions = new Actions(driver); 
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
			Thread.sleep(5000);
			WebElement row = driver.findElement(By.cssSelector("table.navFooterMoreOnAmazon tr:nth-child(1)"));
			System.out.println(row.getText());
			Thread.sleep(5000);
		}
		
		// How to read a cell of a Table 
		@Test(enabled = false)
		public void readAnyCellOfARowofTheTable () throws InterruptedException {
			Thread.sleep(5000);	
			driver.get("https://www.amazon.com");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Thread.sleep(10000);
			//actions = new Actions(driver); 
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
			Thread.sleep(5000);
			WebElement cell = driver.findElement(By.cssSelector("table.navFooterMoreOnAmazon tr:nth-child(3) td:nth-child(1)"));
			System.out.println(cell.getText());	
			Thread.sleep(5000);
		}
		
		@Test(enabled = false)
		public void switchBetweenWindow01 () throws InterruptedException {
			Thread.sleep(5000);	
			String parentWindow = driver.getWindowHandle();
			System.out.println("Parent Window ID: " + parentWindow + "\n");
			Thread.sleep(3000);
			WebElement learnMoreAbout = driver.findElement(By.xpath("//a[text()='Learn more about Enterprise Portal']"));
			js.executeScript("arguments[0].scrollIntoView(true);", learnMoreAbout); // Please memorize it, semicolon after method and method name starts with lower case and follow camel case feature
			Thread.sleep(5000);
			js.executeScript("arguments[0].click()", learnMoreAbout);
			js.executeScript("arguments[0].click()", learnMoreAbout); // clicking again 
			// very very important interview question 100%:  How you handle windows from parent to child? 
			// or how you can recognize the parent and child window	
			// getWindowHandles() -- Get all window handles -- include parent + child = Total 3 here
			// why we are using set? because we don't want duplicate, and set doesn't allow duplicate [a set of String]
			Set<String> allWindowHandles = driver.getWindowHandles();
			System.out.println("Total Windows Opened: " + allWindowHandles.size()); 
			// Extract Parent and child window from all window handles
			String parent = (String)allWindowHandles.toArray()[0];
			String child1 = (String)allWindowHandles.toArray()[1];
			String child2 = (String)allWindowHandles.toArray()[2];
			System.out.println("Parent Window ID: " + parent + "\n");
			System.out.println("Child1 Window ID: " + child1 + "\n");
			System.out.println("Child2 Window ID: " + child2 + "\n");
			// Then switch from one window to other window (parent to child) by below
			driver.switchTo().window(child1); // interview question
			Thread.sleep(4000);
			WebElement header = driver.findElement(By.xpath("//h1[text()=' CMS Enterprise Portal - Help Center']"));
			System.out.println("The Text for the Web Element is: " + header.getText());
			String actual = header.getText();
			String expected = "CMS Enterprise Portal - Help Center";
			Assert.assertEquals(actual, expected, "The driver didn't moved to the child 1 window");
			//System.out.println("The driver moved to the child 1 window");
		}
		// see next switchBetweenWindow04 () and switchBetweenWindow05 ()
		
		@Test(enabled = false)
		public void switchBetweenWindow02 () throws InterruptedException {
			Thread.sleep(5000);	
			driver.get("https://demoqa.com/browser-windows");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			String parentWindow = driver.getWindowHandle();
			System.out.println("Parent Window ID: " + parentWindow + "\n");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[text()='New Window']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[text()='New Window']")).click();  // clicked twice to open 2 child window
			Thread.sleep(3000);
			// very very important interview question 100%:  How you handle windows from parent to child? 
			// or how you can recognize the parent and child window	
			// getWindowHandles() -- Get all window handles -- include parent + child = Total 3 here
			// why we are using set? because we don't want duplicate, and set doesn't allow duplicate [a set of String]
			Set <String> allWindowHandles =  driver.getWindowHandles();
			System.out.println("Total Windows Opened: " + allWindowHandles.size()); 
			// Extract Parent and child window from all window handles
			String parent =(String)allWindowHandles.toArray()[0];
			String child1 = (String)allWindowHandles.toArray()[1];
			String child2 = (String)allWindowHandles.toArray()[2];
			System.out.println("Parent Window ID: " + parent + "\n");
			System.out.println("Child1 Window ID: " + child1 + "\n");
			System.out.println("Child2 Window ID: " + child2 + "\n");
			// Then switch from one window to other window (parent to child) by below
			driver.switchTo().window(child1);
			WebElement header = driver.findElement(By.id("sampleHeading"));
			System.out.println("The Text for the Web Element is: " + header.getText());
			System.out.println("The driver moved to the child 1 window");
					
		}
		
		// same way for moving from child to window for different url
		@Test(enabled = false)
		public void switchBetweenWindow03 () throws InterruptedException {
			Thread.sleep(5000);	
			driver.get("https://enthrallit.com");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			// to click seelenium
			driver.findElement(By.xpath("//a[text()='Selenium']")).click();
			Thread.sleep(3000);
			
			// This will scroll up the page by 1000 pixel vertically
			Thread.sleep(4000); // used to see the scroll
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)", ""); // scroll down
			Thread.sleep(4000);
			
			String mainWindow = driver.getWindowHandle(); // learn this line
			System.out.println("Main Window ID: " + mainWindow + "\n");
			
			// click on the Open Window button
			driver.findElement(By.xpath("(//button[text()='Open Window'])[1]")).click();
			Thread.sleep(5000);
			// interview question:  How you handle windows from parent to child? or how you can recognize the parent and child window
			
			// Get all window handles -- include parent + child
			// why we are using set? because we don't want duplicate, and set doesn't allow duplicate
			Set<String> allWindowHandles = driver.getWindowHandles();
			System.out.println("Windows Open After Click: " + allWindowHandles.size());
			
			// Extract Parent and child window from all window handles
			String parent = (String) allWindowHandles.toArray()[0]; // first index: parent
			String child = (String) allWindowHandles.toArray()[1]; // second index: child 

			//	Use window handle to switch from one window to other window (parent to child)
			driver.switchTo().window(child); // switchTo() -- method is used to switch from one to another
			System.out.println("The driver moved to the child window");
			
		}
		
		// different way for moving from child to window for different url
		@Test(enabled = false)
		public void switchBetweenWindow04 () throws InterruptedException {
			Thread.sleep(5000);	
			driver.get("https://enthrallit.com");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Thread.sleep(7000);	
			driver.findElement(By.xpath("//a[text()='Selenium']")).click();
			Thread.sleep(3000);
			
			// This will scroll up the page by 1000 pixel vertically
			Thread.sleep(4000); // used to see the scroll
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)", ""); // scroll down
			Thread.sleep(4000);
			
			String mainWindow = driver.getWindowHandle(); // learn this line
			System.out.println("Main Window ID: " + mainWindow + "\n");
			
			// click on the Open Window button
			driver.findElement(By.xpath("(//button[text()='Open Window'])[1]")).click();
			Thread.sleep(5000);
			
			// interview question:  How you handle windows from parent to child? or how you can recognize the parent and child window
			
			// Get all window handles -- include parent + child
			// why we are using set? because we don't want duplicate, and set doesn't allow duplicate
			Set<String> allWindowHandles = driver.getWindowHandles();
			System.out.println("Total Windows Open: " + allWindowHandles.size());
			
			// for each loop, line 1284, get title and get current url is not related to this code
			for (String wh : allWindowHandles) {
				if (mainWindow.equals(wh)) {
					System.out.println("\t Parent: \t" + wh + "\n \t URL: \t \t" + driver.getCurrentUrl()
							+ "\n \t Title: \t \t" + driver.getTitle());
				} else {
					driver.switchTo().window(wh);
					System.out.println("\t Child: \t" + wh + "\n \t URL: \t \t" + driver.getCurrentUrl()
							+ "\n \t Title: \t \t" + driver.getTitle());
				}
			}		
			
		}
		
		// different way for moving from child to window for different url
		@Test(enabled = false)
		public void switchBetweenWindow05 () throws InterruptedException {
			Thread.sleep(5000);	
			driver.get("https://www.amerihealth.com/");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Thread.sleep(7000);	
			
			WebElement careers = driver.findElement(By.xpath("//a[text()='Careers']"));
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", careers);
			Thread.sleep(5000);
			js.executeScript("arguments[0].click()", careers);
			Thread.sleep(5000);
			
			String mainWindow = driver.getWindowHandle(); // learn this line
			System.out.println("Main Window ID: " + mainWindow + "\n");
			
			// click on the see current job opening
			driver.findElement(By.xpath("//a[text()='See current job openings']")).click();
			Thread.sleep(5000);
			
			// interview question:  How you handle windows from parent to child? or how you can recognize the parent and child window
			
			// Get all window handles -- include parent + child
			// why we are using set? because we don't want duplicate, and set doesn't allow duplicate
			Set<String> allWindowHandles = driver.getWindowHandles();
			System.out.println("Total Windows Open: " + allWindowHandles.size());
			
			// for each loop, line 1284, get title and get current url is not related to this code
			for (String wh : allWindowHandles) {
				if (mainWindow.equals(wh)) {
					System.out.println("\t Parent: \t" + wh + "\n \t URL: \t \t" + driver.getCurrentUrl()
							+ "\n \t Title: \t \t" + driver.getTitle());
				} else {
					driver.switchTo().window(wh);
					System.out.println("\t Child: \t" + wh + "\n \t URL: \t \t" + driver.getCurrentUrl()
							+ "\n \t Title: \t \t" + driver.getTitle());
				}
			}	
			
			// type "QA" in find jobs and click on Search.	
			WebElement findJobs = driver.findElement(By.xpath("//input[@id='keyword']"));
			js.executeScript("arguments[0].value = 'Technician'", findJobs);
			Thread.sleep(3000);
			WebElement search = driver.findElement(By.xpath("//span[text()='Search']"));
			js.executeScript("arguments[0].click()", search);
			Thread.sleep(5000);
			
		}
		
		
		
		
		
		
		

			
}




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

