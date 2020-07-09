package ZeynepDinc.HepsiBuradaSoru2;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class Model {

	static Logger logger = LogManager.getLogger(Model.class);
	private String url = "https://www.hepsiburada.com/";

	private String searchBox = "desktopOldAutosuggestTheme-input";

	private String titleExpected = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";

	private String productSelect = "hb-pl-cn";
	private String searchDetailExpected = "iphone - Hepsiburada";
	private String comments = "//*[@id=\"comments-container\"]/a[1]";
	private String expectedComments = "Yorum (";

	private String reviewCard = "//*[@id=\"reviews\"]/li[1]/div[6]/p[2]/a[1]";

	protected String getUrl() {
		return url;
	}

	protected String getTitleExpected() {
		return titleExpected;
	}

	protected String getProductSelect() {
		return productSelect;
	}

	protected String getSearchDetailExpected() {
		return searchDetailExpected;
	}

	protected String getComments() {
		return comments;
	}

	protected String getExpectedComments() {
		return expectedComments;
	}

	protected String getSearchBox() {
		return searchBox;
	}

	protected String getReviewCard() {
		return reviewCard;
	}

	public void Equals(String actual, String expected) {
		try {
			Assert.assertEquals(actual, expected);
			InfoLog(expected + " value is actual value.This");
		} catch (AssertionError e) {
			ErrorLog(e.getMessage());
		}
	}

	public void InfoLog(String message) {
		// TODO Auto-generated method stub
		logger.info(message + " is succes.");
		System.out.println(message + " is succes.");

	}

	public void ErrorLog(String message) {
		// TODO Auto-generated method stub
		logger.error(message + "has a problem. You must to look at again!");
		System.out.println(message + "has a problem. You must to look at again!");
	}

}