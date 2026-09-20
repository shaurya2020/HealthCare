package healthcare;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String Email = "ayushmaurya9450@gmail.com";
		String pass = "Ayush2020@#";
		String Url = "https://anvnacare.alwaysdata.net/";

		driver.get(Url);

//		Login
		driver.findElement(By.id("navLogin")).click();
		driver.findElement(By.id("patientTab")).click();
		WebElement emailInput = driver.findElement(By.id("emailInput"));
		emailInput.sendKeys(Email);
		WebElement password = driver.findElement(By.id("passwordInput"));
		password.sendKeys(pass);
		driver.findElement(By.id("rememberMeCheckbox")).click();
		driver.findElement(By.id("submitBtnText")).submit();
		
		
		WebElement title = driver.findElement(By.id("greetingTitle"));
		
		if (title.isDisplayed()) {
			System.out.println("Login is sucessfully");
		}else {
			System.out.println("Unable to Login");
		}
		
		Actions aact = new Actions(driver);
		WebElement selt = driver.findElement(By.id("userMenuDropdown"));
		aact.moveToElement(selt).perform();
		
		
		driver.findElement(By.id("dropdownLogout")).click();
		

		Thread.sleep(2000);

		driver.quit();
	}

}
