package ZeynepDinc.HepsiBuradaSoru2;

import java.security.InvalidParameterException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Standart extends Model {
	WebDriver driver;

	public void StandartHazirlik() {
		// TODO Auto-generated constructor stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	public void Step1(){
		try {
			// Step 1..
			driver.get(getUrl());
			String actualTitle = driver.getTitle();
			Equals(actualTitle, getTitleExpected());
			InfoLog("Step 1");
		} catch (NullPointerException nullPoint) {
			ErrorLog(nullPoint.getMessage());
		} catch (NoSuchElementException noSuch) {
			ErrorLog(noSuch.getMessage());
		} catch (ElementClickInterceptedException elementClick) {
			ErrorLog(elementClick.getMessage());
		} catch (InvalidParameterException parameter) {
			ErrorLog(parameter.getMessage());
		} catch (Exception ex) {
			ErrorLog(ex.getMessage());
		}

	}

	public void Step2(){
		try {
			// Step 2..
			WebElement search = driver.findElement(By.className(getSearchBox()));
			search.click();
			search.sendKeys("iphone" + Keys.ENTER);
			System.out.println("IPhone 5 aratıldı.");
			Wait(5000);
			String productActualTitle = driver.getTitle();
			Equals(productActualTitle, getSearchDetailExpected());
			InfoLog("Step 2");
		} catch (NullPointerException nullPoint) {
			ErrorLog(nullPoint.getMessage());
		} catch (NoSuchElementException noSuch) {
			ErrorLog(noSuch.getMessage());
		} catch (ElementClickInterceptedException elementClick) {
			ErrorLog(elementClick.getMessage());
		} catch (InvalidParameterException parameter) {
			ErrorLog(parameter.getMessage());
		} catch (Exception ex) {
			ErrorLog(ex.getMessage());
		}

	}

	public void Step3(){
		try {
			// Step 3..
			Wait(5000);
			PageDown();
			Wait(3000);
			driver.findElement(By.className(getProductSelect())).click();
			Wait(5000);
			System.out.println("Urun ekranı acildi");
			WebElement yorum = driver.findElement(By.xpath(getComments()));
			String commentsActual = yorum.getText();
			System.out.println("commentActuall = " + commentsActual.substring(0, 7));
			Equals(commentsActual.substring(0, 7), getExpectedComments());
			yorum.click();
			Wait(5000);
			PageDown();
			System.out.println("Yorum linkine tıklanıldı.");
			InfoLog("Step 3");
		} catch (NullPointerException nullPoint) {
			ErrorLog(nullPoint.getMessage());
		} catch (NoSuchElementException noSuch) {
			ErrorLog(noSuch.getMessage());
		} catch (ElementClickInterceptedException elementClick) {
			ErrorLog(elementClick.getMessage());
		} catch (InvalidParameterException parameter) {
			ErrorLog(parameter.getMessage());
		} catch (Exception ex) {
			ErrorLog(ex.getMessage());
		}

	}

	public void Step4(){
		try {
			Wait(5000);
			WebElement review = driver.findElement(By.xpath(getReviewCard()));
			String result = review.getText();
			Equals(result.substring(0, 6), "Evet (");
			review.click();
			System.out.println(result.substring(0, 6) + " butonuna tıklanıldı.");
			InfoLog("Step 4");
		} catch (InvalidParameterException parameter) {
			ErrorLog(parameter.getMessage());
		} catch (NullPointerException nullPoint) {
			ErrorLog(nullPoint.getMessage());
		} catch (NoSuchElementException noSuch) {
			ErrorLog(noSuch.getMessage());
		} catch (ElementClickInterceptedException elementClick) {
			ErrorLog(elementClick.getMessage());
		} catch (Exception ex) {
			ErrorLog(ex.getMessage());
		}
	}

	public void Step5(){
		try {
			String result = driver.findElement(By.xpath(getReviewCard())).getText();
			do {
				Wait(5000);
			} while (result == "Teşekkür Ederiz.");
			System.out.println(result + " yazısı görüldü.");
			InfoLog("Step 5");
		} catch (NullPointerException nullPoint) {
			ErrorLog(nullPoint.getMessage());
		} catch (NoSuchElementException noSuch) {
			ErrorLog(noSuch.getMessage());
		} catch (ElementClickInterceptedException elementClick) {
			ErrorLog(elementClick.getMessage());
		} catch (InvalidParameterException parameter) {
			ErrorLog(parameter.getMessage());
		} catch (Exception ex) {
			ErrorLog(ex.getMessage());
		}

	}

	protected void Kapanis() throws Throwable {
		try {
			driver.close();
			InfoLog("The test");
		} catch (NoSuchElementException e1) {
			ErrorLog(e1.getMessage());
		} catch (NullPointerException nullPoint) {
			ErrorLog(nullPoint.getMessage());
		} catch (ElementClickInterceptedException elementClick) {
			ErrorLog(elementClick.getMessage());
		} catch (Exception ex) {
			ErrorLog(ex.getMessage());
		}
	}

	public void PageDown() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	}

	public void Wait(long i) throws InterruptedException, Exception {
		Thread.sleep(i);
	}
}
