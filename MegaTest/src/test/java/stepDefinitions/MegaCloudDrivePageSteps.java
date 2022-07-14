package stepDefinitions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MegaCloudDrivePage;

public class MegaCloudDrivePageSteps extends BaseClass{

	RemoteWebDriver driver = null;
	MegaCloudDrivePage megacloudpage;


	@Given("Open MEGA app")
	public void open_Mega_App() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "vivo 1906");
		cap.setCapability("udid", "65189be4");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("appPackage", "mega.privacy.android.app");
		cap.setCapability("appActivity", "mega.privacy.android.app.main.ManagerActivity");
		cap.setCapability("NEW_COMMAND_TIMEOUT", 60);
		cap.setCapability("automationName", "UiAutomator2");
		
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}

	@And("User login to MEGA app using (.*) and (.*)$")
	public void user_login_Mega_App(String eMail, String password) throws Exception {
		megacloudpage = new MegaCloudDrivePage(driver);
		megacloudpage.userLogIn(eMail, password);
	}

	@And("Navigate to Cloud Drive page")
	public void navigate_to_cloud_drive_page() throws Exception {	
		megacloudpage.navigateToCloudDrive();
	}

	@When("Create a text file named (.*)$")
	public void create_a_text_file_named_a_txt(String fileName) {
		megacloudpage.createTextFile(fileName);
	}

	@When("Type content as (.*) in it and save$")
	public void type_content_as_megatesting_in_it_and_save(String contentText) {
		megacloudpage.addContentToFile(contentText);
	}

	@Then("Validate created (.*) in cloud drive$")
	public void validate_created_a_txt_in_cloud_drive(String Fname) {
		megacloudpage.validateFileInCloudList(Fname);
	}

	@When("Delete the text file which is created in Test Case 1")
	public void delete_the_text_file_named_a_txt() {
		megacloudpage.deleteTextFile();
	}

	@Then("Validate file deletion in cloud drive$")
	public void validate_deletion_in_cloud_drive() {
		megacloudpage.validateDeletionOfFile();
	}

	@Given("Navigate to rubbish bin")
	public void navigate_to_rubbish_bin() {
		megacloudpage.navigateToRubbishBin();
	}

	@When("Select and restore a.txt")
	public void select_and_restore_a_txt() {
		megacloudpage.restoreTextFile();
	}

	@Then("Validate restored (.*) in cloud drive$")
	public void validate_restored_a_txt_in_cloud_drive(String Fname) {
		megacloudpage.validateFileInCloudList(Fname);
	}

}
