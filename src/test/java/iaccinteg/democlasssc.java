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

public class democlasssc {
	WebDriver driver;
	String address="1801 CALIFORNIA ST,DENVER,CO 80202,USA ";
	WebDriverWait wait;
	WebDriver driver1;
	
	public void sc(String title, String scodepg)
	{
		driver1.findElement(By.xpath("//*[contains(text(),'Paste Text')]")).click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver1.findElement(By.id("html_title")).sendKeys(title);
		driver1.findElement(By.id("html_text")).sendKeys(scodepg);
		driver1.findElement(By.id("chk_lvlaa_code")).click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver1.findElement(By.id("button_code_test")).click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void shopflow() throws Exception
	{
		driver1 = new FirefoxDriver();
		wait = new WebDriverWait(driver1, 3600);
		driver1.get("http://localhost:8080/iAccess5");
		WebElement login=wait.until(ExpectedConditions.elementToBeClickable(By.id("button_login")));
		driver1.findElement(By.id("emp_id")).sendKeys("348027");
		driver1.findElement(By.id("password")).sendKeys("Tcs@1234");
		login.click();
		WebElement create=wait.until(ExpectedConditions.elementToBeClickable(By.id("button_create")));
		create.isDisplayed();
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver1.findElement(By.xpath("//label[contains(text(),'ValidateSC')]/preceding-sibling::input[@name='project-id']")).click();
		Thread.sleep(4000);
		WebElement addvalidate=wait.until(ExpectedConditions.elementToBeClickable(By.id("add-validation")));
		addvalidate.click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver1.findElement(By.xpath("//*[contains(text(),'Project Name: ValidateSC')]")).isDisplayed();
			
        driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 3600);
		//System.setProperty("webdriver.chrome.driver", "/demo/lib/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		//Launch the URL and click on Bundles  
		driver.get("http://www.centurylink.com/home/");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		String scpg=driver.getPageSource();
		sc("Home",scpg);
		
		driver.findElement(By.partialLinkText("Bundles")).click();
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bundles-order-now")));
		/*String title2=driver.getTitle();
		String urlname2=driver.getCurrentUrl();
		sc(title2,urlname2);*/
		String sc1=driver.getPageSource();
		System.out.println(sc1);
		
		//Click on Order Online and Check Availability- Select customer info
		element.click();
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Check Availability')]")));
		element1.isDisplayed();
		/*String title3=driver.getTitle();
		String urlname3=driver.getCurrentUrl();
		sc(title3,urlname3);
		
		
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
		*/
		}
	
	@AfterTest
	public void closeb()
	{
		//driver.quit();
	}

}
