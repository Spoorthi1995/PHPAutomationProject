package PHPPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class BaseClass 
{
	public static WebDriver driver;
	public static Properties prop = new Properties();
	
	@Test
	public  static void  LaunchDriverBrowser() throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\chrome driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		FileInputStream fis = new FileInputStream("C:\\New folder\\PHPTravels1\\src\\main\\java\\TravelsData\\data.properties");
		prop.load(fis);
		String BrowserName = prop.getProperty("Browser");
		driver.get(prop.getProperty("PHPURL"));
		
		
		driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[2]/ul[1]/li[1]/a[1]")).click();
		//driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left user_menu']//li[@id='li_myaccount']//ul[@class='dropdown-menu']//li//a[@class='go-text-right'][contains(text(),'Sign Up')]")).click();
		//driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left user_menu']//li[@id='li_myaccount']//ul[@class='dropdown-menu']//li//a[@class='go-text-right'][contains(text(),'Login')]")).click();
	
		/*SignUpXpath su = new SignUpXpath(driver);
		su.RegistrationPage();*/
		
		/*LoginPage lp = new LoginPage(driver);
		lp.ExistingUserLogin();*/
		
		/*HotelSearch hs1 = new HotelSearch(driver);
		hs1.SuccessHotelSearch();*/
		
		
		/*FlightSearch fs1 = new FlightSearch(driver);
		fs1.SuccessFlightSearch();*/
		
		TourSearch ts1 = new TourSearch(driver);
		ts1.SuccessTourSearch();
		
	}
	
	
	
	
}
