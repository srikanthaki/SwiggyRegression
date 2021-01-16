package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Restaurants {
	WebDriver driver = Setup.driver;
	ExtentReports extent;
	ExtentTest logger;

	@Given("^User is on swiggy home page opened$")
	public void user_is_on_swiggy_home_page_opened() throws Throwable {
		driver.get("https://www.swiggy.com/");
	}

	@When("^User entered delivery location \"([^\"]*)\"$")
	public void user_entered_delivery_location_something(String location) throws Throwable {
		WebElement tbSearch = driver.findElement(By.id("location"));
		tbSearch.sendKeys(location);
		WebElement tbLocation = driver.findElement(By.xpath("//span[text()='Kakinada, Andhra Pradesh, India']"));
		tbLocation.click();

	}

	@Then("^user able to get the list of restaurants avalable in the respective location$")
	public void user_able_to_get_the_list_of_restaurants_avalable_in_the_respective_location() throws Throwable {
		String url = driver.getCurrentUrl();
		Thread.sleep(20000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		String count = driver.findElement(By.cssSelector(".BZR3j")).getText();
		// String no=String(count);
		System.out.println(url);
		System.out.println(count);
		extent = new ExtentReports(System.getProperty("user.dir") + "/extent.html", false);

		logger = extent.startTest("Restaurents");

		logger.log(LogStatus.INFO, "No of Resturents ");
		extent.endTest(logger);
		extent.flush();
		extent.close();


	}

}
