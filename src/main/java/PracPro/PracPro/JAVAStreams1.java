package PracPro.PracPro;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JAVAStreams1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();

		driver.get("https://www.flipkart.com/");
		driver.findElement(By.className("Pke_EE")).sendKeys("bags" + Keys.ENTER);

		// ArrayList<String> prods = new ArrayList<String>();
		List<WebElement> descs = driver.findElements(By.cssSelector(".WKTcLC.BwBZTg"));

		List<String> prods = descs.stream().filter(s -> s.getText().contains("15")) // Filter by "15"
				.map(WebElement::getText) // Extract text from WebElement
				.collect(Collectors.toList()); // Collect into List<String>
		//List<String> p = descs.stream().map(s->s.getText()).collect(Collectors.toList());

		// Print the filtered products
		prods.forEach(System.out::println);

//		System.out.println(descs.size());
//		for (int i = 0; i < descs.size(); i++) {
//			if (descs.get(i).getText().contains("15")) {
//				prods.add(descs.get(i).getText());
//			}
//		}
//		for (String prod : prods) {
//			System.out.println(prod);
//
//		}
		driver.quit();
	}

}
