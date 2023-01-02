package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class User {
	public String userId;
	WebDriver driver;
	public int noAlerts;
	public int noDisplayedAlerts;
	public boolean loginState;
	public List<Alert> alerts;
	
	public User(String userId)
	{
		this.userId = userId;
		this.alerts =new ArrayList<>();
        this.driver = new ChromeDriver();
        driver.get("https://www.marketalertum.com/");
	}
	
	public List<Status> getEventTrace() throws IOException{
		Type listType = new TypeToken<ArrayList<Status>>(){}.getType();
		String baseUrl= "https://api.marketalertum.com/EventsLog/" + this.userId;
		URL url = new URL(baseUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuilder stringBuilder = new StringBuilder();

		reader.lines().forEach(a->stringBuilder.append(a));
		List<Status> events = new Gson().fromJson(stringBuilder.toString(), listType);
		for (Status status: events )
		{
			for (Alert alert:status.systemState.alerts)
			{
				alert.setOwner(this);
			}
		}

		return events;
	}
	
	public void mismatchedAlertSizes() {}
	public void validateAlert() {}
	public void alertCreated() {}
	public void alertsDeleted() {}
	public void userValidLogin() {}
	public void userLoggedOut() {}
	public void alertsValidated() {}
	
	public void userViewedAlerts(List<WebElement> webScrapeAlerts, List<Alert> alerts) 
	{	
		
		if (alerts.size()<=5)
		{
			for (int i=0; i< alerts.size(); i++)
			{
				
				alerts.get(i).setDisplayAttributes(webScrapeAlerts.get(i));
				alerts.get(i).viewingAlert();
			}
		}else{
			for (int i=0; i<5; i++)
			{
				alerts.get(i).setDisplayAttributes(webScrapeAlerts.get(i));
				alerts.get(i).viewingAlert();
			}
		}

	}
	
	
	public void matchEventToFn(Status event) throws InterruptedException
	{
		System.out.println(event.eventLogType);
		this.loginState = event.systemState.loggedIn;
		switch (event.eventLogType) {
			case 0:
				this.alerts = event.systemState.alerts;
				this.noAlerts = event.systemState.alerts.size();
				alertCreated();
				this.loginState = event.systemState.loggedIn;
				return;
			case 1:
				this.noAlerts = event.systemState.alerts.size();
				for (Alert alert:this.alerts)
				{
					alert.setOwner(null);
				}
				alertsDeleted();
				this.loginState = event.systemState.loggedIn;
				return;
			case 5:
				this.userValidLogin();
				this.loginState = event.systemState.loggedIn;
				return;
			case 6:
				userLoggedOut();
				this.loginState = event.systemState.loggedIn;
				return;
			case 7:
				Thread.sleep(2000);
				List<WebElement> webScrapeAlerts = driver.findElements(By.xpath("//table[@border='1']"));
				this.noDisplayedAlerts = webScrapeAlerts.size();
				this.noAlerts = event.systemState.alerts.size();
				userViewedAlerts(webScrapeAlerts, event.systemState.alerts);
				this.loginState = event.systemState.loggedIn;
				return;
			default:
				this.loginState = event.systemState.loggedIn;
				return;
		}
	}
}
