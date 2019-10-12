package PHPPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseClass
{
	WebDriver driver;
	Properties prop;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	By Cookie = By.xpath("//button[@id='cookyGotItBtn']");
	By Email = By.xpath("//input[@name='username']");
	By Password = By.xpath("//input[@type=\"password\"]");
	By LoginBtn = By.xpath("//button[@class='btn btn-action btn-lg btn-block loginbtn']");
	
	public void ExistingUserLogin() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\New folder\\PHPTravels1\\src\\main\\java\\TravelsData\\data.properties");
		prop.load(fis);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(Cookie).click();
		driver.findElement(Email).sendKeys(prop.getProperty("LoginEmail"));
		driver.findElement(Password).sendKeys(prop.getProperty("LoginPassword"));
		driver.findElement(LoginBtn).click();
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\PHP\\Login"));
		
	}
}
