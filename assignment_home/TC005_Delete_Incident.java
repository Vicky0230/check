package assignment_home;

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

public class TC005_Delete_Incident extends BaseTest{


		String getIncident;
		WebElement searchField;
		WebElement searchIncident;
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
		String state2;
		String noRecordsTo ;


		@And("search the Incident in filter4")
		public void searchIncident() throws InterruptedException{

			Thread.sleep(5000);
			searchIncident=driver.findElement(By.id("filter"));
			searchIncident.sendKeys("Incident");

		}

		@Then("Delete Incident4")
		public void delete_Incident() throws InterruptedException{

			driver.findElement(By.xpath("//div[text()='Create New']")).click();

			driver.findElement(By.xpath("//button[contains(@class,'btn btn-default')]")).click();

			Thread.sleep(2000);

		}


		@And("Incident search in the Field4")
		public void searchField() throws InterruptedException{


			forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
			new Select(forTextNum).selectByIndex(1);

			searchField=driver.findElement(By.xpath("//input[@placeholder='Search']"));
			searchField.sendKeys(getIncident); 
			//INC0010928
			searchField.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
		}


		@And("Select the first match4")
		public void Verify_First_match() throws InterruptedException{

			driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
			Thread.sleep(2000);
		}	
		
		
		
		
		@And("Delete the incident4")
		public void Delete_Incident() throws InterruptedException{
			driver.findElement(By.id("sysverb_delete")).click();
			
			driver.findElement(By.id("ok_button")).click();
			
			Thread.sleep(2000);
		}	
		


		@And("Verify first match4")
		public void VerifyFirst_match1() throws InterruptedException{

			
			noRecordsTo = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
			
			if(noRecordsTo.equals("No records to display"))
			{
				System.out.println("Deleted Successfully");
			}
			

	}

}
