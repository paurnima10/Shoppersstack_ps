package com.ShoppersStack_testScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.ShoppersStack.genericUtility.Base_Test;
import com.ShoppersStack.pom.AddressForm_Page;
import com.ShoppersStack.pom.MyAddress_Page;
import com.ShoppersStack.pom.Myprofile_Page;

public class Verify_user_is_able_to_update_address_or_not extends Base_Test {
	@Test
	public void updateAdress() throws EncryptedDocumentException, IOException, InterruptedException {
	homePage.getAccountSettingBtn().click();
	homePage.getMyProfileBtn().click();
	
	Myprofile_Page  myProfile = new Myprofile_Page(driver);
	myProfile.getMyAddressBtn().click();
	
	MyAddress_Page myAddress = new MyAddress_Page(driver);
	myAddress.getEditBtn().click();
	
	AddressForm_Page  addressForm = new AddressForm_Page(driver);
	addressForm.getNameTF().clear();
	Thread.sleep(2000);
	addressForm.getNameTF().sendKeys(file.readExcelData("Sheet1", 2, 0));
	addressForm.getHouseTF().clear();
	Thread.sleep(2000);
	addressForm.getHouseTF().sendKeys(file.readExcelData("Sheet1", 2, 1));
	addressForm.getStreetTF().clear();
	Thread.sleep(2000);
	addressForm.getStreetTF().sendKeys(file.readExcelData("Sheet1", 2, 2));
	addressForm.getLandmarkTF().clear();
	Thread.sleep(2000);
	addressForm.getLandmarkTF().sendKeys(file.readExcelData("Sheet1", 2, 3));
	Thread.sleep(2000);
	addressForm.getUpdateAdressBtn().click();

}
}
