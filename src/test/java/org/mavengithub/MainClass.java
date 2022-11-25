package org.mavengithub;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainClass extends BaseClass {
	
	@BeforeClass
	private void launchBrow() {
		toOpenChromeDriver();
		launchUrl("http://adactinhotelapp.com/");
		Maximize();

	}

	@Test
	private void loginpage() {
		LoginPojo login = new LoginPojo();
		WebElement userName = login.getUserName();
		fillTextBox(userName, "Nandhini123bala");
		WebElement password = login.getPassword();
		fillTextBox(password, "Nandhubala@15");
		login.getLogin().click();
		

	}

	@Test(dependsOnMethods="loginpage")
	private void firstPageTC() {
		FirstPagePojo firstPage = new FirstPagePojo();
		WebElement location = firstPage.getLocation();
		selectByVisibleText(location, "Los Angeles");
		WebElement hotels = firstPage.getHotels();
		selectByVisibleText(hotels, "Hotel Hervey");
		WebElement roomType = firstPage.getRoomType();
		selectByVisibleText(roomType, "Deluxe");
		WebElement noOfRooms = firstPage.getNoOfRooms();
		selectByVisibleText(noOfRooms, "5 - Five");
		WebElement pickinDate = firstPage.getPickinDate();
		pickinDate.clear();
		fillTextBox(pickinDate, "27/11/2022");
		WebElement pickoutDate = firstPage.getPickoutDate();
		pickoutDate.clear();
		fillTextBox(pickoutDate, "28/11/2022");
		WebElement adultRoom = firstPage.getAdultRoom();
		selectByVisibleText(adultRoom, "3 - Three");
		WebElement childRoom = firstPage.getChildRoom();
		selectByVisibleText(childRoom, "2 - Two");
		
		
	}

}
