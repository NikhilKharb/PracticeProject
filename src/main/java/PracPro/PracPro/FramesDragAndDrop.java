package PracPro.PracPro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDragAndDrop {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();

		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		
		Actions a= new Actions(driver);
		
		WebElement b1 =driver.findElement(By.id("draggable"));
		WebElement b2 =driver.findElement(By.id("droppable"));
		a.dragAndDrop(b1, b2).build().perform(); 
		driver.quit();
	}

}
