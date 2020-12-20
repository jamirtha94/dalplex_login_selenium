package selenium;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class dalplexlogin {

	private static final String username = "Sanjay";

	private static final String userdate = "November 21";

	private static final String usertime = "1:00 PM";

	public static void main(String args[]) throws InterruptedException {
		// getting the browsers ready
		System.setProperty("webdriver.chrome.driver", "/Users/sanjaykumar/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://athletics.dal.ca/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// book an appointment by navigating to next page
		Thread.sleep(2000);

		System.out.println(driver.getTitle());

		driver.navigate().to(
				"https://www.dalsports.dal.ca/Program/GetProducts?classification=f22e8568-5cb8-464f-93f6-b390759240de");

		System.out.println(driver.getTitle());

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		
		// navigate to next page and check if the right page is opened

		String result = driver.findElement(By.xpath("//*[@id='mainContent']/div[2]/div[1]/div/div[1]/h1")).getText();

		System.out.println(result);

		if (result.equals("Search Programs")) {
			assert true;
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			// click on appointment for fitness hall
			driver.findElement(By.xpath("//*[@id='filterCategories']/div/div/div/div[2]/ul/li[5]/a")).click();
			driver.navigate().refresh();

			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			// click on fitness hall appointment to create registration for the
			// user.
			driver.findElement(By.xpath("//*[@id='list-group']/div/div/div[1]/img")).click();

			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			// click on register button
			String registerXpath = "//h4/span[contains(text(),'" + userdate + "')]/parent::h4/small[contains(text(),'"
					+ usertime + "')]/parent::h4/following-sibling::a[contains(text(), 'Register')]";
			// String nospot =
			// "//h4/span[contains(text(),'"+userdate+"')]/parent::h4/small[contains(text(),'"+usertime+"')]/parent::h4/following-sibling::div/div/span[contains(text(),
			// 'No Spots Available')]";
			driver.findElement(By.xpath(registerXpath)).click();
			System.out.println("Success");

			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("sn752089");

			driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("S4nj4y@11");

			driver.findElement(By.xpath("//*[@id='btnLogin']")).click();

			// driver.get("https://sn752089:S4nj4y@11@www.dalsports.dal.ca/Account/Login?returnUrl=%2FProgram%2FGetProgramDetails%3FcourseId%3D8993d840-c85b-4afb-b8a9-3c30b3c16817%26semesterId%3D1be74935-05a0-4a08-b0aa-3835ce18bad9");

			Thread.sleep(8000);

			Boolean result1 = driver.findElement(By.xpath("//h1[contains(text(), 'Program Details')]")).isDisplayed();

			if (result1 == true) {
				assert true;
				System.out.println("Logged In Successfully");
				Thread.sleep(8000);
				// System.out.println(driver.findElement(By.xpath(registerXpath)));
				// System.out.println(driver.findElement(By.xpath(nospot)));
				// check for registration after clicking on register in the
				// previous prompt

				boolean hasRegister = true;
				try {
					driver.findElement(By
							.xpath("//h4/span[contains(text(), 'November 21')]/parent::h4/small[contains(text(), '1:00 PM')]/parent::h4/following-sibling::div/button[contains(text(), 'Register')]"))
							.isDisplayed();
				} catch (NoSuchElementException e) {
					hasRegister = false;
				}

				if (hasRegister) {
					System.out.println("Test1");
					driver.findElement(By
							.xpath("//h4/span[contains(text(), 'November 21')]/parent::h4/small[contains(text(), '1:30 PM')]/parent::h4/following-sibling::div/button[contains(text(), 'Register')]"))
							.click();
					Thread.sleep(5000);

					driver.findElement(By.xpath("//label[contains(text(),'" + username
							+ "')]/parent::div/following-sibling::div[2]/button")).click();
					Thread.sleep(5000);

					driver.findElement(By.xpath("//h1[contains(text(), 'review')]")).isDisplayed();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='CustomPrompts_0__CommonInput']")).sendKeys("SM");
					driver.findElement(By.xpath("//*[@id='CustomPrompts_1__CommonInput']")).sendKeys("SM");
					driver.findElement(By.xpath("//*[@id='CustomPrompts_2__CommonInput']")).sendKeys("SM");
					driver.findElement(By.xpath("//*[@id='CustomPrompts_3__CommonInput']")).sendKeys("SM");
					driver.findElement(By.xpath("//*[@id='CustomPrompts_4__CommonInput']")).sendKeys("SM");
					driver.findElement(By.xpath("//button[contains(text(), 'Cart')]")).click();
					// driver.findElement(By.xpath("//button[contains(text(),
					// 'Remove')]")).click();
					System.out.println("Test2");
					// driver.close();
				}

				// } else
				// if(driver.findElement(By.xpath("//h4/span[contains(text(),
				// 'November 21')]/parent::h4/small[contains(text(), '1:30
				// PM')]/parent::h4/following-sibling::div/div/span[contains(text(),
				// 'No Spots')]")).isDisplayed()){
				// System.out.println("no spots available for date"+userdate);
				//
				// driver.close();
				// }
				else {
					System.out.println("no spots available for date" + userdate);
					driver.close();
				}
			} else {
				System.out.println("Failed to Login");
				driver.close();
			}

		}

	}
}
