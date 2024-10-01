package PracPro.PracPro;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();

		// broken URL
		// Step 1 is to get all the urls tied up to the links using selenium
		// Java methods will call the urls and gets you the status code
		// if status code >400 then that url is not working

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		SoftAssert sa = new SoftAssert();

		List<WebElement> urls = driver.findElements(By.xpath("//tbody //a"));

		for (WebElement url : urls) {
			String ur = url.getAttribute("href");
			System.out.println(ur);
			HttpURLConnection conn = (HttpURLConnection) new URL(ur).openConnection();

			conn.setRequestMethod("HEAD");
			conn.connect();

			sa.assertTrue(conn.getResponseCode() < 400,"The URL attached with tag - "+url.getText()+
					" getting response Code - " + conn.getResponseCode() + "URL is not Valid");
		}
		driver.quit();
		sa.assertAll();

	}

}
