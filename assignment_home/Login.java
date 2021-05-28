package assignment_home;

import org.openqa.selenium.By;

import hooks.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class Login extends BaseTest {
	
	@Given("Load URL {string}")
	public void loadURL(String url) {
		driver.get(url);
	}
	
	@When("Move to frame")
	public void moveToFrame() {
		driver.switchTo().frame("gsft_main");
	}
	
	@And("Type username {string}")
	public void typeUsername(String username) {
		driver.findElement(By.id("user_name")).sendKeys(username);
	}
	
	@And("Type password {string}")
	public void typePassword(String pwd) {
		driver.findElement(By.id("user_password")).sendKeys(pwd);
	}
	
	@And("click on Login button")
	public void clickLoginButton() {
		driver.findElement(By.id("sysverb_login")).click();
	}

}
