package hooks;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import stepDefinitions.Base;

public class CucumberHooks extends Base {
	
	@BeforeAll
	public static void StartTest() throws MalformedURLException, InterruptedException {

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C://Users//000S2L744//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		
		service.start();
		
		//Setting mobile capabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "soumyajitQ");
        desiredCapabilities.setCapability("udid","emulator-5554");
        desiredCapabilities.setCapability("automationName","UiAutomator2");
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("platformVersion","10");
        desiredCapabilities.setCapability("appPackage","com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity","com.android.calculator2.Calculator");

        //Setting Url
        URL url = new URL("http://127.0.0.1:4723");

        //setting driver
        driver = new AndroidDriver(url,desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("application started");

	}
	
	@AfterAll
	public static void TearDown() {
		driver.quit();
		service.stop();
	}

}
