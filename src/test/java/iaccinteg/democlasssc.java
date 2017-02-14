package iaccinteg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class democlasssc {
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;
	public String address = "1801 CALIFORNIA ST,DENVER,CO 80202,USA ";
	public WebDriverWait wait;
	public String projecturltitle = "ValidateURL";
	public String projectsctitle = "ValidateURL";
	public WebDriver driver1;
	public HSSFWorkbook worbk;
	public HSSFSheet sheet1;
	public String reportpath = ".\\src\\main\\resources\\Result.html";
	public String Attachpath = "C:\\Users\\348027\\git\\IAccess\\src\\main\\resources\\";
	int i = 1;
	public String urlname1;
	public String urlname2;
	public String resultexcel, currentstatus;
	public int errcount, warcount;
	public String status = "Completed";
	public int z = 1;
	public String txtstore="C:\\Users\\348027\\git\\IAccess\\TextFile\\";
	public String ps1,ps2;
	
	public void textfileconverter(String txtfilename,String txtfile)
	{
	try {
		        File newTextFile = new File(txtstore+txtfilename+".html");
	            FileWriter fw = new FileWriter(newTextFile);
	            fw.write(txtfile);
	            fw.close();

	        } catch (IOException iox) {
	            //do stuff with exception
	            iox.printStackTrace();
	        }
	}
	
	public void url(String title, String urlname) throws Exception 
	{
		driver1.findElement(By.id("newValidation")).click();
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver1.findElement(By.xpath("//a[contains(text(),'Enter URL')]")).click();
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver1.findElement(By.xpath("//a[contains(text(),'Upload File')]")).click();
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver1.findElement(By.id("file_title")).sendKeys(title);
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver1.findElement(By.id("file")).click();
		Thread.sleep(3000);
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Runtime.getRuntime().exec("C:\\Users\\348027\\git\\IAccess\\autoit\\fileupload.exe"+" "+urlname);
		Thread.sleep(3000);
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver1.findElement(By.id("chk_lvlaaa_file")).click();
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver1.findElement(By.id("button_file_upload_test")).click();
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);		
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
		driver.get("http://www.centurylink.com/home/");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		test.log(LogStatus.PASS, "Century Link home page launched");
		
		ps1=driver.getPageSource();
		textfileconverter("Home" ,ps1 );
		
		test.log(LogStatus.PASS, "CTL Homepage PS Passed to IAccess");

		driver.findElement(By.partialLinkText("Bundles")).click();
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("bundles-order-now")));
		
		ps2=driver.getPageSource();
		textfileconverter("Bundles" ,ps2 );
		
		test.log(LogStatus.PASS, "CTL Bundles PS Passed to IAccess");
		element.isDisplayed();
		
		/*Click on Order Online and Check Availability- Select customer info
		element.click();
		WebElement element1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//div[contains(text(),'Check Availability')]")));
		element1.isDisplayed();

		
		 * driver.findElement(By.id("ctam_nc-sfaddress")).sendKeys(address);
		 * driver.findElement(By.id("ctam_nc-go")).click(); WebElement
		 * element2=wait
		 * .until(ExpectedConditions.visibilityOfElementLocated(By.id
		 * ("addressid3"))); WebElement
		 * element3=wait.until(ExpectedConditions.visibilityOfElementLocated
		 * (By.id("submitSecUnit"))); element2.click(); element3.click();
		 * driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 * 
		 * 
		 * 
		 * 
		 * //Customize Bundle WebElement
		 * element4=wait.until(ExpectedConditions.visibilityOfElementLocated
		 * (By.id("customize_HsiPlusHpu3YrOfferPGOQU"))); element4.click();
		 * 
		 * WebElement
		 * check1=wait.until(ExpectedConditions.visibilityOfElementLocated
		 * (By.xpath("//*[contains(text(),'Summary')]"))); WebElement
		 * check2=wait
		 * .until(ExpectedConditions.visibilityOfElementLocated(By.xpath
		 * ("//*[contains(text(),'Adjusted Monthly Total:')]")));
		 * check1.isDisplayed(); check2.isDisplayed();
		 * 
		 * WebElement
		 * element5=wait.until(ExpectedConditions.elementToBeClickable
		 * (By.xpath("//*[contains(text(),'Next')]"))); element5.click();
		 * 
		 * WebElement
		 * element6=wait.until(ExpectedConditions.visibilityOfElementLocated
		 * (By.xpath("//span[contains(text(),'Contact Information')]")));
		 * element6.isDisplayed();
		 * 
		 * driver.findElement(By.id("contactinfo.firstname")).sendKeys("Benten");
		 * driver
		 * .findElement(By.id("contactinfo.lastname")).sendKeys("Christoper");
		 * driver.findElement(By.id("contactinfo.emailaddr")).sendKeys(
		 * "bentenchristoper@gmail.com");
		 * driver.findElement(By.id("contactinfo.emailconfirm"
		 * )).sendKeys("bentenchristoper@gmail.com");
		 * driver.findElement(By.id("contactinfo.contactnum"
		 * )).sendKeys("8669744574");
		 * driver.findElement(By.id("contactinfo.dobMonth")).sendKeys("07");
		 * driver.findElement(By.id("contactinfo.dobDay")).sendKeys("20");
		 * driver.findElement(By.id("contactinfo.dobYear")).sendKeys("1989");
		 * driver.findElement(By.id("phonenum.phone1")).click();
		 * driver.findElement
		 * (By.xpath("//input[@value='Place My Order Securely']"
		 * )).isDisplayed(); driver.manage().timeouts().implicitlyWait(2,
		 * TimeUnit.SECONDS);
		 */
		driver.quit();
		test.log(LogStatus.PASS, "Closing the CTL shopping browser");
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		url("Home", "C:\\Users\\348027\\git\\IAccess\\TextFile\\Home.html");
		test.log(LogStatus.PASS, "CTL Homepage URL Passed to IAccess");
		Thread.sleep(120000);
		
		url("Bundles", "C:\\Users\\348027\\git\\IAccess\\TextFile\\Bundles.html");
		test.log(LogStatus.PASS, "CTL Bundles URL Passed to IAccess");
		Thread.sleep(120000);
		driver1.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
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
			currentstatus = driver1.findElement(By.xpath("html/body/section/table/tbody/tr[2]/td[5]")).getText().trim();
		}while(status!=currentstatus);*/

		driver1.findElement(By.xpath("html/body/section/table/tbody/tr[2]/td[6]/a")).click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// WebElement
		// validation=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Validation Summary')]")));
		// validation.isDisplayed();
        System.out.println(driver1.findElement(By.xpath("//*[@class='fail']")).getText());
        
		if ("Fail".equalsIgnoreCase(driver1.findElement(By.xpath("//*[@class='fail']")).getText())) {
			driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			String errror=driver1.findElement(By.xpath("html/body/section/table/tbody/tr[4]/td[3]")).getText();
			driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			String warrning=driver1.findElement(By.xpath("html/body/section/table/tbody/tr[4]/td[4]")).getText();
			captureScreenshot(driver1, "HomePage");
			String image = test.addScreenCapture(Attachpath+"HomePage"+".jpg");
			test.log(LogStatus.FAIL,"Homepage Error: "+errror+" Warning: "+warrning);
			test.log(LogStatus.FAIL,"HomePage", image);
			Thread.sleep(5000);

		} else {
			captureScreenshot(driver1, "HomePage");
			String image = test.addScreenCapture(Attachpath+"HomePage"+".jpg");
			test.log(LogStatus.PASS, "HomePage", image);
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
			captureScreenshot(driver1, "Bundles");
			String image = test.addScreenCapture(Attachpath+"Bundles"+".jpg");
			driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			String errror1=driver1.findElement(By.xpath("html/body/section/table/tbody/tr[4]/td[3]")).getText();
			driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			String warrning1=driver1.findElement(By.xpath("html/body/section/table/tbody/tr[4]/td[4]")).getText();
			test.log(LogStatus.FAIL,"Bundles Error: "+errror1+" Warning: "+warrning1);
			test.log(LogStatus.FAIL, "Bundles", image);
			Thread.sleep(5000);
		} else {
			captureScreenshot(driver1, "Bundles");
			String image = test.addScreenCapture(Attachpath+"Bundles"+".jpg");
			test.log(LogStatus.PASS, "Bundles", image);
			Thread.sleep(5000);
		}

		driver1.get("C:\\Users\\348027\\git\\IAccess\\src\\main\\resources\\Result.html");
		extent.endTest(test);
		extent.flush();
	}

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
	}
}
