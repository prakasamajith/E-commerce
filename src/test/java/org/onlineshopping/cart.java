package org.onlineshopping;

import java.awt.AWTException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class cart {
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.get("https://omrbranch.com/");
		WebElement element = driver.findElement(By.id("email"));
		element.sendKeys("ajithprakasam@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Prakasam@77");
		WebElement loginBtn = driver.findElement(By.xpath("//button [@value='login']"));
		loginBtn.click();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='cart_btn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),' Go To Cart ')]")).click();
		Thread.sleep(2000);
		try {
		WebElement close = driver.findElement(By.xpath("(//img [@src='https://omrbranch.com/front/images/close-icon.png'])[1]"));
		close.click();
		System.out.println("Product removed in cart Successfully");
		}
		catch(NoSuchElementException e) {
			System.out.println("Not Present");
		}
	}
}
