package pagesTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class ForgotUserIdPageTest extends BaseClass {
	
	@Test(enabled = true)
	public void forgotUserIdClickTest() {
		forgotUserId.forgotUserIdClick();
		
		String actual = driver.getTitle();
		System.out.println("The title of the Page is: " + actual);		
		String expected = "CMS Enterprise Portal - Forgot User ID"; // Our expected Title
		Assert.assertEquals(actual, expected, "Forgot User Id Page Title doesn't match");
		
		String currentURL = driver.getCurrentUrl();
		System.out.println("The current url is: " + currentURL);
	}

}
