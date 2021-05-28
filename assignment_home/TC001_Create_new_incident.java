package assignment_home;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import hooks.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_Create_new_incident extends BaseTest
{
	public static String getIncident;
	
	WebElement searchField;
	WebElement searchIncident;
	Set<String> newWindow;
	List<String> allWindow;
	String secondWindow;
	String text;


	@And("search the Incident in filter")
	public void searchIncident() throws InterruptedException{

		Thread.sleep(5000);
		searchIncident=driver.findElement(By.id("filter"));
		searchIncident.sendKeys("Incident");

	}

	@And("create New Incident")
	public void create_New_Incident(){

		driver.findElement(By.xpath("//div[text()='Create New']")).click();

	}

	@And("Get the Incident Number")
	public void getIncident() throws InterruptedException{

		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
		
		getIncident=driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("GetIncident Number :"+getIncident);

	}


	@And("click Caller lookup Button")
	public void callerlookup() throws InterruptedException{

		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Thread.sleep(2000);

	}

	@And("Select the system_Administrator")
	public void system_Administrator(){


		newWindow=driver.getWindowHandles();
		allWindow=new ArrayList<String>(newWindow);

		secondWindow=allWindow.get(1);

		driver.switchTo().window(secondWindow);

		driver.findElement(By.linkText("System Administrator")).click();

	}

	@And("Give the short_description {string}")
	public void short_description(String description) throws InterruptedException{

		driver.switchTo().window(allWindow.get(0));		

		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);

		driver.findElement(By.id("incident.short_description")).sendKeys(description);

	}

	@And("click Submit Button")
	public void submitButton() throws InterruptedException{

		driver.findElement(By.id("sysverb_insert_bottom")).click();

		Thread.sleep(2000);

	}

	@And("Incident search in the Field")
	public void searchField() throws InterruptedException{

		searchField=driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchField.sendKeys(getIncident);
		searchField.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

	}



	@Then("Verify first match")
	public void VerifyFirst_match() throws InterruptedException{

		searchField=driver.findElement(By.xpath("//input[@placeholder='Search']"));

		text=driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();

		if(text.equals(getIncident))
		{
			System.out.println("Incident Number is Equal");
		}

		Thread.sleep(2000);

		driver.switchTo().defaultContent();

	}





}
