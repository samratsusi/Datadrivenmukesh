package demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class asserts {
	SoftAssert soft = new SoftAssert();
	@Test
	public void equals(){
		String expectedvalue = "abcd";
		String actualvalue = "abcd";
		Assert.assertEquals(actualvalue, expectedvalue);
		System.out.println("A");
		String e = "abcd";
		String a = "abc";
		//Assert.assertEquals(a, e);
		soft.assertEquals(a, e);
		System.out.println("B");
		soft.assertAll();
		
	} 

}
