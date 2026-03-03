package Day01;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleMultpleWindowsDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		String parentWinId = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]")).click();

		Set<String> allWindowIDs = driver.getWindowHandles();
		System.out.println("All windows IDs");
		for(String winId:allWindowIDs)
		{
			System.out.println(winId);
		}

		System.out.println("************************");
		for (String winId : allWindowIDs)
		{
			if(!winId.equals(parentWinId))
			{
				System.out.println("Switching to " + winId + " windown");
				driver.switchTo().window(winId);
				break;
			}
		}

		driver.quit();

	}

}
