package healthcare;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Register {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Random rn = new Random();
		int zs= rn.nextInt(1000);
		String Email = "singh"+ zs + "@gmail.com";
		String pass = "Avii"+ zs +"@#";		
		String phone = "7340507"+ zs;		
//		genuine
/*		String Email = "ayushmaurya9450@gmail.com";
		String pass = "Ayush2020";		
		String phone = "9140505677";		
 */
		String Url = "https://anvnacare.alwaysdata.net/";
		driver.get(Url);

		WebElement web = driver.findElement(By.id("navRegister"));
		web.click();
		WebElement input = driver.findElement(By.id("nameInput"));
		input.sendKeys("Ayu Maurya");
		WebElement email = driver.findElement(By.id("emailInput"));
		email.sendKeys(Email);
		WebElement phoneInput = driver.findElement(By.id("phoneInput"));
		phoneInput.sendKeys(phone);
		WebElement passwordInput = driver.findElement(By.id("passwordInput"));
		passwordInput.sendKeys(pass);
		WebElement term = driver.findElement(By.id("termsCheckbox"));
		term.click();
		WebElement button = driver.findElement(By.id("submitBtnText"));
		button.submit();
		
		System.out.println(Email);
		System.out.println(phone);
		System.out.println(pass);
		
		WebElement title = driver.findElement(By.id("greetingTitle"));
		
		if (title.isDisplayed()) {
			System.out.println("Register is sucessfully");
		}else {
			System.out.println("Unregister");
		}
		
		Actions aact = new Actions(driver);
		WebElement selt = driver.findElement(By.id("userMenuDropdown"));
		aact.moveToElement(selt).perform();
		
		
		driver.findElement(By.id("dropdownLogout")).click();
		
		Thread.sleep(2000);
		driver.quit();

	}
}
