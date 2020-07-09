import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ZeynepDinc.HepsiBuradaSoru2.Standart;

public class MyTest extends Standart {
	WebDriver driver;

	@BeforeTest
	public void PrepareTest()
	{
		/*
		 * Chrome driver çalıştırılır. Ekran boyutu hazırlanır.
		 */
		StandartHazirlik();
	}

	@Test(priority = 1)
	public void Test1() throws Throwable,Exception {
		/*
		 * Adım 1: Hepsiburada.com adresine gidilir, Başlık üzerinden doğrulama yapılır.
		 */
		Step1();
	}

	@Test(priority = 2)
	public void Test2() throws Throwable,Exception {
		/*
		 * Adım 2: Bu adımda arama çubuğuna tıklanılır "iphone" araması yapılır. Title
		 * değeri üzerinden kontrol sağlanır.
		 */
		Step2();
	}

	@Test(priority = 3)
	public void Test3() throws Throwable,Exception {
		/*
		 *İlk ürün seçilir. Açılan üründe "Yorum (" yazısı mevcut ise
		 *(yorumun var olduğuna dahil kontrolü bu şekilde gerçekleşitirilmekte)
		 * linke tıklanır. Mevcut değilse After Test çalıştırılır.
		 */
		Step3();
	}
	@Test(priority = 4)
	public void Test4() throws Throwable,Exception {
		/*
		 * Bu adımda "Evet(" yanıtına tıklanılır. Evet yazısı kontrol edilir. 
		 */
		Step4();
	}
	
	@Test(priority = 5)
	public void Test5() throws Throwable,Exception {
		/*
		 * Bu adımda "Teşekkür Ederiz." yazısı beklenir. Yazı çıktığında test sona erer.
		 */
		Step5();
	}

	@AfterTest
	void Close() throws Exception, Throwable, NoSuchElementException, NullPointerException {
		/*
		 * Test tamamlandı.
		 */
		Kapanis();
	}

}
