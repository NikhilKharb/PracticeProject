package PracPro.PracPro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/");

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector(".H6-NpN._3N4_BX"))).build().perform();
		System.out.println(driver.findElement(By.cssSelector("._3YjYK7.ecs1XG")).isDisplayed());
		WebElement searchbox = driver.findElement(By.xpath("//input[@class='Pke_EE']"));
		a.moveToElement(searchbox).click().keyDown(Keys.LEFT_SHIFT).sendKeys("lenovo laptops").build().perform();
		// a.moveToElement(searchbox).click().keyDown(Keys.BACK_SPACE).build().perform();
		a.moveToElement(searchbox).contextClick().build().perform();
	}

}
