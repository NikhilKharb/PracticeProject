package PracPro.PracPro;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MinimisingScope {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();

		driver.get("http://qaclickacademy.com/practice.php");

		System.out.println(driver.findElements(By.tagName("a")).size());

		WebElement footerdriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		for (int i = 1; i < footerdriver.findElements(By.tagName("a")).size(); i++) {
			String click = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footerdriver.findElements(By.tagName("a")).get(i).sendKeys(click);
		Thread.sleep(500);
			
			
		}
		Thread.sleep(3000);
		int count =0;
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> it = windowhandles.iterator();
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			count++;
		}
		
		System.out.println(count);

		driver.quit();

	}

}
