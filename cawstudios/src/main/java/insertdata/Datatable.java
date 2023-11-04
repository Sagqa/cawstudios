package insertdata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Datatable {
	WebDriver driver;
	@Test
	public void data() throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
		driver.findElement(By.tagName("details")).click();
		String jsondata="[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, {\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, {\"name\":\r\n"
				+ "\"Sara\", \"age\" : 42, \"gender\": \"female\"}, {\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, {\"name\":\r\n"
				+ "\"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]";
	
	driver.findElement(By.id("jsondata")).clear();
	driver.findElement(By.id("jsondata")).sendKeys(jsondata);
	Thread.sleep(2000);
	driver.findElement(By.id("refreshtable")).click();

	String data=driver.findElement(By.tagName("table")).getText();
	}
}
