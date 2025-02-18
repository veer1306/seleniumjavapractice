package redBUs;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.IAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class redBus {

	public static void main(String[] args) throws IOException, InterruptedException {
		
	

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.redbus.in/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act = new Actions(driver);
		driver.manage().window().maximize();
		WebElement from = driver.findElement(By.xpath("//label[contains(text(),'From')]//preceding::input[1]"));
		WebElement to = driver.findElement(By.xpath("//label[contains(text(),'To')]//preceding::input[1]"));
		from.sendKeys("vis");

		WebElement city = driver.findElement(By.xpath("//li[@class='sc-iwsKbI jTMXri']"));
     
//wait.until(ExpectedConditions.elementToBeClickable(city));
		List<WebElement> l1 = driver.findElements(By.xpath("//li[@class='sc-iwsKbI jTMXri cursorPointing']"));

		for (int i = 0; i < l1.size(); i++) {

			System.out.println(l1.get(i).getText());
			String pl = l1.get(i).getText();
			Assert.assertEquals(pl, "Visakhapatnam");
			l1.get(i).click();

		}
		
		
		Thread.sleep(2000);
		to.sendKeys("hyd");
		 WebElement drop= driver.findElement(By.xpath("//div[@id='homeV2-root']//li[2]"));
		drop.click();
		
		driver.navigate().refresh();
		act.contextClick(driver.findElement(By.id("rail_tickets_vertical"))).perform();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File tn = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(tn, new File("./image2.png"));
		
		File data = new File("C://Users//Admin//Downloads//tests-example.xls");
		FileInputStream source = new FileInputStream(data);
		HSSFWorkbook xls = new HSSFWorkbook(source);
		HSSFSheet datasheet = xls.getSheetAt(1);
		String s1 = datasheet.getRow(9).getCell(1).getStringCellValue();
		
		System.out.println(s1);
		xls.close();
		

		driver.quit();
	}
}
