package iaccinteg;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ctlextentdemoclasshtmlupload {
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

	public void url(String title, String urlname) throws Exception
	{
		driver1.findElement(By.xpath("//a[@id='newValidation']")).click();
		driver1.findElement(By.xpath("//a[contains(text(),'Enter URL')]")).click();
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver1.findElement(By.xpath("//a[contains(text(),'Upload File')]")).click();
		Thread.sleep(2000);
		driver1.findElement(By.id("file_title")).sendKeys(title);
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver1.findElement(By.id("file")).click();
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\348027\\git\\IAccess\\autoit\\fileupload.exe"+" "+urlname);
		Thread.sleep(3000);
		driver1.findElement(By.id("chk_lvlaa_file")).click();
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver1.findElement(By.id("button_file_upload_test")).click();
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);		
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
		test = extent.startTest("IAccess Test by HTML Text");
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
		driver.get("http://www.centurylink.com/home/");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		test.log(LogStatus.PASS, "Century Link home page launched");
		
		Thread.sleep(2000);
		new Actions(driver).sendKeys(Keys.chord(Keys.CONTROL, "s")).perform();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\348027\\git\\IAccess\\autoit\\htmlsaver.exe"+" "+"Home.html");
		Thread.sleep(3000);
		
		
		driver.findElement(By.partialLinkText("Bundles")).click();
		test.log(LogStatus.PASS, "Navigated to Bundles");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("bundles-order-now")));
		element.isDisplayed();
		
		Thread.sleep(2000);
		new Actions(driver).sendKeys(Keys.chord(Keys.CONTROL, "s")).perform();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\348027\\git\\IAccess\\autoit\\htmlsaver.exe"+" "+"Bundles.html");
		Thread.sleep(3000);
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.quit();
		
		test.log(LogStatus.PASS, "CTL Homepage htmlfile uploaded in IAccess");		
		url("Home", "C:\\Users\\348027\\Downloads\\Home.htm");
		Thread.sleep(60000);
		
		test.log(LogStatus.PASS, "CTL Bundlespage htmlfile uploaded in IAccess");
		url("Bundles", "C:\\Users\\348027\\Downloads\\Bundles.htm");
		Thread.sleep(60000);
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		/*
		driver1.findElement(By.xpath("//a[@id='newValidation']")).click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver1.findElement(By.xpath("//a[@id='achivedResults']")).click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		*/
		
		do {
			Thread.sleep(60000);
			driver1.findElement(By.xpath("//a[@id='newValidation']")).click();
			driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver1.findElement(By.xpath("//a[@id='achivedResults']")).click();
			driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			currentstatus = driver1.findElement(By.xpath("html/body/section/table/tbody/tr[2]/td[5]")).getText().trim();
			System.out.println(currentstatus);
		}while(status==currentstatus);
		
		driver1.findElement(By.xpath("html/body/section/table/tbody/tr[2]/td[6]/a")).click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		        
		if ("Fail".equalsIgnoreCase(driver1.findElement(By.xpath("//*[@class='fail']")).getText())) {
			driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			String errror=driver1.findElement(By.xpath("html/body/section/table/tbody/tr[4]/td[3]")).getText();
			driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			String warrning=driver1.findElement(By.xpath("html/body/section/table/tbody/tr[4]/td[4]")).getText();
			captureScreenshot(driver1, "Home");
			String image = test.addScreenCapture(Attachpath+"Home"+".jpg");
			test.log(LogStatus.FAIL,"Accessibility test result for HomePage=> Error: "+errror+" Warning: "+warrning);
			test.log(LogStatus.FAIL,"Home", image);
			Thread.sleep(5000);

		} else {
			captureScreenshot(driver1, "Home");
			String image = test.addScreenCapture(Attachpath+"Home"+".jpg");
			test.log(LogStatus.PASS, "Home", image);
			Thread.sleep(60000);
		}
		  
		
		driver1.findElement(By.xpath("//a[@id='newValidation']")).click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver1.findElement(By.xpath("//a[@id='achivedResults']")).click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		do {
			Thread.sleep(60000);
			driver1.findElement(By.xpath("//a[@id='newValidation']")).click();
			driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver1.findElement(By.xpath("//a[@id='achivedResults']")).click();
			driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			currentstatus = driver1.findElement(By.xpath("html/body/section/table/tbody/tr[1]/td[5]")).getText().trim();
			System.out.println(currentstatus);
		}while(status==currentstatus);

		driver1.findElement(By.xpath("html/body/section/table/tbody/tr[1]/td[6]/a")).click();
		if ("Fail".equalsIgnoreCase(driver1.findElement(By.xpath("//*[@class='fail']")).getText())) {
			driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			String errror=driver1.findElement(By.xpath("html/body/section/table/tbody/tr[4]/td[3]")).getText();
			driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			String warrning=driver1.findElement(By.xpath("html/body/section/table/tbody/tr[4]/td[4]")).getText();
			captureScreenshot(driver1, "Bundles");
			String image = test.addScreenCapture(Attachpath+"Bundles"+".jpg");
			test.log(LogStatus.FAIL,"Accessibility test result for Bundles=> Error: "+errror+" Warning: "+warrning);
			test.log(LogStatus.FAIL,"Bundles", image);
			Thread.sleep(5000);
		} else {
			captureScreenshot(driver1, "Bundles");
			String image = test.addScreenCapture(Attachpath+"Bundles"+".jpg");
			test.log(LogStatus.PASS, "Bundles", image);
			Thread.sleep(5000);
		}
		
		
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(6000);
		extent.endTest(test);
		extent.flush();
		driver1.get("C:\\Users\\348027\\git\\IAccess\\src\\main\\resources\\Result.html");
		
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
