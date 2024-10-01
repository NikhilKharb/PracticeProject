package PracPro.PracPro;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollClass {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,600)");
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
		List<WebElement> amounts = driver.findElements(By.xpath("//table[@id='product'] //td[4]"));
		int sum = 0;
		for (WebElement amount : amounts) {

			int amt = Integer.parseInt(amount.getText());

			sum = sum + amt;
		}
		String s = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText();
		String[] totamt = s.split(": ");

		Assert.assertEquals(Integer.parseInt(totamt[1]), sum);
		
		System.out.println("Tota sum of Test:Application is - "+sum+":"+Integer.parseInt(totamt[1]));
		driver.quit();

	}
}
