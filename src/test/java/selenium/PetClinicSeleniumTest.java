package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PetClinicSeleniumTest {

	WebDriver driver;
	WebElement element;
	
	@BeforeTest
	public void firstStep() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://localhost:8088/");


	}

	@Test(priority = 0)
	public void startUp() {
		System.out.println(driver.findElement(By.cssSelector("a[href=\"/owners/find\"]")).getText());
		driver.findElement(By.cssSelector("a[href=\"/owners/find\"]")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("a[href=\"/owners/find\"]")).getText(),"FIND OWNERS" );
		

	}
	
	@Test(priority = 1)
	public void clickSearch() {
		
		driver.findElement(By.id("lastName")).sendKeys("kemal");
		driver.findElement(By.xpath("//*[@id=\"search-owner-form\"]/div[2]/div/button")).click();
		if (driver.findElement(By.className("help-inline")).isDisplayed()) {
			driver.findElement(By.cssSelector("a[href=\"/owners/new\"]")).click();
		}
	}

}
