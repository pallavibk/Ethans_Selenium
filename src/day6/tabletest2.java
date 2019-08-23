package day6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tabletest2 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");

		// Initialize browser
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.toolsqa.com/automation-practice-table/\r\n");
		
		WebElement tbody=driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody"));
		List<WebElement> trs=tbody.findElements(By.tagName("tr"));
		for(int i=0;i<trs.size();i++)
		{
			List<WebElement> tds=trs.get(i).findElements(By.tagName("td"));
			for(int j=0;j<tds.size();j++)
			{
				System.out.print(tds.get(j).getText()+" ");
			}
			System.out.println();
			
			
		}
		
		
		
		
	}

}
