package marathon.week2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;



public class BaseClass {
	RemoteWebDriver driver;
	String ExcelName;
	@Parameters({"url","username","password","browser"})

	@BeforeMethod	
	public void preCondition(String url,String username,String password,String browser) throws InterruptedException {
	
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.id("sysverb_login")).click();

	}
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException {

		ReadExcel excel = new ReadExcel();
		String[][] data =  excel.readData(ExcelName);
		return data;
	}
	
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
}
