package base;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public static RemoteWebDriver driver;

	public static void main(String[] args) {
	
	}

	@BeforeTest
	public static WebDriver openmMegaApp() throws Exception {
		try {	
			DesiredCapabilities cap = new DesiredCapabilities();

			cap.setCapability("deviceName", "vivo 1906");
			cap.setCapability("udid", "65189be4");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "11");
			cap.setCapability("appPackage", "mega.privacy.android.app");
			cap.setCapability("appActivity", "mega.privacy.android.app.main.ManagerActivity");
			cap.setCapability("NEW_COMMAND_TIMEOUT", 60);
			cap.setCapability("automationName", "UiAutomator2");
			
			return driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		} catch ( Exception exp) {
			System.out.println("Cause is :" + exp.getCause());
			System.out.println("Massage is :" + exp.getMessage());
			exp.printStackTrace();
		}
		return driver;
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
