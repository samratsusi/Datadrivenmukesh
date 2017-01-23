package DDT;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.ReadExcel;

public class wordpresslogin {
	WebDriver driver;
	
	@BeforeTest
	public void open(){
		 driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://jcpenny.com");
	}
	
	
	@Test
	public void testapp() throws IOException{
		//this is an data with 2 dimensional array
		  String[][] data = ReadExcel.getData("TestData.xlsx", "Sheet1");
	for(int i = 1; i < data.length; i ++){
			String Username = data[i][0];
			String Password = data[i][1];	
		 
		driver.findElement(By.xpath("//*[@id='coldState']/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id='emailidLogin']")).sendKeys(Username);
		driver.findElement(By.xpath("//*[@id='mypasswdLogin']")).sendKeys(Password);
		driver.findElement(By.xpath("//*[@id='signIn']")).click();
		String message = driver.findElement(By.xpath("//*[@id='serverErrors']")).getText();
		System.out.println(message);
		driver.navigate().back();
	}
  }
	@AfterTest
	public void close(){
		driver.quit();
	}
}
