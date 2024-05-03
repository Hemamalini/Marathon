package marathon.week1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTestCase {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for b");
		driver.findElement(By.xpath("//div[@class='s-suggestion-container']/div[1]")).click();
		String text = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span")).getText();
		System.out.println("The Number of Result : "+text);
		driver.findElement(By.xpath("(// div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left'])[3]")).click();
		driver.findElement(By.xpath("(// div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left'])[4]")).click();
		driver.findElement(By.xpath("//li[@class='a-dropdown-item'][5]")).click();
		String text2 = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")).getText();
		String text3 = driver.findElement(By.xpath("//span[@class='a-offscreen']")).getText();
		String text4 = driver.findElement(By.xpath("//span[@class='a-letter-space']")).getText();
		System.out.println("The bag name is : "+text2);
		System.out.println("The price of bag is : "+text3);
		System.out.println("The discounted price of bag is : "+text4);
		String title = driver.getTitle();
		System.out.println("The page title is : "+title);
		driver.close();
	}

}
