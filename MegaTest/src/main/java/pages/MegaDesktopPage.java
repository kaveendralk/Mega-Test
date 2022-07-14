package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseClass;
import utils.ProjectUtils;

public class MegaDesktopPage extends BaseClass {

	WebDriver driver;

	public MegaDesktopPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}



	@FindBy(xpath = "//span[contains(text(),'What is MEGA?')]/following::span[text()=' Linux '][1]")
	WebElement btnLinux;

	@FindBy(xpath = "//span[contains(text(),'What is MEGA?')]/following::span[contains(text(),'Please select')][1]")
	WebElement drpChooseLinuxVersion;

	@FindBy(xpath = "//span[contains(text(),'What is MEGA?')]/following::button[text()=' Download '][1]")
	WebElement btnDownload;



	/* validate the user lands correct page*/

	public void ValidateUserInDesktopPage() {
		if(!driver.getTitle().equals("Desktop App - MEGA")) {
			throw new IllegalStateException("This is not Desktop App - MEGA. Current page is " + driver.getCurrentUrl());
		}
	}


	/* User clicks Linux button*/

	public void clickLinuxButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		btnLinux.click();
	}


	/* validate all the Linux Distros in the list are downloadable */

	public boolean validateDownloadLinuxDistros(String distroName, String link) throws Exception {
		try {		
			drpChooseLinuxVersion.click();
			WebElement dropdownOption = driver.findElement(By.xpath("//span[contains(text(),'What is MEGA?')]/following::span[contains(text(),'"+ distroName +"')][1]"));
			dropdownOption.click();			
			if(btnDownload.getAttribute("data-link").contentEquals(link)) {
				btnDownload.click();
				return true;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

	/* validate all Linux Distros are downloaded successfully */

	public boolean validateDownloaddedFilesInDownloadFolder(String filName) throws Exception {
		try {		
			Thread.sleep(10000);
			String home = System.getProperty("user.home");
			String downloadPathNew = home + "\\Downloads\\";
			ProjectUtils.verifyDownloadedFileName(downloadPathNew, filName); 
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}
}
