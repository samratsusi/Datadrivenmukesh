package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ie {
	WebDriver driver;
	@BeforeTest
	public void start(){
	//	System.setProperty("webdriver.edge.driver", "T:\\selenium drivers\\MicrosoftWebDriver.exe");
	//	driver = new EdgeDriver();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://facebook.com");
	
	}

	@Test
	public void verifytitle(){
		String expectedvalue = "Facebook helps you connect and share with the people in your life.";
		String actualvalue = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/div/div/div/div/div[1]/div/div")).getText();
		//String expectedvalue = "Facebook - Log In or Sign Up";
		//String actualvalue = driver.getTitle();
		System.out.println(actualvalue);
		//Assert.assertEquals(actualvalue, expectedvalue);
	}
}
