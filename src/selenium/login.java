package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/Users/sanjaykumar/Downloads/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://app.proposify.org/login");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='pyLoginEmail']")).sendKeys("abishek.rajkumar+integrations@proposify.com");
		driver.findElement(By.xpath("//*[@id='pyLoginPassword']")).sendKeys("abishek1234");
		driver.findElement(By.xpath("//*[@id='pyLoginFormSubmitButton']")).isDisplayed();
		//driver.wait(5);
		String result = driver.findElement(By.xpath("//*[@id='pyNewProposalButton']")).getAttribute("id");
		if (result.equals("pyNewProposalButton")){
			assert true;
			System.out.println("Success");
			driver.close();
		}
		else {
			System.out.println("failed");
			driver.close();
		}
		
		
	}

}
