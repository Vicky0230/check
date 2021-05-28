package assignment_home;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import hooks.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004_Resolve_Incident extends BaseTest{

	WebElement searchField;
	WebElement searchIncident;
	Set<String> newWindow;
	List<String> allWindow;
	String secondWindow;
	String text;
	WebElement forTextNum;
	WebElement incidenturgency ;
	WebElement urgencyText ;
	String urgency;
	WebElement incidentstate;
	String state;
	String Priority;
	String state1;
	String Priority1;
	String incidentAssginedgroup ;
	WebElement forName ;
	String incidentAssignedTo;
	String getIncident;
	String state2;


	@And("search the Incident in filter3")
	public void searchIncident() throws InterruptedException{

		Thread.sleep(5000);
		searchIncident=driver.findElement(By.id("filter"));
		searchIncident.sendKeys("Incident");

	}

	@Then("Resolve Incident3")
	public void resolve_Incident() throws InterruptedException{

		driver.findElement(By.xpath("//div[text()='Create New']")).click();

		driver.findElement(By.xpath("//button[contains(@class,'btn btn-default')]")).click();

		Thread.sleep(2000);

	}


	@And("Incident search in the Field3")
	public void searchField() throws InterruptedException{


		forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(forTextNum).selectByIndex(1);

		searchField=driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchField.sendKeys(getIncident); 
		//INC0010928
		searchField.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}


	@And("Select the first match3")
	public void Verify_First_match() throws InterruptedException{

		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		Thread.sleep(2000);
	}		



	@And("WebElement incident state3")
	public void incidentstate() throws InterruptedException{


		incidentstate = driver.findElement(By.id("incident.state")); 
		Select state2=new Select(incidentstate);
		state2.selectByIndex(1);
		Thread.sleep(2000);
		WebElement stateText = state2.getFirstSelectedOption();
		state=stateText.getText();
		System.out.println(state);


	}

	@And("Update Resolution Information3")
	public void resolution_Information() throws InterruptedException{

		driver.findElement(By.xpath("//span[text()='Resolution Information']")).click();

		WebElement incidentclosecode = driver.findElement(By.id("incident.close_code")); 
		new Select(incidentclosecode).selectByIndex(7);

		driver.findElement(By.id("incident.close_notes")).sendKeys("Updating the resolution state and it's information");


	}



	@And("click Update Button3")
	public void updateButton() throws InterruptedException{

		driver.findElement(By.id("sysverb_update")).click();

		Thread.sleep(2000);

	}

	

	@Then ("Verify first match3")
	public void VerifyFirst_match1() throws InterruptedException{

		state2=driver.findElement(By.xpath("//td[text()='Resolved']")).getText();

		if(state.equals(state2))
		{
			System.out.println("State in Resoved Status");
		}
		else
		{
			System.out.println("State Not Equals");
		}

	}


}

