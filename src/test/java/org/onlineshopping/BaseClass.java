package org.onlineshopping;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	WebDriver  driver;
	Select select;
	Alert alert;

	// 1.Write a code to launch ChromeBrowser
	public void chromeBrowserLaunch() {
		driver = new ChromeDriver();
	}
	// 2.Write a code to launch FirefoxBrowser
	public void firefoxBrowserLaunch() {
		driver = new FirefoxDriver();
	}
	// 3.Write a code to launch IEBrowser
	public void internetExplorerLaunch() {
		driver = new InternetExplorerDriver();
	}
	// 4.Write a code to launch EdgeBrowser
	public void edgeBrowserLaunch() {
		driver = new EdgeDriver();
	}
	// 5.Write a code to enter url
	public void enterApplnUrl(String url) {
		driver.get(url);
	}
	// 6.Write a code to maximizeWindow
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	// 7.Write a code to Insert values in textbox
	public void elementSendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}
	// 8.Write a code to click button
	public void elementClick(WebElement element) {
		element.click();
	}
	// 9.Write a code to click ok in alert
	public void confirmAlert() {
		alert = driver.switchTo().alert();
		alert.accept();
	}
	// 10.Write a code to click cancel in alert
	public void cancelAlert() {
		alert = driver.switchTo().alert();
		alert.dismiss();
	}
	// 11.Write a code to get the text from webpage
	public WebElement getTextFromWeb(WebElement element, String value) {
		
		WebElement ele = driver.findElement(By.xpath(value));
		return element;
	}
	// 12.Write a code to get the inserted value from textbox
	public WebElement getInsertedValue(WebElement element, String value) {
		element = driver.findElement(By.id(value));
		return element;
	}
	// 13.Write a code to close the window
	public void closeDriver() {

		driver.close();
	}
	// 14.Write a code to get the title
	public String getApplnTitle() {
		String title = driver.getTitle();
		return title;
	}
	// 15.Write a code to get the entered url
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	// 16.Write a code to select dropdown option by text
	public WebElement selectDropdownText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
		return element;
	}
	// 17.Write a code to select dropdown option by attribute
	public WebElement selectDropdownAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
		return element;
	}
	// 18.Write a code to select dropdown option by index
	public WebElement selectDropdownIndex(WebElement element, int value) {
		Select select = new Select(element);
		select.selectByIndex(value);
		return element;
	}
	// 19.Write a code to insert value in a textbox by javascript
	public void textInsertJavascript(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].SetAttribute('value','username')",element);
	}
	// 20.Write a code to click button by javascript
	public void clickBtnJavascript(WebElement close) {
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("argument[0].click()", close);
	}
	// 21.Write a code to switch to child window
	public void switchToChildWindow() {
		String pWindow = driver.getWindowHandle();

		Set<String> windowHandles = driver.getWindowHandles();

		for (String eachWindow : windowHandles) {
			if (!pWindow.equals(eachWindow)) {
				driver.switchTo().window(eachWindow);
			}
		}
	}
	// 22.Write a code to switch to frame by index
	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}
	// 23.Write a code to switch to frame by frame id/name
	public void switchToFrameByIdOrName(String id) {
		driver.switchTo().frame(id);
	}
	// 24.Write a code to switch to frame by webelement
	public void swithToFrameByWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	// 25.Write a code to switch to find locator by id
	public WebElement findLocatorById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}
	// 26.Write a code to switch to find locator by name
	public WebElement findLocatorByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}
	// 27.Write a code to switch to find locator by classname
	public WebElement findLocatorByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}
	// 28.Write a code to switch to find locator by xpath
	public WebElement findLocatorByXpath(String attributeValue) {
		WebElement element = driver.findElement(By.xpath(attributeValue));
		return element;
	}
	// 29.Write a code to get all options from dropdown as text
	public List<String> getAllOptionsText(WebElement element) {
		select = new Select(element);
		List<WebElement> options = select.getOptions();

		List<String> allOptions = new ArrayList<>();

		for (WebElement webElement : options) {
			String text = webElement.getText();
			allOptions.add(text);
		}
		return allOptions;
	}
	
	

	// 30.Write a code to get all options from dropdown as value
	 public List<String> getDropdownValues(WebElement dropdownElement) {
		 
		 List<String> values = new ArrayList<>();
 
	     Select select = new Select(dropdownElement);

	        for (WebElement option : select.getOptions()) {
	            values.add(option.getAttribute("value"));
	        }
	        return values;
	    }
		
	// 31.Write a code to get the first selected option text in dropdown
	 public String getFirstSelectedOptionText(WebElement dropdownElement) {

	        Select select = new Select(dropdownElement);
	        
	        WebElement firstSelectedOption = select.getFirstSelectedOption();
	        
	        return firstSelectedOption.getText();
	    }

	// 32.Write a code to get the verify in dropdown is multiselect option
	 public boolean isMultiSelectDropdown(WebElement dropdownElement) {

		 	Select select = new Select(dropdownElement);
	        
	        return select.isMultiple();
	    }
	
	 
	 
	 
	// 33.Write a code to implicit wait
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	public void implicitWait(int secs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}
	// 34.Write a code to explicit wait for visibilityof
	public void visibilityOfElement(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}
	// 35.Write a code to fluent wait
	// 36.Write a code to verify isDisplayed
	public boolean elementIsDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}
	// 37.Write a code to verify isEnabled
	public boolean elementIsEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}
	// 38.Write a code to verify isSelected
	public boolean elementIsSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}
	
	
	
	// 39.Write a code to deselect option by index in dropdown
	public void deselectOptionByIndex(WebElement dropdownElement, int index) {

		Select select = new Select(dropdownElement);
       
        if (select.isMultiple()) {
            select.deselectByIndex(index);
        } else {
            System.out.println("This dropdown does not support multiple selections.");
        }
    }
	// 40.Write a code to deselect option by text in dropdown
	 public void deselectOptionByText(WebElement dropdownElement, String visibleText) {

		 Select select = new Select(dropdownElement);
	        
	        if (select.isMultiple()) {
	            select.deselectByVisibleText(visibleText);
	        } else {
	            System.out.println("This dropdown does not support multiple selections.");
	        }
	    }
	// 41.Write a code to deselect option by value in dropdown
	 public void deselectOptionByValue(WebElement dropdownElement, String value) {

		 Select select = new Select(dropdownElement);
	        
	        if (select.isMultiple()) {
	            select.deselectByValue(value);
	        } else {
	            System.out.println("This dropdown does not support multiple selections.");
	        }
	    }
	// 42.Write a code to deselect all selected option
	 public void deselectAllOptions(WebElement dropdownElement) {

		 Select select = new Select(dropdownElement);
	        
	        if (select.isMultiple()) {
	            select.deselectAll();
	        } else {
	            System.out.println("This dropdown does not support multiple selections.");
	        }
	    }
	 
	 
	 
	
	// 43.Write a code to clear values textbox
	public void textBoxClear(WebElement element) {
		visibilityOfElement(element);
			element.clear();
	}
	// 44.Write a code to Takescreenshot
	public void screenshot(String sName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("Your path" + sName + ".png"));
	}
	// 45.Write a code to Takescreenshot for element
	public void screenshot(String sName, WebElement element) throws IOException {
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("Your path"+ sName + ".png"));
	}
	// 46.Write a code to mouseoveraction for single option
	public void mouseOverAction(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	
	
	// 47.Write a code to drag and drop
	 public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
	        Actions actions = new Actions(driver);
	        
	        actions.dragAndDrop(sourceElement, targetElement).build().perform();
	    }
	// 48.Write a code to right click
	 public void rightClick(WebElement element) {
	        Actions actions = new Actions(driver);
	        
	        actions.contextClick(element).build().perform();
	    }
	// 49.Write a code to double click
	 public void doubleClick(WebElement element) {
	        Actions actions = new Actions(driver);
	        
	        actions.doubleClick(element).build().perform();
	    }
	// 50.Write a code to insert values in textbox and enter
	 public void insertValueAndEnter(WebElement textbox, String value) {
	        textbox.sendKeys(value);
	        textbox.sendKeys(Keys.RETURN);
	    }
	
	 
	 
	// 51.Write a code for navigation commands (to,forward,backward,refresh)
	public void navigateTo(String url) {
		driver.navigate().to(url);
	}
	public void navigateBack() {
		driver.navigate().back();
	}
	// 52.Write a code for page scroll down/up
	public void scroll(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView()", element);
	}
	//53.Write a code for getCellData in Excel sheet
	public String getCellData(String sheetName, int rownum, int cellnum) throws IOException {
		String res = "";

		File file = new File("C:\\Users\\Thangapandiyan P\\eclipse-workspace\\Grocery\\ExcelSheet\\Order ID Creation Test Data.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);

		CellType type = cell.getCellType();

		switch (type) {
		case STRING:
			res = cell.getStringCellValue();

			break;

		case NUMERIC:

			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();

				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
				res = dateFormat.format(dateCellValue);

			} else {

				double numericCellValue = cell.getNumericCellValue();

				long round = Math.round(numericCellValue);
				if (numericCellValue == round) {
					res = String.valueOf(round);

				} else {
					res = String.valueOf(numericCellValue);
				}

			}

			break;

		default:
			break;
		}
		return res;

	}
	//54.Write a code for createCellAndSetCellData in Excel sheet
	public void createCellAndSetCellData(String sheetName, int rownum, int cellnum, String data) throws IOException {
		File file = new File("C:\\Users\\Thangapandiyan P\\eclipse-workspace\\Grocery\\ExcelSheet\\Order ID Creation Test Data.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}
	//55.Write a code for updateCellData in Excel sheet
	public void updateCellData(String sheetName, int rownum, int cellnum, String oldData, String newData)
			throws IOException {
		File file = new File("C:\\Users\\Thangapandiyan P\\eclipse-workspace\\Grocery\\ExcelSheet\\Order ID Creation Test Data.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();

		if (value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}
	
	

}
