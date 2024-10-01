package PracPro.PracPro;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automationclass {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		addToCart(driver);
		goToCart(driver);

		driver.quit();
	}

	public static void addToCart(WebDriver driver) {

		String[] itemsrequired = { "Brocolli", "Cucumber" };

		List<WebElement> itemsonpage = driver.findElements(By.xpath("//h4[@class='product-name']"));
		int itemsAdded = 0;

		ArrayList<String> itemList = new ArrayList<>(Arrays.asList(itemsrequired)); // Move outside loop for
																					// efficiency

		for (int i = 0; i < itemsonpage.size(); i++) {
			String itemname = itemsonpage.get(i).getText().split("-")[0].trim();

			if (itemList.contains(itemname)) {
				// Click on ADD TO CART button
				WebElement addButton = driver.findElements(By.xpath("//div[@class='product-action']")).get(i);
				System.out.println(itemname);

				addButton.click();
				itemsAdded++;

				// Break the loop if all items are added
				if (itemsAdded == itemsrequired.length) {
					System.out.println("Added items: " + itemsAdded);
					// Thread.sleep(1000);

					break;
				}
			}

		}

	}

	public static void goToCart(WebDriver driver) {
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		System.out.println(driver.findElement(By.cssSelector(".discountPerc")).getText());
		driver.findElement(By.cssSelector(".promoBtn")).click();
		System.out.println("Promo code message - " + driver.findElement(By.cssSelector(".promoInfo")).getText());
		System.out.println("Percentage of discount - " + driver.findElement(By.cssSelector(".discountPerc")).getText());
		System.out.println(
				"Total amount of the items in the cart - " + driver.findElement(By.cssSelector(".totAmt")).getText());
		System.out.println("Amount after discount - " + driver.findElement(By.cssSelector(".discountAmt")).getText());

		// driver.findElement(By.cssSelector(".promoBtn")).click();

	}

}
