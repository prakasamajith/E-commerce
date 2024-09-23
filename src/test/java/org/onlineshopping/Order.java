package org.onlineshopping;

import java.io.IOException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

//to add order id, product name & prince in Excel sheet using BaseClass Methods
public class Order extends BaseClass {

	public void orderIdCreation() throws IOException, InterruptedException {
		String str = "0";
		chromeBrowserLaunch();
		maximizeWindow();
		implicitWait(30);
		enterApplnUrl("https://omrbranch.com/");
		WebElement txtUsername = findLocatorById("email");
		elementSendKeys(txtUsername, getCellData("Sheet1", 1, 0));
		WebElement txtPassword = findLocatorById("pass");
		elementSendKeys(txtPassword, getCellData("Sheet1", 1, 1));
		WebElement btnClick = findLocatorByXpath("//button[@value='login']");
		elementClick(btnClick);

		WebElement cartNo = findLocatorByXpath("//span[@class='cart badge badge-xs badge-danger position-relative mr-0 cart_count']");
		String cartNoCount = cartNo.getText();
		int c = Integer.parseInt(cartNoCount);
		System.out.println("Cart count:" + cartNoCount);
		if (!cartNoCount.equals(str)) {
			WebElement cartBtn = findLocatorByClassName("cart_btn");
			visibilityOfElement(cartBtn);
			cartBtn.click();
			Thread.sleep(1000);
			WebElement goToCart = findLocatorByXpath("//a[(contains(text(),' Go To Cart '))]");
			visibilityOfElement(goToCart);
			goToCart.click();
			Thread.sleep(1000);
			WebElement close = findLocatorByXpath(
					("//img[@src=\"https://omrbranch.com/front/images/close-icon.png\"]"));
			visibilityOfElement(close);
			for (int i = 1; i <= c; i++) {
				WebElement closeBtn = findLocatorByXpath("(//img[@src='https://omrbranch.com/front/images/close-icon.png'])[" + i + "]");
				visibilityOfElement(closeBtn);
				elementClick(closeBtn);
			}
		}
		WebElement homeBtn = findLocatorByXpath("(//a[@class='nav-link'])[1]");
		try {
			elementClick(homeBtn);
		} catch (StaleElementReferenceException e) {
			homeBtn = findLocatorByXpath("(//a[@class='nav-link'])[1]");
			elementClick(homeBtn);
		}

		Thread.sleep(2000);

		WebElement searchBox = findLocatorById("search");
		elementSendKeys(searchBox, "Nuts");
		WebElement submitBtn = findLocatorByXpath("(//button[@type='submit'])[1]");
		visibilityOfElement(submitBtn);
		elementClick(submitBtn);
		WebElement addBtn = findLocatorByXpath("(//a[contains(text(),'Add')])[2]");
		elementClick(addBtn);
		visibilityOfElement(addBtn);
		WebElement addProduct = findLocatorByXpath("(//button[contains(text(),'Add')])[3]");
		elementClick(addProduct);
		visibilityOfElement(addProduct);
		Thread.sleep(2000);
		WebElement addToCart = findLocatorByXpath("//a[contains(text(),' Go To Cart ')]");
		visibilityOfElement(addToCart);
		elementClick(addToCart);
		WebElement createAddress = findLocatorByXpath("//img[@src=\"https://omrbranch.com/front/images/plus.png\"]");
		visibilityOfElement(createAddress);
		elementClick(createAddress);
		WebElement addressType = findLocatorById("address_type");
		visibilityOfElement(addressType);
		selectDropdownIndex(addressType, 3);
		Thread.sleep(2000);
		WebElement firstName = findLocatorByName("first_name");
		visibilityOfElement(firstName);
		elementSendKeys(firstName, getCellData("Sheet1", 1, 3));
		WebElement lastName = findLocatorByName("last_name");
		elementSendKeys(lastName, getCellData("Sheet1", 1, 4));
		WebElement mobile = findLocatorByName("mobile");
		elementSendKeys(mobile, getCellData("Sheet1", 1, 5));
		WebElement houseNo = findLocatorByName("apartment");
		elementSendKeys(houseNo, getCellData("Sheet1", 1, 6));
		WebElement address = findLocatorByName("address");
		elementSendKeys(address, getCellData("Sheet1", 1, 7));
		WebElement state = findLocatorByName("state");
		elementSendKeys(state, getCellData("Sheet1", 1, 8));
		WebElement city = findLocatorByName("city");
		selectDropdownText(city, "Perungudi");
		WebElement zipCode = findLocatorByName("zipcode");
		elementSendKeys(zipCode, getCellData("Sheet1", 1, 10));
		WebElement submit = findLocatorByXpath("(//button[@type=\"submit\"])[3]");
		elementClick(submit);
		Thread.sleep(3000);
		WebElement paymentType = findLocatorById("payment_type");
		visibilityOfElement(paymentType);
		selectDropdownIndex(paymentType, 1);
		WebElement visa = findLocatorByXpath("//label[contains(text(),'Visa')]");
		elementClick(visa);
		WebElement cardNo = findLocatorByName("card_no");
		elementSendKeys(cardNo, getCellData("Sheet1", 1, 11));
		WebElement month = findLocatorByName("month");
		selectDropdownIndex(month, 7);
		WebElement year = findLocatorByName("year");
		selectDropdownIndex(year, 6);
		WebElement cvv = findLocatorByName("cvv");
		elementSendKeys(cvv, getCellData("Sheet1", 1, 12));
		WebElement placeOrder = findLocatorById("placeOrder");
		elementClick(placeOrder);

		driver.close();

		chromeBrowserLaunch();
		maximizeWindow();
		enterApplnUrl("https://omrbranch.com/");
		implicitWait(30);
		WebElement txtUsername1 = findLocatorById("email");
		elementSendKeys(txtUsername1, getCellData("Sheet1", 1, 0));
		WebElement txtPassword1 = findLocatorById("pass");
		elementSendKeys(txtPassword1, getCellData("Sheet1", 1, 1));
		WebElement btnClick1 = findLocatorByXpath("//button[@value='login']");
		elementClick(btnClick1);

		WebElement user = findLocatorByXpath("//a[@data-testid=\"username\"]");
		elementClick(user);

		WebElement myAccount = findLocatorByXpath("//a[text()=\"My Account\"]");
		elementClick(myAccount);

		WebElement orders = findLocatorById("v-pills-orders-tab");
		elementClick(orders);

		WebElement moreDetails = findLocatorByXpath("(//a[text()=\"More Details\"])[1]");
		elementClick(moreDetails);

		WebElement orderId = findLocatorByXpath("(//span[@class=\"font16 fontNormal color36\"])[1]");
		String orderNo = orderId.getText();
		System.out.println(orderNo);
		createCellAndSetCellData("Sheet1", 1, 13, orderNo);

		WebElement product = findLocatorByXpath("//p[contains(text(),'Happilo')]");
		String productName = product.getText();
		System.out.println(productName);
		createCellAndSetCellData("Sheet1", 1, 14, productName);

		WebElement price = findLocatorByXpath("//span[@data-testid=\"new-price\"]");
		String newPrice = price.getText();
		System.out.println(newPrice);
		createCellAndSetCellData("Sheet1", 1, 15, newPrice);

	}

	public static void main(String[] args) throws IOException, InterruptedException {
		Order order = new Order();
		order.orderIdCreation();
	}
}
