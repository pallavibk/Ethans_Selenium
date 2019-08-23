package day8;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest {
	 	WebDriver driver;
  @Test(priority=1)
  public void LoginFunctionality() {
	driver.findElement(By.name("userName")).sendKeys("batman");
	driver.findElement(By.name("password")).sendKeys("batman");
	driver.findElement(By.name("login")).click();
	 
  }
  
  /*@Test(priority=1,description="verification of login")
  public void RegistreationFunctionality() {
	 // Assert.assertEquals(driver.getTitle(), "");
	 
  }*/
  @Test(priority=2,description="verification of DD")
  public void DropDonVerification() {
	  WebElement ele=driver.findElement(By.name("toPort"));
	  Select obj=new Select(ele);
	  
	  List<String> ExpectedList=Arrays.asList("Acapulco","Frankfurt","London","New York","Paris","Portland","San Francisco","Seattle","Sydney","Zurich");
	
	  
			
			  List<WebElement> alloptions=obj.getOptions();
			  List<String> actualList= new ArrayList<>();
			
			  
			  for(WebElement v:alloptions)
			  {
				  actualList.add(v.getText());
			  }
			  Assert.assertEquals(actualList, ExpectedList);	
	 
  }
  @Test(priority=3,description="verification of DD")
  public void radioVerification() {
	  
	  WebElement ele=	  driver.findElement(By.xpath("//input[@value='roundtrip']"));
	  ele.click();
	 boolean b= ele.isSelected();
	 Assert.assertEquals(b, "true");

  }
  
  @BeforeClass
  public void environmentsetup() {
	  
	  System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");

		// Initialize browser
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
}
  @AfterClass
  public void afterClass() {
	  
	  driver.close();
  }

}

