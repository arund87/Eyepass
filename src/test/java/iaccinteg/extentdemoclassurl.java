package iaccinteg;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class extentdemoclassurl {
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;
	public WebDriverWait wait;
	public String projecturltitle = "ValidateURL";
	public String projectsctitle = "ValidateSC";
	public WebDriver driver1;
	public HSSFWorkbook worbk;
	public HSSFSheet sheet1;
	public String reportpath = ".\\src\\main\\resources\\Result.html";
	public String Attachpath = "C:\\Users\\348027\\git\\IAccess\\src\\main\\resources\\";
	int i = 1;
	public String urlname1;
	public String urlname2,urlname3,urlname4;
	public String resultexcel, currentstatus;
	public int errcount, warcount;
	public String status = "Completed";
	public int z = 1;

	public void url(String title, String urlname) throws Exception {
		driver1.findElement(By.id("title")).sendKeys(title);
		driver1.findElement(By.id("url_0")).sendKeys(urlname);
		//driver1.findElement(By.id("chk_compl_site")).click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver1.findElement(By.id("chk_lvlaa_url")).click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver1.findElement(By.id("button_url_test")).click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		test.log(LogStatus.PASS, "IAccess Test ran for the page: " + title);
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	// Method for Screenshots
	public void captureScreenshot(WebDriver driver, String Snap) {
		try {
			TakesScreenshot clk = (TakesScreenshot) driver;
			File source = clk.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("C:\\Users\\348027\\git\\IAccess\\src\\main\\resources\\"+Snap+".jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void shopflow() throws Exception {
		driver1 = new FirefoxDriver();
		wait = new WebDriverWait(driver1, 3600);
		extent = new ExtentReports(reportpath, true);
		test = extent.startTest("IAccess Test by URL");
		driver1.get("http://localhost:8080/iAccess5");
		WebElement login = wait.until(ExpectedConditions
				.elementToBeClickable(By.id("button_login")));
		test.log(LogStatus.PASS, "IAccess Page launched");
		driver1.findElement(By.id("emp_id")).sendKeys("1128448");
		driver1.findElement(By.id("password")).sendKeys("Tcs@1234");
		login.click();
		WebElement create = wait.until(ExpectedConditions
				.elementToBeClickable(By.id("button_create")));
		create.isDisplayed();
		test.log(LogStatus.PASS, "IAccess Login Successful");
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver1.findElement(
				By.xpath("//label[contains(text(),'ValidateURL')]/preceding-sibling::input[@name='project-id']"))
				.click();
		Thread.sleep(4000);
		WebElement addvalidate = wait.until(ExpectedConditions
				.elementToBeClickable(By.id("add-validation")));
		addvalidate.click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver1.findElement(
				By.xpath("//*[contains(text(),'Project Name: ValidateURL')]"))
				.isDisplayed();   

		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 3600);
		// System.setProperty("webdriver.chrome.driver",
		// "/demo/lib/chromedriver.exe");
		// WebDriver driver = new ChromeDriver();
		// Launch the URL and click on Bundles
		driver.get("http://www.airtel.in/");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		test.log(LogStatus.PASS, "Airtel home page launched");
		urlname1 = driver.getCurrentUrl();
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@data-i18n='buy']")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//a[contains(text(),'Prepaid')])[2]")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='layoutContainers']/div/div[2]/div/div[3]/div[2]/section/div[2]/div/div[3]/a/span")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		urlname2 = driver.getCurrentUrl();
		test.log(LogStatus.PASS, "Airtel Create Mypack");	
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.id("mobileId")).sendKeys("9884570793");
		driver.findElement(By.id("mailId")).sendKeys("arun.deivakumar@gmail.com");
		driver.findElement(By.xpath("//span[contains(text(),'proceed')]")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		test.log(LogStatus.PASS, "Airtel budget Mypack");
		driver.findElement(By.id("1_1")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		urlname3 = driver.getCurrentUrl();
		
		driver.findElement(By.id("benefitCallOnlyId_Rate")).click();
		Select ratedd=new Select(driver.findElement(By.id("Rate@")));
		ratedd.selectByVisibleText("30p/min");
		driver.findElement(By.xpath("//span[contains(text(),'proceed')]")).click();
		test.log(LogStatus.PASS, "Airtel Mypack Summary");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		urlname4 = driver.getCurrentUrl();
		url("AirtelHome",urlname1);	
		Thread.sleep(120000);
		url("MyPackLogin",urlname2);
		Thread.sleep(120000);
		url("prepaidbudget",urlname3);
		Thread.sleep(120000);
		url("MypackSummary",urlname4);
		Thread.sleep(120000);
		
		
		test.log(LogStatus.PASS, "Closing the Airtel shopping browser");
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		url("Home", urlname1);
		test.log(LogStatus.PASS, "CTL Homepage URL Passed to IAccess");
		Thread.sleep(120000);
		
		url("Bundles", urlname2);
		test.log(LogStatus.PASS, "CTL Bundles URL Passed to IAccess");
		Thread.sleep(120000);
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		driver1.findElement(By.xpath("//a[@id='newValidation']")).click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver1.findElement(By.xpath("//a[@id='achivedResults']")).click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
		driver1.findElement(By.xpath("html/body/section/table/tbody/tr[2]/td[6]/a")).click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		        
		if ("Fail".equalsIgnoreCase(driver1.findElement(By.xpath("//*[@class='fail']")).getText())) {
			driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			String errror=driver1.findElement(By.xpath("html/body/section/table/tbody/tr[4]/td[3]")).getText();
			driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			String warrning=driver1.findElement(By.xpath("html/body/section/table/tbody/tr[4]/td[4]")).getText();
			captureScreenshot(driver1, "Home");
			String image = test.addScreenCapture(Attachpath+"Home"+".jpg");
			test.log(LogStatus.FAIL,"Home Error: "+errror+" Warning: "+warrning);
			test.log(LogStatus.FAIL,"Home", image);
			Thread.sleep(5000);

		} else {
			captureScreenshot(driver1, "Home");
			String image = test.addScreenCapture(Attachpath+"Home"+".jpg");
			test.log(LogStatus.PASS, "Home", image);
			Thread.sleep(5000);
		}
		  
		driver1.findElement(By.xpath("//a[@id='newValidation']")).click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver1.findElement(By.xpath("//a[@id='achivedResults']")).click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		/*
		do {
			Thread.sleep(5000);
			driver1.findElement(By.xpath("//a[@id='newValidation']")).click();
			driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver1.findElement(By.xpath("//a[@id='achivedResults']")).click();
			driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			currentstatus = driver1.findElement(By.xpath("html/body/section/table/tbody/tr[1]/td[5]")).getText().trim();
		}while(status!=currentstatus);*/

		driver1.findElement(By.xpath("html/body/section/table/tbody/tr[1]/td[6]/a")).click();
		if ("Fail".equalsIgnoreCase(driver1.findElement(By.xpath("//*[@class='fail']")).getText())) {
			driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			String errror=driver1.findElement(By.xpath("html/body/section/table/tbody/tr[4]/td[3]")).getText();
			driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			String warrning=driver1.findElement(By.xpath("html/body/section/table/tbody/tr[4]/td[4]")).getText();
			captureScreenshot(driver1, "MypackSummary");
			String image = test.addScreenCapture(Attachpath+"MypackSummary"+".jpg");
			test.log(LogStatus.FAIL,"MypackSummary Error: "+errror+" Warning: "+warrning);
			test.log(LogStatus.FAIL,"MypackSummary", image);
			Thread.sleep(5000);
		} else {
			captureScreenshot(driver1, "MypackSummary");
			String image = test.addScreenCapture(Attachpath+"MypackSummary"+".jpg");
			test.log(LogStatus.PASS, "MypackSummary", image);
			Thread.sleep(5000);
		}
		driver.quit();
		driver1.get("C:\\Users\\348027\\git\\IAccess\\src\\main\\resources\\Result.html");
		extent.endTest(test);
		extent.flush();
	}
/*
	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException {
		if (ITestResult.FAILURE == result.getStatus()) {
			captureScreenshot(driver, result.getName());
			String image = test.addScreenCapture(Attachpath+result.getName()+".jpg");
			test.log(LogStatus.FAIL, result.getName(), image);
			Thread.sleep(5000);
			driver.quit();
		}
		extent.endTest(test);
		extent.flush();
	}*/
}
