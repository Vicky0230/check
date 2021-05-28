package hooks;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import assignment1.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends BaseTest{

	int i = 0;
	
	
	@Before
	public void launch()
	{

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}



	@After
	public void close()
	{

		driver.close();

	}


	@AfterStep
	public void screenshot() throws IOException
	{

		File src= driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./snap"+(i++)+".jpg"));


	}

}
