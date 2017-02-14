package iaccinteg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class democlassurl {
	public WebDriver driver;
	public String address="1801 CALIFORNIA ST,DENVER,CO 80202,USA ";
	public WebDriverWait wait;
	public String projecturltitle="ValidateURL";
	public String projectsctitle="ValidateSC";
	public WebDriver driver1;
	public HSSFWorkbook worbk;
	public HSSFSheet sheet1;
	public String path=".\\src\\main\\resources\\Result.xls";
	int i=1;
	public String urlname1;
	public String urlname2;
	public String resultexcel,currentstatus; public int errcount,warcount;
	public String status="Completed";
	public int z=1;
	
	public void url(String title, String urlname)
	{
		driver1.findElement(By.id("title")).sendKeys(title);
		driver1.findElement(By.id("url_0")).sendKeys(urlname);
		driver1.findElement(By.id("chk_compl_site")).click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver1.findElement(By.id("chk_lvlaa_url")).click();
		driver1.findElement(By.id("button_compl_site_test")).click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@BeforeTest
	public void excelclear() throws Exception 
	{
		//Getting the values from Excel
		try {
		 FileInputStream fis=new FileInputStream(path);
		 worbk=new HSSFWorkbook(fis);
		 sheet1=worbk.getSheetAt(0);
		} 
		catch (Exception e) {
		 System.out.println(e.getMessage());
		} 
		int rows = sheet1.getLastRowNum();
		rows=rows+1;
				
		for(int i=1;i<rows;i++)
		{
			for(int j=0;j<5;j++)
			{
				sheet1.getRow(i).createCell(j).setCellValue(""); 
				try {
					   FileOutputStream fout =new FileOutputStream(path);    
					   worbk.write(fout);
					    }
					  catch (Exception e) {
							System.out.println(e.getMessage());
						}
			}
		}
		
		try{
			worbk.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}					
		
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
		driver1.findElement(By.xpath("//label[contains(text(),'ValidateURL')]/preceding-sibling::input[@name='project-id']")).click();
		Thread.sleep(4000);
		WebElement addvalidate=wait.until(ExpectedConditions.elementToBeClickable(By.id("add-validation")));
		addvalidate.click();
		driver1.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver1.findElement(By.xpath("//*[contains(text(),'Project Name: ValidateURL')]")).isDisplayed();
			
        driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 3600);
		//System.setProperty("webdriver.chrome.driver", "/demo/lib/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		//Launch the URL and click on Bundles  
		driver.get("http://www.centurylink.com/home/");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		urlname1=driver.getCurrentUrl();
		url("Home",urlname1);
		
		driver.findElement(By.partialLinkText("Bundles")).click();
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bundles-order-now")));
		urlname2=driver.getCurrentUrl();
		url("Bundles",urlname2);
		
		
		//Click on Order Online and Check Availability- Select customer info
		element.click();
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Check Availability')]")));
		element1.isDisplayed();
			
		/*
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
	public void closeb() throws Exception
	{
		driver.quit();	
		driver1.findElement(By.id("achivedResults")).click();
		
		do{
			Thread.sleep(10000);
			z=z+1;
			driver1.findElement(By.id("achivedResults")).click();
			currentstatus=driver1.findElement(By.xpath("html/body/section/table/tbody/tr[2]/td[5]")).getText().trim();
			
		}while(12!=z);
		
		//while(status!=currentstatus);
		
		driver1.findElement(By.xpath("html/body/section/table/tbody/tr[2]/td[6]/a")).click();
		//WebElement validation=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Validation Summary')]")));
		//validation.isDisplayed();
		
		if("Fail".equalsIgnoreCase(driver1.findElement(By.xpath("//*[@class='fail']")).getText()))
		{
			resultexcel="Fail";
		}else{
			resultexcel="Pass";
		}
	   // int ea =errorcounter("html/body/section/table/tbody/tr/td[3]",0);
	   // int	wa= warningcounter("html/body/section/table/tbody/tr/td[4]",0);
		
		excelupdate("Home",urlname1,resultexcel);
		
		z=1;
		do{
			Thread.sleep(10000);
			z=z+1;
			driver1.findElement(By.id("achivedResults")).click();
			currentstatus=driver1.findElement(By.xpath("html/body/section/table/tbody/tr[1]/td[5]")).getText().trim();
		}while(6!=z);
		
		//while(status!=currentstatus);
		
		driver1.findElement(By.xpath("html/body/section/table/tbody/tr[1]/td[6]/a")).click();
		//WebElement validation1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Validation Summary')]")));
		//validation1.isDisplayed();
		if("Fail".equalsIgnoreCase(driver1.findElement(By.xpath("//*[@class='fail']")).getText()))
		{
			resultexcel="Fail";
		}else{
			resultexcel="Pass";
		}
		   //int eb =errorcounter("html/body/section/table/tbody/tr/td[3]",0);
		  //int	wb= warningcounter("html/body/section/table/tbody/tr/td[4]",0);
		  //excelupdate("Bundles",urlname2,resultexcel,eb,wb);
			
			excelupdate("Bundles",urlname2,resultexcel);
			Thread.sleep(3000);
			//Runtime.getRuntime().exec("C:\\Users\\348027\\git\\IAccess\\src\\main\\resources\\openexcel.bat");
	}
	
	public void excelupdate(String title,String url,String result) throws Exception
	{
		//Getting the values from Excel
				try {
				 FileInputStream fis=new FileInputStream(path);
				 worbk=new HSSFWorkbook(fis);
				 sheet1=worbk.getSheetAt(0);
				} 
				catch (Exception e) {
				 System.out.println(e.getMessage());
				} 
												
					sheet1.getRow(i).createCell(0).setCellValue(title);
					sheet1.getRow(i).createCell(1).setCellValue(url);
					sheet1.getRow(i).createCell(2).setCellValue(result);
					//sheet1.getRow(i).createCell(3).setCellValue(error);
					//sheet1.getRow(i).createCell(4).setCellValue(warning);
					
					try {
						   FileOutputStream fout =new FileOutputStream(path);    
						   worbk.write(fout);
						    }
						  catch (Exception e) {
								System.out.println(e.getMessage());
							}
					i=i+1;
					return;
				
	}
	
	public int errorcounter(String pathelement, int errcount)
	{
		List<WebElement> errorlist=driver1.findElements(By.xpath(pathelement));
		int size=errorlist.size();
		for(int j=1;j<size;j++)
		{
			String a = errorlist.get(j).getAttribute("value");
			 int errorlistnum=Integer.parseInt(a) ;
			errcount=errcount + errorlistnum;
		}
		return errcount;
	}
	
	public int warningcounter(String pathelement1, int warcount)
	{
		List<WebElement> errorlist=driver1.findElements(By.xpath(pathelement1));
		int size=errorlist.size();
		for(int j=1;j<size;j++)
		{
			String a = errorlist.get(j).getAttribute("value");
			 int errorlistnum=Integer.parseInt(a) ;
			 warcount=warcount + errorlistnum;
		}
		return warcount;
	}

}
