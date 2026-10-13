package login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestLogin {
	WebDriver driver;
	loginPage page;
	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest loginTest;

	@BeforeSuite
	public void onStart() {
	ExtentSparkReporter spark = new ExtentSparkReporter("./TestReportp/rep01.html");
	spark.config().setDocumentTitle("Demo Report");
	spark.config().setReportName("Test Suite");
	spark.config().setTheme(Theme.DARK);

	ExtentReports report = new ExtentReports();

	report.attachReporter(spark);
	report.setSystemInfo("Browser","Chrome");
	report.setSystemInfo("OS","Windows 11");
	
//	loginTest = report.createTest("Login");
	}
	@BeforeMethod
	public void setup() {
		String Url = "https://anvnacare.alwaysdata.net/";

		driver = new ChromeDriver();
		driver.manage().window().maximize();;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get(Url);
		driver.findElement(By.id("navLogin")).click();
		driver.findElement(By.id("patientTab")).click();

		page = new loginPage(driver);
	}

	@Test
	public void validCredntial(ITestResult result ) {
		ExtentTest test = report.createTest(result.getName());
		page.login("singh40@gmail.com", "Avii40@#");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
//		loginTest.log(Status.INFO, "log in with validCredntial");
		test.log(Status.PASS, "log in with validCredntial");
	}

	@Test
	public void invalidcredential() {
		page.login("aurya93450@gmail.com", "aman123");
		Assert.assertFalse(driver.findElement(By.id("greetingTitle")).isDisplayed());
		loginTest.log(Status.INFO, "log in with invalidCredntial");
	}

	@Test
	public void invalidusername() {
		page.login("@amanj8e", "Avii40@#");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
		loginTest.log(Status.INFO, "log in with invalidusername");
	}

	@Test
	public void invalidboth() {
		page.login("@qhuhuih", "@3rr3f");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
		loginTest.log(Status.INFO, "log in with invalidboth");
	}

	@Test
	public void empatyusername() {
		page.login("  ", "Avii40@#");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
		loginTest.log(Status.INFO, "log in with empatyusername ");
	}

	@Test
	public void empatyPassword() {
		page.login("aurya93450@gmail.com", "  ");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
		loginTest.log(Status.INFO, "log in with empatyPassword");
	}

	@Test
	public void invalidPassward() {
		page.login("aurya93450@gmail.com ", "@1313e31");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
		loginTest.log(Status.INFO, "log in with invalidPassward");
	}

	@Test
	public void usernamewithspace() {
		page.login("aurya 93450@gmail.com", "Avii40@#");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
		loginTest.log(Status.INFO, "log in with usernamewithspace");
	}

	@Test
	public void passwordwithspace() {
		page.login("aurya93450@gmail.com", "Avii40 @#");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
		loginTest.log(Status.INFO, "log in with passwordwithspace");
	}

	@Test
	public void passwordwithspecialcharecter() {
		page.login("aurya93450@gmail.com", "Avii40@#");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
		loginTest.log(Status.INFO, "log in with passwordwithspecialcharecter");
	}

	@Test
	public void casesemsetivewithusernames() {
		page.login("#aurya93450@gmail.com", "Avii40@#");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
		loginTest.log(Status.INFO, "log in with casesemsetivewithusernames");
	}

	@Test
	public void sqlinput() {
		page.login("'1'='1", "Avii40@#");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
		loginTest.log(Status.INFO, "log in with sqlinput");
	}

	@Test
	public void sqlinpassword() {
		page.login("aurya93450@gmail.com", "'1'='1");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
		loginTest.log(Status.INFO, "sqlinpassword sqlinpassword");
	}

	@Test
	public void empatyCredentials() {
		page.login("  ", "  ");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
		loginTest.log(Status.INFO, "log in with sqlinpassword");
	}

	@AfterMethod
	public void logout() {
		driver.quit();
		loginTest.log(Status.INFO, "Logout");
	}
	@AfterSuite
	public void teardown() {
		report.flush();
	
	}
}
