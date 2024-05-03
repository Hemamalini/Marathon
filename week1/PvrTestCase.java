package marathon.week1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PvrTestCase {

	public static void main(String[] args){
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//img[@src='https://originserver-static1-uat.pvrcinemas.com/pvrcms/cities/Chennai_56598_vnWADRZF.png']/following-sibling::div[1]")).click();
		driver.findElement(By.className("cinemas-inactive")).click();
		driver.findElement(By.id("cinema")).click();
		driver.findElement(By.xpath("(//li[@class='p-dropdown-item'])[4]")).click();
		driver.findElement(By.id("date")).click();
		driver.findElement(By.xpath("(//li[@class='p-dropdown-item'])[2]")).click();
		driver.findElement(By.id("movie")).click();
		driver.findElement(By.xpath("//li[text()='NADIKAR']")).click();
		driver.findElement(By.id("time")).click();
		driver.findElement(By.xpath("//li[@class='p-dropdown-item']")).click();
		driver.findElement(By.xpath("//span[text()='Book']")).click();
		driver.findElement(By.xpath("//button[@class='sc-csKJxZ eAkKcA reject-terms']")).click();
		driver.findElement(By.id("BU.BUDGET|K:13")).click();
		String text = driver.findElement(By.xpath("//div[@class='seat-info']/p")).getText();
		String text2 = driver.findElement(By.xpath("//div[@class='seat-number']/p")).getText();
		System.out.println("The Seat Information : "+text+" "+text2);
		driver.findElement(By.xpath("//button[@class='sc-khjJXk jqRMWb btn-proceeded']")).click();
		String text3 = driver.findElement(By.xpath("//div[@class='grand-tota col-md-3']//span[1]")).getText();
		System.out.println("The Grand Total : "+text3 );
		driver.findElement(By.xpath("//button[@class='sc-kFCroH cZKzgI btn-proceeded']")).click();
		driver.findElement(By.id("mobileInput")).sendKeys("12345678901");
		driver.findElement(By.xpath("//button[@class='sc-eDLKkx jzaYjq btn-proceeds']")).click();
		driver.findElement(By.xpath("//div[@class='cross-icon mx-2']")).click();
		String title = driver.getTitle();
		System.out.println("The Title of the page is "+title);
		driver.close();

	}

}
