package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Verifytabs {
	WebDriver driver = Setup.driver;
	ExtentReports extent;
	ExtentTest logger;


	@Given("^User is having swiggy home page$")
	public void user_is_having_swiggy_home_page() throws Throwable {
		driver.get("https://www.swiggy.com/");
	}

	@When("^User enter delivery location \"([^\"]*)\"$")
	public void user_enter_delivery_location_something(String location) throws Throwable {
		Thread.sleep(3000);
		WebElement tbSearch = driver.findElement(By.id("location"));
		tbSearch.sendKeys(location);
		WebElement tbLocation = driver.findElement(By.xpath("//span[text()='Kakinada, Andhra Pradesh, India']"));
		tbLocation.click();
		
	}

	@When("^User click on Costfortwo tab$")
	public void user_click_on_costfortwo_tab() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Cost For Two']")).click();
	}

	@Then("^Costfortwo filter  should be Applied$")
	public void costfortwo_filter_should_be_applied() throws Throwable {
		Thread.sleep(3000);
		driver.getCurrentUrl();
		extent = new ExtentReports(System.getProperty("user.dir") + "/extent.html", false);

		logger = extent.startTest("VerifyTabs");

		logger.log(LogStatus.INFO, "Verift Tabs");
		extent.endTest(logger);
		extent.flush();
		extent.close();

		
	}

}
