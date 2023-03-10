package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

public class Steps {

	public WebDriver driver;
	public LoginPage lp;


	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");

		//WebDriverManager.chromedriver().setup();

		WebDriverManager.chromedriver().driverVersion("110.0.5481").setup();

		driver = new ChromeDriver(options);

		//System.setProperty("webdriver.chrome.driver", "/Users/amarthyanadh/eclipse-workspace/Project_Cucumber/Drivers/chromedriver");

		lp=new LoginPage(driver);
	}

	@When("user open {string}")
	public void user_open(String url) {

		driver.get(url);
	}

	@When("user enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String uname, String pwd) {

		lp.setUserName(uname);
		lp.setPassword(pwd);

	}

	@When("click on login")
	public void click_on_login() {

		lp.clickLogin(); 
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String txt) throws InterruptedException {

		if(driver.getPageSource().contains("Login was unsuccessful")) {
			driver.quit();
			Assert.assertTrue(false);
		}
		else {
			String expected = driver.getTitle();
			Assert.assertEquals(txt, expected);
		}
		
		Thread.sleep(3000);

	}

	@When("user click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {

		lp.clickLogout();
		Thread.sleep(3000);
	}


	@Then("close browser")
	public void close_browser() {

		driver.quit();

	}
}
