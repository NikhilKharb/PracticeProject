package PracPro.PracPro;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AutoSuggestDropDown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		Thread.sleep(2000);

		List<WebElement> list = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		for (WebElement country : list) {
			if (country.getText().equalsIgnoreCase("India")) {
				country.click();
				break;
			}
		}
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isSelected());

		// Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='MAA']"))
				.click();
		// Thread.sleep(500);
		System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getText());

		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		// Thread.sleep(500);

		System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getText());

		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']"))
				.click();

//		if(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected()) {
//			
//		}else {
//			
//		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
//		}

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		driver.findElement(By.cssSelector("#ctl00_mainContent_view_date2")).click();
		driver.findElement(By.xpath("(//a[text()='30'])[1]")).click();
		
		
		 driver.quit();

	}

}
