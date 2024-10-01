package PracPro.PracPro;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();

		driver.get("https://book.spicejet.com/");

		// driver.findElement(By.xpath("(//input[@value='RoundTrip'])[1]")).click();
		driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT"))
				.click();

		driver.findElement(By.xpath("(//a[@value='DEL'])[1]")).click();
		driver.findElement(By.xpath("(//a[@value='ATQ'])[2]")).click();
//		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

		while (!driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[1]")).getText()
				.contains("November")) {
			driver.findElement(By.xpath("//a[@data-handler='next']")).click();
		}
		Thread.sleep(3000);

		List<WebElement> dates = driver.findElements(By.cssSelector(".ui-state-default"));

		int count = driver.findElements(By.xpath("//td[@data-handler='selectDay']")).size();
		for (int i = 0; i < count; i++) {
			String date = driver.findElements(By.xpath("//td[@data-handler='selectDay']")).get(i).getText();
			if (date.equalsIgnoreCase("30")) {
				driver.findElements(By.xpath("//td[@data-handler='selectDay']")).get(i).click();
				break;
			}
		}

		driver.quit();

	}

}
