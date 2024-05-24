package marathon.week2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class CreateIncident extends BaseClass {
	@BeforeTest
	public void setDetails() {
		ExcelName="CreateIncident";
	}
	
	@Test(dataProvider="fetchData")
	public void createIc(String input) throws InterruptedException {
		System.out.println("createIc");

		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(20);
		dom.findElementByXPath("//div[text()='All']").click();
		dom.setImplicitWait(20);
		WebElement serEle = dom.findElementByXPath("//input[@id='filter']");
		dom.setImplicitWait(20);
		serEle.sendKeys("Incidents");
		dom.setImplicitWait(20);
		serEle.sendKeys(Keys.DOWN,Keys.ENTER);
		dom.setImplicitWait(20);
		dom.findElementByXPath("//mark[@class='filter-match']").click();
		dom.setImplicitWait(20);		
		WebElement newEle = dom.findElementByXPath("//iframe[@id='gsft_main']");

		driver.switchTo().frame(newEle);

		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		Thread.sleep(2000);
		WebElement incidentNum = driver.findElement(By.xpath("//input[@id='incident.number']"));
		String attribute = incidentNum.getAttribute("value");
		System.out.println(attribute);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys(input);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
		String text = driver.findElement(By.xpath("(//a[@class='linked formlink'])[last()]")).getText();
		System.out.println(text);
		int compareTo = attribute.compareTo(text);
		if (compareTo==0) {
			System.out.println("The Incident "+text+ " created Successfully");
			

		}else {
			System.out.println("The Incident "+text+ " not created Successfully");
		}
	}
	
}
