package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Alert  {
		// Owner
		public User owner;
		
		// Actual Alert Variables
	    public int alertType;
	    public String heading;
	    public String description;
	    public String url;
	    public String imageUrl;
	    public String postedBy;
	    public int priceInCents;
	    public String postDate;
	    
	    //Display Variables
	    public String displayHeading;
	    public String displayDescription;
	    public String displayPrice;
	    public String displayUrl;
	    public String displayImgUrl;
	    public int iconType;
	    
	    
	    public void viewingAlert() {}
	    public void incompleteAlert() {}
	    public void invalidIconImg() {}
	    
	    public void setOwner(User owner)
	    {
	    	this.owner = owner;
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
	    
	    public void setDisplayAttributes(WebElement displayedAlert)
	    {
	    	this.displayHeading = displayedAlert.findElement(By.tagName("h4")).getText();
	    	this.displayDescription = displayedAlert.findElements(By.tagName("td")).get(2).getText();
	    	this.displayPrice = displayedAlert.findElements(By.tagName("td")).get(3).getText();
	    	this.displayUrl = displayedAlert.findElements(By.tagName("td")).get(4).findElement(By.tagName("a")).getAttribute("href");
	    	this.displayImgUrl = displayedAlert.findElement(By.xpath("//td[@rowspan='4']")).findElement(By.tagName("img")).getAttribute("src");
	    	this.iconType = mapIconToAlertType(displayedAlert.findElement(By.xpath("//td[@colspan='2']")).findElement(By.tagName("img")).getAttribute("src").replaceAll("https://www.marketalertum.com/images/", ""));
	    }

	    public Alert(int alertType, String heading, String description, String url, String imageUrl, int priceInCents, String postedBy, String postDate) {
	        this.alertType = alertType;
	        this.heading = heading;
	        this.description = description;
	        this.url = url;
	        this.imageUrl = imageUrl;
	        this.postedBy = postedBy;
	        this.priceInCents = priceInCents;
	        this.postDate = postDate;
	    }
	    
	    @Override
	    public String toString() {
	        return "Alert{" +
	                "alertType=" + alertType +
	                ", heading='" + heading + '\'' +
	                ", description='" + description + '\'' +
	                ", url='" + url + '\'' +
	                ", imageUrl='" + imageUrl + '\'' +
	                ", postedBy='" + postedBy + '\'' +
	                ", priceInCents=" + priceInCents +
	                '}';
	    }


}
