package Login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin {
	WebDriver driver;
	loginPage page;

	@BeforeMethod
	public void setup() {
		String Url = "https://anvnacare.alwaysdata.net/";

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(Url);
		driver.findElement(By.id("navLogin")).click();
		driver.findElement(By.id("patientTab")).click();

		page = new loginPage(driver);
	}

	@Test
	public void validCredntial() {
		page.login("singh40@gmail.com", "Avii40@#");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
	}

	@Test
	public void invalidcredential() {
		page.login("aurya93450@gmail.com", "aman123");
		Assert.assertFalse(driver.findElement(By.id("greetingTitle")).isDisplayed(),"Pass");
	}

	@Test
	public void invalidusername() {
		page.login("@amanj8e", "Avii40@#");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
	}
	@Test
	public void invalidboth() {
		page.login("@qhuhuih", "@3rr3f");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
	}
	
	@Test
	public void empatyusername() {
		page.login("  ", "Avii40@#");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
	}
	
	@Test
	public void empatyPassword() {
		page.login("aurya93450@gmail.com", "  ");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
	}
	
	@Test
	public void invalidPassward() {
		page.login("aurya93450@gmail.com ", "@1313e31");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
	}
	
	@Test
	public void usernamewithspace() {
		page.login("aurya 93450@gmail.com", "Avii40@#");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
	}
	
	@Test
	public void passwordwithspace() {
		page.login("aurya93450@gmail.com", "Avii40 @#");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
	}
	
	@Test
	public void passwordwithspecialcharecter() {
		page.login("aurya93450@gmail.com", "Avii40@#");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
	}
	
	@Test
	public void casesemsetivewithusernames() {
		page.login("#aurya93450@gmail.com", "Avii40@#");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
	}
	
	@Test
	public void  sqlinput() {
		page.login("'1'='1", "Avii40@#");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
	}
	
	@Test
	public void sqlinpassword() {
		page.login("aurya93450@gmail.com", "'1'='1");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
	}
	
	@Test
	public void empatyCredentials() {
		page.login("  ", "  ");
		Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
