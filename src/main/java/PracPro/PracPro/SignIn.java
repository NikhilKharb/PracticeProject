package PracPro.PracPro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignIn {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath("//a[text()='Forgot your password?']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Nikhil");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("kharb.nikhil@ymail.com");

		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9999999999");

		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();

		String ss = driver.findElement(By.xpath("(//p)[1]")).getText();

		String ars[] = ss.split(" ");
		String pass[] = ars[4].split("'");

		for (String ar : pass) {
			System.out.println(ar);
		}

		driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();

		driver.findElement(By.id("inputUsername")).sendKeys("kharb.nikhil@ymail.com");
		driver.findElement(By.name("inputPassword")).sendKeys(pass);

		Thread.sleep(500);

		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.cssSelector(".submit")).click();

		System.out.println(driver.getTitle());

		driver.quit();

	}

}
