package marathon.week2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class UpdateIncident extends BaseClass{


	@Test
	public void updateIc() throws InterruptedException {
		

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
		driver.findElement(By.xpath("(//span[@class='list_header_cell_container'])[1]")).click();
		WebElement extElement = driver.findElement(By.xpath("//a[@class='linked formlink']"));
		String text = extElement.getText();
		System.out.println("The ExistinG Incident "+text);
		extElement.click();

		WebElement urgDropDownEle = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
		Select drop = new Select(urgDropDownEle);
		drop.selectByValue("1");
		WebElement oldPriority  = drop.getFirstSelectedOption();
		String text2 = oldPriority.getText();
		System.out.println("The updated priority is : "+text2);

		WebElement stateDropDownEle = driver.findElement(By.xpath("//select[@id='incident.state']"));
		Select drop1 = new Select(stateDropDownEle);
		drop1.selectByValue("2");
		WebElement oldStatus  = drop1.getFirstSelectedOption();
		String text3 = oldStatus.getText();
		System.out.println("The updated status is : "+text3);
		
		
		driver.findElement(By.xpath("//button[@id='sysverb_update_bottom']")).click();
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		WebElement urgDropDownEle1 = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(2000);
		Wait.until(ExpectedConditions.elementToBeClickable(urgDropDownEle1));
		Select dropp= new Select(urgDropDownEle1);
		dropp.selectByValue("1");
		WebElement oldPriority1  = dropp.getFirstSelectedOption();
		String newPriority = oldPriority1.getText();
		System.out.println("The priority is : "+newPriority);
		driver.close();
	/*	WebElement stateDropDownEle1 = driver.findElement(By.xpath("//select[@id='incident.state']"));
		WebDriverWait Wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(2000);
		Wait1.until(ExpectedConditions.elementToBeClickable(stateDropDownEle1));
		Select drops = new Select(stateDropDownEle);
		drops.selectByValue("2");
		WebElement oldStatus1  = drops.getFirstSelectedOption();
		String newStaus = oldStatus1.getText();
		
		System.out.println("The staus is : "+newStaus);
		int compareTo1 = newPriority.compareTo(text2);
		int compareTo2 = newStaus.compareTo(text3);
		if(compareTo1==0 &&compareTo2==0) {
			System.out.println("The Incident "+text+ " updated Successfully");
			

		}else {
			System.out.println("The Incident "+text+ " not updated Successfully");
		}	*/

	}


}
