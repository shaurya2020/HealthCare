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
		 page.login( "singh40@gmail.com", "Avii40@#");
		 Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
//		 System.out.println("ValidCredentials");
		 
	 }
	 
	 @Test
	 public void invalidcredential() {
		 page.login("aurya93450@gmail.com","aman123");
		 Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
//		 driver.findElement(By.id("greetingTitle"))
//		 System.out.println("invalidCredentials");
	 }
	 
	 @Test
	 public void empatyCredentials() {
		 page.login("  ","  ");
		 Assert.assertTrue(driver.findElement(By.id("greetingTitle")).isDisplayed());
//		 System.out.println("EmpatyCredentials");
	 }
	 @AfterMethod
	 public void teardown()
	 {
		 
			 driver.quit();
		 
	 }
	 

}
