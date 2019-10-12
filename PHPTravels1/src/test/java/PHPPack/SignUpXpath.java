package PHPPack;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SignUpXpath extends BaseClass
{
	WebDriver driver;
	Properties prop;
	public SignUpXpath(WebDriver driver)
	{
		this.driver = driver;
	}
	By FirstName = By.xpath("//input[@placeholder='First Name']");
	By LastName = By.xpath("//input[@placeholder='Last Name']");
	By MobileNumber = By.xpath("//input[@name='phone']");
	By Email = By.xpath("//input[@name='email']");
	By Password = By.xpath("//input[@type=\"password\"]");
	By ConfirmPassword = By.xpath("//input[@placeholder='Confirm Password']");
	By Cookie = By.xpath("//button[@id='cookyGotItBtn']");
	By SignUpBtn = By.xpath("//button[@class='signupbtn btn_full btn btn-action btn-block btn-lg']");

	
	public void RegistrationPage() throws Exception
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\\\New folder\\\\PHPTravels1\\\\src\\\\main\\\\java\\\\TravelsData\\\\data.properties");
		prop.load(fis);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(Cookie).click();
		driver.findElement(FirstName).sendKeys(prop.getProperty("FirstName"));
		driver.findElement(LastName).sendKeys(prop.getProperty("LastName"));
		driver.findElement(MobileNumber).sendKeys(prop.getProperty("MobileNumber"));
		driver.findElement(Email).sendKeys(prop.getProperty("Email"));
		driver.findElement(Password).sendKeys(prop.getProperty("Password"));
		driver.findElement(ConfirmPassword).sendKeys(prop.getProperty("ConfirmPassword"));
		driver.findElement(SignUpBtn).click();
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\PHP\\SignUp"));
	}
}
