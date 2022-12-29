package main;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;





import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class Runner{
	public static List<Status> getEventTrace(String userId, User owner) throws IOException{
		Type listType = new TypeToken<ArrayList<Status>>(){}.getType();
		String baseUrl= "https://api.marketalertum.com/EventsLog/" + userId;
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
				alert.setOwner(owner);
			}
		}

		return events;
	}
	


	public static void main(String[] args) throws IOException, InterruptedException{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\benja\\OneDrive\\Comp Sci\\Semester 1\\CPS3230 - Testing\\chromedriver_win32\\chromedriver.exe");
		User u1 = new User("5b403bf6-4f10-4bb3-ba93-54a4513864e2");
		while(true)
		{
			List<Status> eventTrace = getEventTrace("5b403bf6-4f10-4bb3-ba93-54a4513864e2", u1);
			for (Status event:eventTrace) {
				System.out.println("\n$$$$$$$$ CurrentEvent $$$$$$$$$\n" + event);
				u1.matchEventToFn(event);
			}
		}
	}
}
