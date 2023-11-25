package pagesTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class ForgotUserIdPageTest extends BaseClass {
	
	@Test(enabled = false)
	public void forgotUserIdClickTest() {
		forgotUserId.forgotUserIdClick();
		
		String actual = driver.getTitle();
		System.out.println("The title of the Page is: " + actual);		
		String expected = "CMS Enterprise Portal - Forgot User ID"; // Our expected Title
		Assert.assertEquals(actual, expected, "Forgot User Id Page Title doesn't match");
		
		String currentURL = driver.getCurrentUrl(); // We can do same like above
		System.out.println("The current url is: " + currentURL);
	}
	
	// drop down, all 3 categories
	// drop down is a commonly asked interview question
	// here we are using selectByIndex() method
	// This method is not suggested, or not used much
	// Because, adding a new web element or deleting a new one can change the index number	
	@Test(enabled = false)
	public void use_of_dropdown_with_selectByIndex_method() throws InterruptedException {
		forgotUserIdClickTest();
		Thread.sleep(4000);
		WebElement birthDate = driver.findElement(By.xpath("//select[@id='cms-forgotid-birthDate']"));
		select = new Select(birthDate); // Select class instantiated in Base class
		select.selectByIndex(1); // int type index
		Thread.sleep(4000);
	}
	
	// drop down is a commonly asked interview question
	// use method --> selectByValue()
	@Test(enabled = false)
	public void use_of_dropdown_with_selectByValue_method() throws InterruptedException {
		forgotUserIdClickTest();
		Thread.sleep(4000);
		WebElement birthMonth = driver.findElement(By.xpath("//select[@name='cms-forgotid-birthMonth']"));
		select = new Select(birthMonth);
		select.selectByValue("08"); // you have to look for the value attributes, and add here the value of that value attributes
		Thread.sleep(4000);	
	}
	
	// drop down is a commonly asked interview question
	// Most commonly use method in drop down --> selectByVisibleText()
	@Test(enabled = false)
	public void use_of_dropdown_selectByVisibleText_method() throws InterruptedException {
		forgotUserIdClickTest();
		Thread.sleep(4000);
		WebElement birthYear = driver.findElement(By.xpath("//select[@id='cms-forgotid-birthYear']"));
		select = new Select(birthYear);
		select.selectByVisibleText("1995"); // String type Value
		Thread.sleep(4000);
	}
	
	@Test (enabled = true)
	public void forgotUserIdTest() throws InterruptedException {
		forgotUserIdClickTest();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@name='cms-forgotid-firstName']")).sendKeys("Mohammad");
		driver.findElement(By.xpath("//input[@name='cms-forgotid-lastName']")).sendKeys("Sharkar");
		WebElement birthMonth = driver.findElement(By.xpath("//select[@name='cms-forgotid-birthMonth']"));
		WebElement birthDate = driver.findElement(By.xpath("//select[@id='cms-forgotid-birthDate']"));
		WebElement birthYear = driver.findElement(By.xpath("//select[@id='cms-forgotid-birthYear']"));
		select = new Select(birthMonth);
		select.selectByVisibleText("January");
		select = new Select(birthDate);
		select.selectByVisibleText("28");
		select = new Select(birthYear);
		select.selectByVisibleText("1990");
		driver.findElement(By.xpath("//input[@id='cms-forgotid-forgotEmail']")).sendKeys("tofael483@gmail.com");
		driver.findElement(By.xpath("//input[@name='cms-forgotid-zipcode']")).sendKeys("10019");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(5000);		
		
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
