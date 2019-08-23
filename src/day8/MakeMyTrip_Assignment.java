package day8;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class MakeMyTrip_Assignment {
	WebDriver driver;
	

	@Test
	public void f() {

		/*
		 * List<String>
		 * ExpectedList=Arrays.asList("Acapulco","Zfd","Frankfurt","London","New York"
		 * ,"Paris","Portland","San Francisco","Seattle","Sydney","Zurich");
		 * Collections.sort(ExpectedList); System.out.println(ExpectedList);
		 * List<Integer> UnsortedList=Arrays.asList(8,6,78,12,69,0,7);
		 * Collections.sort(UnsortedList);
		 * System.out.println("Ascending:"+UnsortedList);
		 * Collections.sort(UnsortedList,Collections.reverseOrder());
		 * System.out.println("descending:"+UnsortedList);
		 */
		
		//select from city
		driver.findElement(By.xpath("//span[contains(text(),'From')]")).click();
		driver.findElement(By.xpath("//div[@role='combobox']/input[@type='text']")).sendKeys("Delhi");
		
		//click on enter
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
		    } 
		 catch (AWTException e) {
			
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//p[@class='font16 appendBottom8' and contains(text(),'Delhi, India')]")).click();
		
		//to selection
		driver.findElement(By.xpath("//span[@class='lbl_input latoBold  appendBottom5' and contains(text(),'To')]")).click();
		driver.findElement(By.xpath("//div[@role='combobox']/input[@placeholder='To']")).sendKeys("Pune");
		
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
		    } 
		 catch (AWTException e) {
			
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[@class='makeFlex hrtlCenter']/div[@class='calc60']/p[@class='font16 appendBottom8' and contains(text(),'Pune, India')]")).click();
		
		//click on search button
		driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBlack widgetSearchBtn ' and contains(text(),'Search')]")).click();
		
	List<WebElement> ele=	driver.findElements(By.xpath("//ul[@class='slider-list']/li"));

	for(int i=0;i<ele.size();i++)
	{
		
	System.out.println(ele.get(i).getText());
	
		/*if(ele.get(i).getText().equals(""))
		{
			ele.get(i).click();
		}*/
	}

	}

	@BeforeClass
	public void environmentsetup() {

		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");

		// Initialize browser
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(" https://www.makemytrip.com/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {

		//driver.close();
	}
}
