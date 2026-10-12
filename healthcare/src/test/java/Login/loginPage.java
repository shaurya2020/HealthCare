package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	WebDriver driver;

	public loginPage(WebDriver driver) {
		this.driver = driver;

	}
	public void enterEmail(String Email) {
		WebElement emailInput = driver.findElement(By.id("emailInput"));
		emailInput.sendKeys(Email);
	}

	public void enterPass(String pass) {
		WebElement password = driver.findElement(By.id("passwordInput"));
		password.sendKeys(pass);
	}

	public void clickButton() {
		driver.findElement(By.id("rememberMeCheckbox")).click();
		driver.findElement(By.id("submitBtnText")).submit();
	}

	public void login(String Email, String pass) {
		enterEmail(Email);
		enterPass(pass);
		clickButton();
	}
//	Actions aact = new Actions(driver);
//	WebElement selt = driver.findElement(By.id("userMenuDropdown"));
//	aact.moveToElement(selt).perform();
//	
//	driver.findElement(By.id("dropdownLogout")).click();
//	driver.quit();
//	}
//	}

}
