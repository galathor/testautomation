package cucumber;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	
	WebDriver driver;
	WebElement searchbox;
	
	@Given("launch the browser")
	public void launch_the_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@When("Hit Petclinic on the browser")
	public void hit_petclinic_on_the_browser() {
		driver.get("http://localhost:8088/");
	}
	@Then("Enter {string} in the search box")
	public void enter_in_the_search_box(String string) {
		driver.findElement(By.cssSelector("a[href=\"/owners/find\"]")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("a[href=\"/owners/find\"]")).getText(),"FIND OWNERS" );
		driver.findElement(By.id("lastName")).sendKeys(string);
	}
	@Then("Search it")
	public void search_it() {
		driver.findElement(By.cssSelector("input[id=\"lastName\"]")).sendKeys(Keys.ENTER);
	}
	@Then("Verify User")
	public void verify_user() throws InterruptedException {
	    Assert.assertTrue(driver.findElement(By.cssSelector("a[href=\"11/edit\"]")).isDisplayed());
		Thread.sleep(3000);

	}
	@After
	public void quit_it() {
		driver.quit();
	}

}
