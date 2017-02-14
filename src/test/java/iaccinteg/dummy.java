package iaccinteg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class dummy {
	public WebDriver driver;
	public WebDriver driver1;
	public WebDriverWait wait;
	
	@Test
	public void test1() throws Exception
	{
		
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 3600);
		driver.get("http://www.centurylink.com/home/");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		String ps1=driver.getPageSource();
		driver.close();
		
		driver1 = new FirefoxDriver();
		wait = new WebDriverWait(driver1, 3600);
		
		
		driver1.get("http://localhost:8080/iAccess5");
		WebElement login = wait.until(ExpectedConditions
				.elementToBeClickable(By.id("button_login")));
		
		driver1.findElement(By.id("emp_id")).sendKeys("1128448");
		driver1.findElement(By.id("password")).sendKeys("Tcs@1234");
		login.click();
		WebElement create = wait.until(ExpectedConditions
				.elementToBeClickable(By.id("button_create")));
		create.isDisplayed();
		
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver1.findElement(
				By.xpath("//label[contains(text(),'ValidateURL')]/preceding-sibling::input[@name='project-id']"))
				.click();
		Thread.sleep(3000);
		WebElement addvalidate = wait.until(ExpectedConditions
				.elementToBeClickable(By.id("add-validation")));
		addvalidate.click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver1.findElement(
				By.xpath("//*[contains(text(),'Project Name: ValidateURL')]"))
				.isDisplayed();
		
		driver1.findElement(By.xpath("//a[contains(text(),'Enter URL')]")).click();
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver1.findElement(By.xpath("//a[contains(text(),'Paste Text')]")).click();
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver1.findElement(By.id("html_title")).sendKeys("Homehtml");
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(3000);
		WebElement eletextarea = driver1.findElement(By.id("html_text"));
	    ((JavascriptExecutor)driver1).executeScript("arguments[0].value = arguments[1];", eletextarea,ps1);
		System.out.println("text");
		Thread.sleep(4000);
		driver1.findElement(By.id("chk_lvlaa_code")).click();
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver1.findElement(By.id("button_code_test")).click();
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);		
		
		
	}

}
