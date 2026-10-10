package Login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	WebDriver driver;
//	public static void main(String[] args) {
	public loginPage(WebDriver driver) {
		this.driver = driver;
	
	}
//	WebDriver driver = new ChromeDriver();
//	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//	String Url = "https://anvnacare.alwaysdata.net/";

//	driver.get(Url);

//	Login
//	driver.findElement(By.id("navLogin")).click();
//	driver.findElement(By.id("patientTab")).click();
	
	public void enterEmail(String Email) {
//		String Email = "ayushmaurya9450@gmail.com";
	WebElement emailInput = driver.findElement(By.id("emailInput"));
	emailInput.sendKeys(Email);
	}
	
	public void enterPass(String pass) {
//		String pass = "Ayush2020@#";
	WebElement password = driver.findElement(By.id("passwordInput"));
	password.sendKeys(pass);
	}
	
	public void clickButton() {
	driver.findElement(By.id("rememberMeCheckbox")).click();
	driver.findElement(By.id("submitBtnText")).submit();
	}
	
	public  void login(String Email,String pass) {
		enterEmail(Email);
		enterPass(pass);
		clickButton();
	}
//	WebElement title = driver.findElement(By.id("greetingTitle"));
//	
//	if (title.isDisplayed()) {
//		System.out.println("Login is sucessfully");
//	}else {
//		System.out.println("Unable to Login");
//	}
//	
//	Actions aact = new Actions(driver);
//	WebElement selt = driver.findElement(By.id("userMenuDropdown"));
//	aact.moveToElement(selt).perform();
//	
//	driver.findElement(By.id("dropdownLogout")).click();
//	driver.quit();
//	}
//	}

}
