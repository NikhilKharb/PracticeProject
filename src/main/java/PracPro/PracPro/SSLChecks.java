package PracPro.PracPro;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLChecks {

	public static void main(String[] args) {

		ChromeOptions opt = new ChromeOptions();
		//handle ssl
		opt.setAcceptInsecureCerts(true);
		//handle pop ups
		opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		WebDriver driver = new ChromeDriver(opt);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		driver.quit();
		
	}

}
