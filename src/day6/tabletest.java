package day6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tabletest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");

		// Initialize browser
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.toolsqa.com/automation-practice-table/\r\n");
		
		WebElement tbody=driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody"));
		List<WebElement> trs=tbody.findElements(By.tagName("tr"));
		List<WebElement> tds=trs.get(0).findElements(By.tagName("td"));
		System.out.println(tds.get(1).getText());
		
		
		
	}

}
