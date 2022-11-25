package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Actions act;
	public static Robot r;
	public static Alert a;
	public static TakesScreenshot snap;
	public static JavascriptExecutor js;
	public static Select sel;
	public static Date da;

//1	
	public static void toOpenChromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

//2
	public static void toOpenFirefoxDriver() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

//3
	public static void toOpenEdgeDriver() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

//4
	public static void Maximize() {
		driver.manage().window().maximize();
	}

//5
	public static String toFetchTitle() {

		String title = driver.getTitle();
		return title;
	}

//6
	public static String toGetCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

//7
	public static void launchUrl(String url) {

		driver.get(url);

	}

//8
	public static void toCloseCurrentTab() {
		driver.close();
	}

//9	
	public static void fillTextBox(WebElement element, String input) {

		element.sendKeys(input);

	}

//10	
	public static void toClick(WebElement ele) {
		ele.click();

	}

//11	
	public static void togetText(WebElement text) {

		String text2 = text.getText();
		System.out.println(text2);

	}

//12   
	public static String toGetAttribute(WebElement element, String attirubutename) {
		String attributeValue = element.getAttribute(attirubutename);
		return attributeValue;
	}

	// 13
	public static void toMoveCursor(WebElement ele) {
		act = new Actions(driver);

		act.moveToElement(ele).perform();

	}

//14   
	public static void toDragAndDrop(WebElement ele1, WebElement ele2) {
		act = new Actions(driver);

		act.dragAndDrop(ele1, ele2).perform();

	}

//15  
	public static void toDoubleClick(WebElement click) {
		act.doubleClick(click).perform();

	}

//16  
	public static void toRightClick(WebElement rightClick) {
		act.contextClick(rightClick).perform();

	}

//17   
	public static void Enter() throws AWTException {

		r = new Robot();

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	// 18
	public static void Tab() throws AWTException {

		r = new Robot();

		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

	}

	// 19
	public static void Down() throws AWTException {

		r = new Robot();

		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

	}

//20 
	public static void Copy() throws AWTException {

		r = new Robot();

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}

	// 21
	public static void Paste() throws AWTException {

		r = new Robot();

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}

	// 22
	public static void SelectAll() throws AWTException {

		r = new Robot();

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
	}

//23	
	public static void toAccept() {

		a = driver.switchTo().alert();
		a.accept();
	}

//24	
	public static void toDismiss() {

		a = driver.switchTo().alert();
		a.dismiss();
	}

//25	
	public static void toSendkeys(String input) {

		a = driver.switchTo().alert();
		a.sendKeys(input);
	}

//26	
	public static void togetData() {

		a = driver.switchTo().alert();
		String data = a.getText();
		System.out.println(data);
	}

//27	
	public static void toInsertValues(WebElement element1, String insertvalue) {

		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('value'," + "'" + insertvalue + "')", element1);

	} // doubt
//28	

	public static void javaClick(WebElement scriptClick) {

		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click()", scriptClick);
	}

//29	
	public static void returnGivenvalue(WebElement returndata) {

		js = (JavascriptExecutor) driver;

		js.executeScript("return arguments[0].getAttribute(value)", returndata);

	}

//30
	public static void returnArugument(WebElement returnargumentvalue, String attirbutename) {

		js = (JavascriptExecutor) driver;

		js.executeScript("return arguments[0].getAttribute(attirbutename)", returnargumentvalue);
	}

	// 31
	public static void toScrollDown(WebElement scrlDown) {
		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true)", scrlDown);
	}

	// 32
	public static void toScrollUp(WebElement scrlUp) {
		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(false)", scrlUp);

	}

	// 33
	public static void toTakeSnap(String name) throws IOException {

		snap = (TakesScreenshot) driver;

		File screenshotAs = snap.getScreenshotAs(OutputType.FILE);

		File permenentFolder = new File(
				"C:\\Users\\USER-PC\\eclipse-workspace\\FrameWorkMaven\\ScreenShots" + name + ".png");

		FileUtils.copyFile(screenshotAs, permenentFolder);
	}

	// 34
	public static void selectByValue(WebElement dropdown, String value) {

		sel = new Select(dropdown);

		sel.selectByValue(value);

	}

	// 35
	public static void selectByIndex(WebElement dropdown, int byInt) {

		sel = new Select(dropdown);

		sel.selectByIndex(byInt);
		;
	}

//36
	public static String selectByVisibleText(WebElement dropdown, String byText) {

		sel = new Select(dropdown);

		sel.selectByVisibleText(byText);
		return byText;

	}

//37
	public static void checkMultiple(WebElement dropdown) {

		sel = new Select(dropdown);

		boolean multiple = sel.isMultiple();
		System.out.println(multiple); // doubt

	}

//38
	public static void toFetchAll(WebElement dropdown) {

		sel = new Select(dropdown);

		List<WebElement> options = sel.getOptions();

		for (int i = 0; i < options.size(); i++) {
			WebElement eachOption = options.get(i);
			String printEach = eachOption.getText();
			System.out.println(printEach);

		}
	}

//39
	public static void allSelected(WebElement dropdown) {
		sel = new Select(dropdown);
		
		List<WebElement> allSel = sel.getAllSelectedOptions();

		for (int i = 0; i < allSel.size(); i++) {
			WebElement eachOption = allSel.get(i);
			String text = eachOption.getText();
			System.out.println(text);

		}
		

	}

//40
	public static void toFetchFirstSelected(WebElement dropdown) {

		sel = new Select(dropdown);
		WebElement firstSelected = sel.getFirstSelectedOption();
		System.out.println(firstSelected);

	}

