package main;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class User {
	public String userId;
	WebDriver driver;
	public int noDisplayedAlerts;
	
	public User(String userId)
	{
		this.userId = userId;
        this.driver = new ChromeDriver();
        driver.get("https://www.marketalertum.com/");
	}
	
	public void mismatchedAlertSizes() {}
	public void validateAlert() {}
	public void alertCreated() {System.out.println("Alert Created!");}
	public void alertsDeleted() {System.out.println("Alert Deleted!");}
	public void userValidLogin() {System.out.println("Valid Login!");}
	public void userLoggedOut() {}
	public void alertsValidated() {}
	
	public void userViewedAlerts(List<WebElement> webScrapeAlerts, List<Alert> alerts) 
	{	
		
		if (alerts.size()<=5)
		{
			for (int i=0; i< alerts.size(); i++)
			{
				
				alerts.get(i).setDisplayAttributes(webScrapeAlerts.get(i));
				System.out.println("Alert Displayed Description " + alerts.get(i).displayDescription);
				alerts.get(i).viewingAlert();
			}
		}else{
			for (int i=0; i<5; i++)
			{
				alerts.get(i).setDisplayAttributes(webScrapeAlerts.get(i));
				System.out.println("Alert Displayed Description " + alerts.get(i).displayDescription);
				alerts.get(i).viewingAlert();
			}
		}

	}
	
	
	public void matchEventToFn(Status event) throws InterruptedException
	{
		System.out.println(event.eventLogType);
		switch (event.eventLogType) {
			case 0:
				alertCreated();return;
			case 1:
				alertsDeleted();return;
			case 5:
				this.userValidLogin();return;
			case 6:
				userLoggedOut();return;
			case 7:
				Thread.sleep(5000);
				List<WebElement> webScrapeAlerts = driver.findElements(By.xpath("//table[@border='1']"));
				System.out.println(webScrapeAlerts.size());
				this.noDisplayedAlerts = webScrapeAlerts.size();
				userViewedAlerts(webScrapeAlerts, event.systemState.alerts);
				return;
			default:
				return;
		}
	}
}
