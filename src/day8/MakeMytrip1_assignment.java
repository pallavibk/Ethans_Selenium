package day8;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMytrip1_assignment {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"G:\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.get("https://www.makemytrip.com/flights/");
		d.manage().window().maximize();
		d.manage().deleteAllCookies();

		d.findElement(By.xpath("//input[@id='fromCity']")).click();
		d.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Pune");
		d.findElement(By.xpath("//p[contains(text(),'Pune, India')]")).click();
		d.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Delhi");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
					e.printStackTrace();
		}
		d.findElement(By.xpath("//p[contains(text(),'Delhi, India')]")).click();
		d.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		d.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		d.findElement(By.xpath("//div[@aria-label='Sat Jul 13 2019']")).click();
		d.findElement(By.xpath("//a[@class='primaryBtn font24 latoBlack widgetSearchBtn ']")).click();
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("window.scrollBy(0,-4000)");
       List<WebElement> price = d.findElements(By.xpath("//span[@class='actual-price']/span"));
		System.out.println(price.size());

		ArrayList a = new ArrayList();
		int test = 0;
		for (int i = 0; i < price.size(); i++) {

			a.add(price.get(i).getText());

		}
		System.out.println(a);
		Collections.sort(a, Collections.reverseOrder());
		System.out.println(a);

		String max = (String) a.get(0);
		System.out.println(max);
		for (int i = 0; i < price.size(); i++) 
		{
			if (price.get(i).getText().equals(max))
			{
				System.out.println("Entered If Condition");
				d.findElement(By.xpath("//div[contains(@class, \"pull-left price\") "
						+ "and .//span[text() = \""+ max.substring(3) +"\"]]"
						+ "/following-sibling::div/button[text() = \"Book Now\"]")).click();
			}
		}
		
		}

}
