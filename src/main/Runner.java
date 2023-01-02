package main;

import java.io.IOException;
import java.util.List;

public class Runner{
	public static void main(String[] args) throws IOException, InterruptedException{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\benja\\OneDrive\\Comp Sci\\Semester 1\\CPS3230 - Testing\\chromedriver_win32\\chromedriver.exe");
		User u1 = new User("5b403bf6-4f10-4bb3-ba93-54a4513864e2");
		while(true)
		{
			List<Status> eventTrace = u1.getEventTrace();
			for (Status event:eventTrace) {
				System.out.println("\n$$$$$$$$ CurrentEvent $$$$$$$$$\n" + event);
				u1.matchEventToFn(event);
			}
		}
	}
}
