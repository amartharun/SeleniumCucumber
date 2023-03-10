package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {


	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");

		//WebDriverManager.chromedriver().setup();
		
		WebDriverManager.chromedriver().driverVersion("110.0.5481").setup();
		
		WebDriver driver = new ChromeDriver(options);

		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver");

		//System.setProperty("webdriver.chrome.driver","/Users/amarthyanadh/Downloads/chromedriver");

			driver.get("https://www.demoqa.com");
			System.out.println("Finished...........");
	
			driver.quit();
	}
}
