package redBUs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.*;



public class AMAZONSEARCH {
	
	WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		Thread.sleep(2000);
		driver.navigate().to("https://www.amazon.in/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone 16");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		List<WebElement> l1 =  driver.findElements(By.xpath("//span[@class=\"a-price-whole\"]"));
		List <String> l2 = new ArrayList<String>();
		WebElement q ;
		for( int i=0; i<l1.size(); i++) {
			 q = l1.get(i);
			l2.add(q.getText());
			
		}
		System.out.println(l2);
		driver.quit();
}
	
}
