package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class first {
	WebDriver driver;
	@BeforeTest
	public void start(){
		driver = new FirefoxDriver();
		driver.get("http://www.facebook.com");
		System.out.println("first program");
	}
	
	@BeforeMethod
	public void before(){
		System.out.println("before method");
	}
	
	@AfterMethod
	public void after(){
		System.out.println("after method");
	}
	

	@Test
	public void Test1(){
		String expectedtitle = "Facebook - Log In or Siggn Up";
		String actualtitle = driver.getTitle();
		System.out.println("A");
	  Assert.assertEquals(expectedtitle, actualtitle);
	  System.out.println("B");
	}
	
	@Test
	public void second(){
		throw new SkipException("dont know");
		//System.out.println("thrid program");
	}
	
	@Test(dependsOnMethods="second")
	public void  thrid(){
		System.out.println("fourth program");
	}
	
	@AfterTest
	public void last(){
		driver.quit(); 
		System.out.println("closing");
	}
}
