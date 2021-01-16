package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUp {
	WebDriver driver = Setup.driver;
	ExtentReports extent;
	ExtentTest logger;

	@Given("^User is having swiggy home page opened$")
	public void user_is_having_swiggy_home_page_opened() throws Throwable {
		driver.get("https://www.swiggy.com/");

	}

	@When("^User are able to verify singup form$")
	public void user_are_able_to_verify_singup_form() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Sign up']")).click();
		String s = driver.getTitle();
		System.out.println(s);

	}

	@Then("^User should able to Enter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void user_should_able_to_enter_somethingsomethingsomethingsomething(String phonenumber, String name,
			String email, String password) throws Throwable {
		WebElement tbPhone = driver.findElement(By.id("mobile"));
		WebElement tbName = driver.findElement(By.id("name"));
		WebElement tbEmail = driver.findElement(By.id("email"));
		WebElement tbPwd = driver.findElement(By.id("password"));

		tbPhone.sendKeys(phonenumber);
		tbName.sendKeys(name);
		tbEmail.sendKeys(email);
		tbPwd.sendKeys(password);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");

	}

	@And("^User should able to signup$")
	public void user_should_able_to_click_on_continue_button() throws Throwable {
//
//		WebElement tbButton = driver.findElement(By.xpath("//input[@type='submit']"));
//
//		tbButton.click();
		extent = new ExtentReports(System.getProperty("user.dir") + "/extent.html", false);

		logger = extent.startTest("SwiggySignUp");

		logger.log(LogStatus.INFO, "Swiggy Sign Up ");
		extent.endTest(logger);
		extent.flush();
		extent.close();

	}

}