package pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class MegaCloudDrivePage extends BaseClass {

	WebDriver driver;

	public MegaCloudDrivePage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "mega.privacy.android.app:id/button_login_tour")
	WebElement btnLogIn;

	@FindBy(id = "mega.privacy.android.app:id/login_email_text")
	WebElement txtEmail;

	@FindBy(id = "mega.privacy.android.app:id/login_password_text")
	WebElement txtPassword;

	@FindBy(id = "mega.privacy.android.app:id/button_login_login")
	WebElement btnLgIn;

	@FindBy(id = "mega.privacy.android.app:id/not_now_button")
	WebElement btnNotNow;

	@FindBy(id = "mega.privacy.android.app:id/file_list_filename")
	WebElement txtFileNameInList;

	@FindBy(id = "mega.privacy.android.app:id/navigation_bar_item_icon_view")
	WebElement btnCloudFolder;

	@FindBy(id = "mega.privacy.android.app:id/floating_button")
	WebElement btnCreateNewItem;

	@FindBy(id = "mega.privacy.android.app:id/new_txt_option")
	WebElement btnCreateNewTextFile;

	@FindBy(id = "mega.privacy.android.app:id/type_text")
	WebElement txtFileName;

	@FindBy(id = "android:id/button1")
	WebElement btnCreate;

	@FindBy(id = "mega.privacy.android.app:id/content_edit_text")
	WebElement txtEditContent;

	@FindBy(id = "mega.privacy.android.app:id/action_save")
	WebElement btnSave;

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	WebElement btnBack;

	@FindBy(id = "mega.privacy.android.app:id/file_list_three_dots")
	WebElement btnThreeDots;

	@FindBy(id = "mega.privacy.android.app:id/rubbish_bin_option")
	WebElement btnMoveToRubbishBin;

	@FindBy(id = "android:id/button1")
	WebElement btnMove;

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	WebElement btnMenu;

	@FindBy(id = "mega.privacy.android.app:id/rubbish_bin_section")
	WebElement btnRubbishBin;

	@FindBy(id = "mega.privacy.android.app:id/restore_option")
	WebElement btnRestore;

	@FindBy(id = "android:id/button1")
	WebElement btnDelete;

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	WebElement btnBackk;
	
	@FindBy(id = "mega.privacy.android.app:id/sorted_by")
	WebElement lblSortedBy;

	
	/* Validate the user navigate to cloud drive page */

	public void navigateToCloudDrive() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		btnCloudFolder.click();
	}
	
	/* User login to Mega app */

	public void userLogIn(String eMail, String password) {
		try{
			btnLogIn.click();
			txtEmail.sendKeys(eMail);
			txtPassword.sendKeys(password);
			btnLgIn.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			btnNotNow.click();
		}catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
	}

	/* Create a new text file */

	public void createTextFile(String fileName) {
		try{
			btnCloudFolder.click();
			btnCreateNewItem.click();
			btnCreateNewTextFile.click();
			txtFileName.sendKeys(fileName);
			btnCreate.click();
		}catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
	}

	/* Validate created file */

	public void validateFileInCloudList(String Fname) {
		try{
			String fName = txtFileNameInList.getText();
			assertEquals(fName, fName);
		}catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
	}

	/* Add content to text file */

	public void addContentToFile(String contentText) {
		try{
			txtEditContent.sendKeys(contentText);
			btnSave.click();
		}catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
	}

	/* Delete the text file */

	public void deleteTextFile() {
		try{
			btnThreeDots.click();
			btnMoveToRubbishBin.click();
			btnMove.click();
		}catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
	}

	/*Validate file is deleted from list*/

	public boolean validateDeletionOfFile(){
		try {

			if (driver.findElements(By.id("mega.privacy.android.app:id/file_list_filename")).size() > 0) {				 
				return false;
			}
		}catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
		return true;
	}

	/* Navigate to rubbish bin */

	public void navigateToRubbishBin() {
		try{
			btnMenu.click();
			btnRubbishBin.click();
		}catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
	}

	/* Restore deleted text file */

	public void restoreTextFile() {
		try{
			btnRestore.click();
			btnBack.click();
		}catch (NoSuchElementException e) {
			e.printStackTrace();
		} 
	}
}
