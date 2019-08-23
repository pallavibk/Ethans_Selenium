package day6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tabletest3 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");

		// Initialize browser
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/mercuryreservation2.php");
		
		
		
		WebElement tbody=driver.findElement(By.xpath("//input[@name='servClass']/following::table[1]/tbody"));
		List<WebElement> trs=tbody.findElements(By.xpath("//input[@name='servClass']/following::table[1]/tbody/tr[5]"));
		for(int i=0;i<trs.size();i++)
		{
			List<WebElement> tds=trs.get(i).findElements(By.xpath("//input[@name='servClass']/following::table[1]/tbody/tr[5]/td/input[@value='Blue Skies Airlines$361$271$7:10']"));
			for(int j=0;j<tds.size();j++)
			{
				System.out.print(tds.get(j).getText()+" ");
				if(tds.get(j).getText().contains("pangae"))
				{
					tds.get(j-1).click();
				}
			}
			System.out.println();
			
			
		}
		
		
		
		
	}

}
