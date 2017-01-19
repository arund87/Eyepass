package iaccinteg;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class democlass {
	WebDriver driver;
	String address="1801 CALIFORNIA ST,DENVER,CO 80202,USA ";
	WebDriverWait wait;
	
	@Test
	public void shopflow()
	{
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 60);
		//System.setProperty("webdriver.chrome.driver", "/demo/lib/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		//Launch the URL and click on Bundles  
		driver.get("http://www.centurylink.com/home/");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Bundles")).click();
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bundles-order-now")));
		
		//Click on Order Online and Check Availability- Select customer info
		element.click();
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Check Availability')]")));
		element1.isDisplayed();
		driver.findElement(By.id("ctam_nc-sfaddress")).sendKeys(address);
		driver.findElement(By.id("ctam_nc-go")).click();
		WebElement element2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addressid3")));
		WebElement element3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitSecUnit")));
		element2.click();
		element3.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		
		
		
		//Customize Bundle 
		WebElement element4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customize_HsiPlusHpu3YrOfferPGOQU")));
		element4.click();
				
		WebElement check1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Summary')]")));
		WebElement check2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Adjusted Monthly Total:')]")));
		check1.isDisplayed();
		check2.isDisplayed();
					
		WebElement element5=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Next')]")));
		element5.click();
		
		WebElement element6=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Contact Information')]")));
		element6.isDisplayed();
		
		driver.findElement(By.id("contactinfo.firstname")).sendKeys("Benten");
		driver.findElement(By.id("contactinfo.lastname")).sendKeys("Christoper");
		driver.findElement(By.id("contactinfo.emailaddr")).sendKeys("bentenchristoper@gmail.com");
		driver.findElement(By.id("contactinfo.emailconfirm")).sendKeys("bentenchristoper@gmail.com");
		driver.findElement(By.id("contactinfo.contactnum")).sendKeys("8669744574");
		driver.findElement(By.id("contactinfo.dobMonth")).sendKeys("07");
		driver.findElement(By.id("contactinfo.dobDay")).sendKeys("20");
		driver.findElement(By.id("contactinfo.dobYear")).sendKeys("1989");
		driver.findElement(By.id("phonenum.phone1")).click();
		driver.findElement(By.xpath("//input[@value='Place My Order Securely']")).isDisplayed();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		}
	
	@AfterTest
	public void closeb()
	{
		driver.quit();
	}

}