//41
	public static void toDeSelectedbyIndex(WebElement dropdown, int desel) {

		sel = new Select(dropdown);
		sel.deselectByIndex(desel);

	}

//42
	public static void toDeSelectedbyValue(WebElement dropdown, String value) {

		sel = new Select(dropdown);
		sel.deselectByValue(value);

	}

//43
	public static void toDeSelectedbyVisibletext(WebElement dropdown, String text) {

		sel = new Select(dropdown);
		sel.deselectByVisibleText(text);

	}

//44 
	public static void toDeselectAll(WebElement dropdown) {
		sel = new Select(dropdown);
		sel.deselectAll();

	}
//45

	public static void toWait(int minutues) throws InterruptedException {
		Thread.sleep(minutues);

	}

//46
	public static void toSwitchtoWindow(int indexOfWindow) {

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> listWindows = new ArrayList<String>(windowHandles);

		driver.switchTo().window(listWindows.get(indexOfWindow));

	}
//47

	public static void toCloseBrowser() {
		driver.quit();
	}

//48
	public static void toSwitchToFramebyElementRef(WebElement element) {

		driver.switchTo().frame(element); // doubt
	}

	// 49
	public static void toSwitchToFramebyIndex(int position) {

		driver.switchTo().frame(position); // doubt
	}

	// 50
	public static void toSwitchToFramebyString(String name) {

		driver.switchTo().frame(name); // doubt
	}

	// 51
	public static void toCountNoOfFrames(String allTags) {

		List<WebElement> sizeOfFrames = driver.findElements(By.tagName(allTags));
		int size = sizeOfFrames.size();
		System.out.println(size);
	}
//52

	public static void noOfNonSelectedOptions(WebElement element) {
		sel = new Select(element);

		List<WebElement> allOptions = sel.getOptions();
		int allOptionsSize = allOptions.size();

		List<WebElement> allSelectedOptions = sel.getAllSelectedOptions();
		int sizeOfSelectedOptions = allSelectedOptions.size();

		int nonSelected = allOptionsSize - sizeOfSelectedOptions;
		System.out.println(nonSelected);
	}

//53

	public static void toGetNonSelectedOptions(WebElement element) {

		sel = new Select(element);

		List<WebElement> allOptions = sel.getOptions();

		List<WebElement> allSelectedOptions = sel.getAllSelectedOptions();

		allOptions.removeAll(allSelectedOptions);

		for (WebElement eachOptions : allOptions) {

			String text = eachOptions.getText();
			System.out.println(text);

		}

	}

	public static String readDataFromExcel(String folderName, String sheetName, int rowNo, int cellNo)
			throws IOException {

		File fil = new File(
				"C:\\Users\\USER-PC\\eclipse-workspace\\FrameWorkMaven\\ExcelSheets\\" + folderName + ".xlsx");

		FileInputStream toReadFile = new FileInputStream(fil);

		Workbook book = new XSSFWorkbook(toReadFile);

		Sheet registerSheet = book.getSheet(sheetName);

		Row rowData = registerSheet.getRow(rowNo);

		Cell cellData = rowData.getCell(cellNo);

		int cellType = cellData.getCellType();
		String input;
		if (cellType == 1) {

			input = cellData.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cellData)) {

			Date dateCellValue = cellData.getDateCellValue();

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			input = dateFormat.format(dateCellValue);

		} else {
			double numericCellValue = cellData.getNumericCellValue();

			long l = (long) numericCellValue;
			input = String.valueOf(l);

		}
		return input;

	}

	public static void createRowSetCellValue(String foldername, int sheetInt, int rowInt, int cellInt, String status)
			throws IOException {

		File f = new File(
				"C:\\Users\\USER-PC\\eclipse-workspace\\FrameWorkMaven\\ExcelSheets\\" + foldername + ".xlsx");

		FileInputStream toreadFile = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(toreadFile);
		Sheet sheetAt = book.getSheetAt(sheetInt);
		Row createRow = sheetAt.createRow(rowInt);
		Cell createCell = createRow.createCell(cellInt);
		createCell.setCellValue(status);
		
		FileOutputStream toWriteFile = new FileOutputStream(f);
		book.write(toWriteFile);

	}

	public static void toSetCellValueinExistingRow(String folderName, int sheetInt, int RowInt, int cellInt,
			String value) throws IOException {
		File f = new File(
				"C:\\Users\\USER-PC\\eclipse-workspace\\FrameWorkMaven\\ExcelSheets\\" + folderName + ".xlsx");
		FileInputStream toReadFile = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(toReadFile);
		Sheet sheetAt = book.getSheetAt(sheetInt);
		Row row = sheetAt.getRow(RowInt);
		Cell createCell = row.createCell(cellInt);
		createCell.setCellValue(value);

		FileOutputStream toWriteFile = new FileOutputStream(f);
		book.write(toWriteFile);

	}

	public static void createExcel(String folderName, String SheetName, int rowCount) throws IOException {

		File f = new File(
				"C:\\Users\\USER-PC\\eclipse-workspace\\FrameWorkMaven\\ExcelSheets\\" + folderName + ".xlsx");
		Workbook book = new XSSFWorkbook();
		Sheet createSheet = book.createSheet(SheetName);
		for (int i = 0; i < rowCount; i++) {
			createSheet.createRow(i);

		}

		FileOutputStream toWriteFile = new FileOutputStream(f);
		book.write(toWriteFile);

	}

	public static void dateAndTime() {

		da = new Date();
		System.out.println(da);

	}
	
	

}
