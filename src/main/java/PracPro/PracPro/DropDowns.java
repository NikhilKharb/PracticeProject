package PracPro.PracPro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDowns {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// Thread.sleep(500);
		// Select drop downs
		WebElement ddown = driver.findElement(By.xpath("//select[@name='ctl00$mainContent$DropDownListCurrency']"));
		Select dropdown = new Select(ddown);

//		dropdown.selectByIndex(2);
//		String s = dropdown.getFirstSelectedOption().getText();
//		System.out.println(s);
//		dropdown.selectByValue("USD");
//		String s1 = dropdown.getFirstSelectedOption().getText();
//		System.out.println(s1);
		// Select currency
		dropdown.selectByVisibleText("INR");
		String s2 = dropdown.getFirstSelectedOption().getText();
		System.out.println(s2);

		// Select passnger count
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(500);
		int count = 1;
		while (count < 4) {
			driver.findElement(By.id("hrefIncAdt")).click();
			count++;
		}
		int countchild = 0;
		while (countchild < 2) {
			driver.findElement(By.id("hrefIncChd")).click();

			countchild++;
		}
		System.out.println(driver.findElement(By.id("spanAudlt")).getText());
		System.out.println(driver.findElement(By.id("spanChild")).getText());

		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		driver.quit();

	}

}
