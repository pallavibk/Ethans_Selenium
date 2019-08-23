package day5;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class indo_Handles2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Programs\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
		String Par_window=driver.getWindowHandle();
		driver.findElement(By.xpath("//a[contains(text(),'Follow All')]")).click();
		Set<String> allwindow=driver.getWindowHandles();
		
		for(String temp:allwindow)
		{
			
		
			if(!temp.contentEquals(Par_window))
			{
				driver.switchTo().window(temp);
				Thread.sleep(2000);
				System.out.println();
				System.out.println(driver.getCurrentUrl());
			if(temp.contains("https://twitter.com/intent/follow?screen_name=seleniumeasy"))
			{
				driver.findElement(By.xpath("//label[@for='username_or_email']")).click();
			    driver.findElement(By.xpath("//label[@for='username_or_email']")).sendKeys("Pallavi@titter.com");
			}
			
			}
		}
}
}
