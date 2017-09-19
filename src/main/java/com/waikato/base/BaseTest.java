package com.waikato.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.waikato.util.ConfigPropertyRead;

public class BaseTest extends BaseFramework {

	public BaseTest() {
		try {
			launchBrowser();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WebDriver launchBrowser() throws FileNotFoundException, IOException {
	
		if (ConfigPropertyRead.getInstance().get("browser").equals("firefox")) {
			driver = BrowserFactoryAll.getDriver(Browsers.FIREFOX);
		} else if (ConfigPropertyRead.getInstance().get("browser").equals("chrome")) {
			driver = BrowserFactoryAll.getDriver(Browsers.CHROME);
		} else {
			// TODO IE Driver can added over here
		}
		
		String baseUrl = ConfigPropertyRead.getInstance().get("url").toString();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
		return driver;
	}

	@BeforeClass
	public void setUp() {

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
