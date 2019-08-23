package day5;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class window_handling {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Programs\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.toolsqa.com/automation-practice-switch-windows/");
		String Par_window=driver.getWindowHandle();
		System.out.println(Par_window);
		driver.findElement(By.xpath("//button[@id='button1']")).click();
		Set<String> allwindow=driver.getWindowHandles();
		System.out.println(allwindow);
		
		for(String temp:allwindow)
		{
			if(!temp.contentEquals(Par_window))
			{
				driver.switchTo().window(temp);
				Thread.sleep(2000);
				driver.close();
			}
		}
	}

}
