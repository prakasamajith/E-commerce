package org.onlineshopping;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//to print order id, product name & prince in console using BaseClass Methods

public class GroceryOrder extends BaseClass {

	public static void main(String[] args) throws InterruptedException, AWTException {

		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://omrbranch.com/");

		WebElement element = driver.findElement(By.id("email"));
		element.sendKeys("ajithprakasam@gmail.com");

		driver.findElement(By.id("pass")).sendKeys("Prakasam@77");
		WebElement loginBtn = driver.findElement(By.xpath("//button [@value='login']"));
		loginBtn.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		/*
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='cart_btn']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),' Go To Cart ')]"))).click();
		try {
			WebElement close = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//img[@src='https://omrbranch.com/front/images/close-icon.png'])[1]")));close.click();
					System.out.println("Product removed in cart Successfully");
		} catch (NoSuchElementException e) {
					System.out.println("Close icon not present");
		} finally {
					System.out.println("in finally ");
		}
		*/
		wait.until(ExpectedConditions.elementToBeClickable(By.id("search"))).sendKeys("Nuts");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='hover1 font16 fontsemibold colorWhite bgTheme px-4 py-1 radius50 dyna_btn addBtn-21']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("cart-30"))).click();
		WebElement goToCart = driver.findElement(By.xpath("//a[contains(text(),' Go To Cart ')]"));
		js.executeScript("arguments[0].click()", goToCart);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-target='#addressModal']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("address_type"))).click();
		WebElement selectAddressType = driver.findElement(By.xpath("//option[@value='Home']"));
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		WebElement firstName = driver.findElement(By.name("first_name"));
		firstName.sendKeys("Prakasam");

		driver.findElement(By.name("last_name")).sendKeys("Ajith");

		driver.findElement(By.name("mobile")).sendKeys("9600809646");

		driver.findElement(By.name("apartment")).sendKeys("107");

		driver.findElement(By.name("address")).sendKeys("Burma Colony, Perungudi");

		WebElement selectState = driver.findElement(By.name("state"));

		Select select = new Select(selectState);
		select.selectByIndex(35);

		WebElement selectCity = wait.until(ExpectedConditions.elementToBeClickable(By.name("city")));
		Select city = new Select(selectCity);
		city.selectByVisibleText("Perungudi");

		driver.findElement(By.name("zipcode")).sendKeys("600096");
		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
		Thread.sleep(2000);
		WebElement paymentType = wait.until(ExpectedConditions.elementToBeClickable(By.id("payment_type")));
		Select payment = new Select(paymentType);
		payment.selectByIndex(1);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Visa')]"))).click();

		driver.findElement(By.name("card_no")).sendKeys("5555555555552222");
		WebElement selectMonth = driver.findElement(By.name("month"));
		Select month = new Select(selectMonth);
		month.selectByIndex(7);

		WebElement selectYear = driver.findElement(By.id("year"));
		Select year = new Select(selectYear);
		year.selectByIndex(6);

		driver.findElement(By.name("cvv")).sendKeys("777");

		driver.findElement(By.id("placeOrder")).click();

		Thread.sleep(2000);

		driver.close();

		WebDriver driver1 = new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.get("https://omrbranch.com/");

		WebElement element1 = driver1.findElement(By.id("email"));
		element1.sendKeys("ajithprakasam@gmail.com");

		driver1.findElement(By.id("pass")).sendKeys("Prakasam@77");
		WebElement loginBtn2 = driver1.findElement(By.xpath("//button [@value='login']"));
		loginBtn2.click();
		Thread.sleep(2000);
		driver1.findElement(By.xpath("//a[@data-testid='username']")).click();
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-testid='username']"))).click();
		WebElement myAccount = driver1.findElement(By.xpath("//a[contains(text(),'My Account')]"));
		Actions ac = new Actions(driver1);
		ac.moveToElement(myAccount).perform();
		myAccount.click();

		driver1.findElement(By.xpath("//a[contains(text(),'orders')]")).click();

		Thread.sleep(2000);
		driver1.findElement(By.xpath("(//a[contains(text(),'More Details')])[1]")).click();
		Thread.sleep(2000);
		WebElement orderNo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p [contains(text(),'Order No: ')]")));
		String order = orderNo.getText();
		System.out.println(order);

		WebElement productName = driver1.findElement(By.xpath("//p [contains(text(),'Berries')]"));
		String product = productName.getText();
		System.out.println("Product Name:" + product);

		WebElement productPrice = driver1.findElement(By.xpath("//span [@data-testid='new-price']"));
		String price = productPrice.getText();
		System.out.println("Price" + price);
	}

}
