package automation.framework.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class OnExceptionListener extends AbstractWebDriverEventListener {
	
	
	@Override
	public void onException(Throwable throwable, WebDriver driver) {
			super.onException(throwable, driver);
			
			File screenShoot =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenShoot, new File(".\\screenshoots\\screenshoot.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}