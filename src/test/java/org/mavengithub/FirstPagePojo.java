package org.mavengithub;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstPagePojo extends BaseClass {
	public FirstPagePojo() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement Location;
	@FindBy(id = "hotels")
	private WebElement hotels;
	@FindBy(id = "room_type")
	private WebElement roomType;
	@FindBy(id = "room_nos")
	private WebElement noOfRooms;
	@FindBy(id = "datepick_in")
	private WebElement pickinDate;
	@FindBy(id = "datepick_out")
	private WebElement pickoutDate;
	@FindBy(id = "adult_room")
	private WebElement adultRoom;
	@FindBy(id = "child_room")
	private WebElement childRoom;
	public WebElement getLocation() {
		return Location;
	}
	public WebElement getHotels() {
		return hotels;
	}
	public WebElement getRoomType() {
		return roomType;
	}
	public WebElement getNoOfRooms() {
		return noOfRooms;
	}
	public WebElement getPickinDate() {
		return pickinDate;
	}
	public WebElement getPickoutDate() {
		return pickoutDate;
	}
	public WebElement getAdultRoom() {
		return adultRoom;
	}
	public WebElement getChildRoom() {
		return childRoom;
	}



}
