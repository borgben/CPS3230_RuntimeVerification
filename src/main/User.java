package main;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class User {
	public String userId;
	WebDriver driver;
	
	public User(String userId)
	{
		this.userId = userId;
        this.driver = new ChromeDriver();
        driver.get("https://www.marketalertum.com/");
	}
	
	public static void mismatchedAlertSizes() {}
	public static void validateAlert() {}
	public static void alertCreated() {}
	public static void alertsDeleted() {}
	public void userValidLogin() {System.out.println("Valid Login!");}
	public static void userLoggedOut() {}
	public static void alertsValidated() {}
	
	public void userViewedAlerts(List<Alert> alerts) 
	{
		//We know and from here on assume that the two views of our alerts line up.
		List<WebElement> webScrapeAlerts = driver.findElements(By.xpath("//table[@border='1']"));
		
		//We check that the number of alerts displayed are equivalent to the number of alerts created.
		if (alerts.size()!=webScrapeAlerts.size())
		{
			mismatchedAlertSizes();
			return;
		}
		
		for (int i=0; i< alerts.size(); i++)
		{
			
			alerts.get(i).setDisplayAttributes(webScrapeAlerts.get(i));
			System.out.println("Alert Displayed Description " + alerts.get(i).displayDescription);
			alerts.get(i).viewingAlert();
		}
	}
	
	int mapIconToAlertType(String iconName)
	{
		switch (iconName) {
			case "icon-car.png":
				return 1;
			case "icon-boat.png":
				return 2;
			case "icon-property-rent.png": 
				return 3;
			case "icon-property-sale.png": 
				return 4;
			case "icon-toys.png": 
				return 5;
			case "icon-electronics.png":
				return 6;
			default:
				return 0;
		
		}
			
	}
	
	
	public void matchEventToFn(Status event) throws InterruptedException
	{
		switch (event.eventLogType) {
			case 0:
				alertCreated();
			case 1:
				alertsDeleted();
			case 5:
				userValidLogin();
			case 6:
				userLoggedOut();
			case 7:
				Thread.sleep(2000);
				userViewedAlerts(event.systemState.alerts);
				
			default:
		}
	}
}
