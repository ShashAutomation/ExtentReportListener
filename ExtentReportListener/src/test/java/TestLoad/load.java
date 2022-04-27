package TestLoad;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;




@Listeners(Listener.ListenerTest.class)
public class load {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	@BeforeTest
	public void setExtent()
	{
		extent= new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html",true);
		extent.addSystemInfo("Host Name","Windows");
		extent.addSystemInfo("User Name","TestNg");
		extent.addSystemInfo("Enviroment","QA");
		
		
		
		
	}
	@AfterTest
	public void endReport()
	{
		extent.flush();
		extent.close();
	}
	
	
	
	
	@BeforeMethod
public void chromeRun()
{
	System.setProperty("webdriver.chrome.driver", "E:\\lib\\Chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://www.google.com/");
	
}
	
	@Test(priority=1)
	public void googleTitleTest()
	{
		
		String title=driver.getTitle();
		System.out.println(title);
        Assert.assertEquals(title, "Google123","title not matched");
		
	}
	@Test(priority=2)
	public void gmailButtonTest()
	{
		
		driver.findElement(By.xpath("//a[contains(@class,'gb_d')]")).click();
				
	}
	@Test(priority=3)
	public void facebookUrl() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//input[contains(@class,'gLFyf gsfi')]")).sendKeys("facebook");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='gNO89b']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h3[contains(text(),'Facebook - Log In or Sign Up')]")).click();
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
		
	}
	@Test(priority=4)
	public void enterUsername()
	{
		
		driver.navigate().to("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("jashashidhar@gmail.com");
		throw new SkipException("skipped");
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		extent.endTest(extentTest);
		driver.quit();
	}
}
