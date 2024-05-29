package com.ShoppersStack_testScripts;

import java.io.IOException;

import javax.swing.text.Utilities;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ShoppersStack.genericUtility.Base_Test;
import com.ShoppersStack.pom.AddressForm_Page;
import com.ShoppersStack.pom.Home_Page;
import com.ShoppersStack.pom.MyAddress_Page;
import com.ShoppersStack.pom.Myprofile_Page;

public class Verify_user_is_able_add_address_or_not_Test extends Base_Test {


	@Test
	public void addAdress() throws EncryptedDocumentException, IOException {
		homePage.getAccountSettingBtn().click();
		homePage.getMyProfileBtn().click();
		
		Myprofile_Page  myProfile = new Myprofile_Page(driver);
		myProfile.getMyAddressBtn().click();
		
		MyAddress_Page myAddress = new MyAddress_Page(driver);
		myAddress.getAddAddressBtn().click();
		
		AddressForm_Page  addressForm = new AddressForm_Page(driver);
		addressForm.getNameTF().sendKeys(file.readExcelData("Sheet1", 1, 0));
		addressForm.getHouseTF().sendKeys(file.readExcelData("Sheet1", 1, 1));
		addressForm.getStreetTF().sendKeys(file.readExcelData("Sheet1", 1, 2));
		addressForm.getLandmarkTF().sendKeys(file.readExcelData("Sheet1", 1, 3));
		webDriverUtility.selectByValue(addressForm.getCountryDD(), file.readPropertyData("country"));
		webDriverUtility.selectByValue(addressForm.getStateDD(), file.readPropertyData("state"));
		webDriverUtility.selectByValue(addressForm.getCityDD(), file.readPropertyData("city"));
		addressForm.getPincodTF().sendKeys(file.readExcelData("Sheet1", 1, 4));
		addressForm.getPhoneNumberTF().sendKeys(file.readExcelData("Sheet1", 1, 5));
		addressForm.getAddAdressBtn().click();
		
	}
}
