package com.ShoppersStack.genericUtility;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import com.ShoppersStack.pom.Home_Page;
import com.ShoppersStack.pom.Login_Page;
import com.ShoppersStack.pom.Welcome_Page;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base_Test {
	public WebDriver driver;
	static WebDriver listenersDriver;
	public File_Utility file = new File_Utility();
	public Welcome_Page welcomePage;
	public Login_Page loginPage;
	public Home_Page homePage;
	public WebDriver_Utility webDriverUtility = new WebDriver_Utility();
	
	
	public void beforeSuite() {
		System.out.println("@BeforeSuite");	
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest");
	}
	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("@BeforeClass");
		
		String browser =file.readPropertyData("browser");
		String url=file.readPropertyData("url");
		
//		String browser = System.getProperty("browser");  // for cmd
//		String url = System.getProperty("url");
		
		
		if(browser.contains("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if (browser.contains("firefox"))
		{

			driver= new FirefoxDriver();
		}
		else if (browser.contains("edge")) 
		{
			driver= new EdgeDriver();

		}
		else {
			System.out.println("Enter valid browser name");
		}
		listenersDriver = driver;
		welcomePage = new Welcome_Page(driver);
		loginPage = new Login_Page(driver);
		homePage = new Home_Page(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get(url);
		

	}
	@BeforeMethod
	public void beforeMethod() throws IOException {
		System.out.println("@BeforMethod");
		welcomePage.getLoginBtn().click();
		loginPage.getEmailTB().sendKeys(file.readPropertyData("email"));
		loginPage.getPasswordTB().sendKeys(file.readPropertyData("password"));
		loginPage.getLoginBtn().click();
		
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");
		homePage.getAccountSettingBtn().click();
		homePage.getLogoutBtn().click();
	}
	
	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("@AfterClass");
		Thread.sleep(3000);
		driver.quit();
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("@AfterSuite");
	}
	
	}
