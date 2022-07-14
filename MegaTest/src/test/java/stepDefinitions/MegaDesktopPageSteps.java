package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MegaDesktopPage;

public class MegaDesktopPageSteps {

	WebDriver driver = null;
	MegaDesktopPage megadesktoppage;

	@Given("Open the browser")
	public void browserIsOpen() {
		 
		String projectPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}
	
	@And("Navigate to MEGA desktop page")
	public void navigateToMEGADdesktop() {
		megadesktoppage = new MegaDesktopPage(driver);
		driver.navigate().to("https://mega.io/desktop");
		megadesktoppage.ValidateUserInDesktopPage();
	}

	@Then("Click Linux button which is comes under Download the MEGA Desktop App for your platform")
	public void clickLinuxButton() {
		megadesktoppage.clickLinuxButton();
	}

	@When("Download each distro (.*) and validate the download link (.*)$")
	public boolean downloadLinuxDistro(String distro, String link) throws Exception {
		return megadesktoppage.validateDownloadLinuxDistros(distro, link);	
	}
	
	@Then("Validate downloaded distro (.*) in download folder$")
	public boolean validateDownloaddedFilesInDownloadFolder(String filName) throws Exception {
		return megadesktoppage.validateDownloaddedFilesInDownloadFolder(filName);	
	}

	@Then("Close the browser")
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

}
