package PHPPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class HotelSearch extends BaseClass
{
	WebDriver driver;
	Properties prop;
	
	public HotelSearch(WebDriver driver)
	{
		this.driver = driver;
	}
	By Cookie = By.xpath("//button[@id='cookyGotItBtn']");
	By HotelBtn = By.xpath("//li[@class='active text-center']//a[@class='text-center']");
	By SearchHotelorCity = By.xpath("//span[contains(text(),'Search by Hotel or City Name')]");
	By SearchHotelorCityType = By.xpath("//div[@id='s2id_location']//a[@class='select2-choice select2-default']");
	
	By CitySelect = By.xpath("/html[1]/body[1]/div[20]/ul[1]/li[1]/ul[1]/li[1]/div[1]");
	By CheckInDate = By.xpath("//input[@class='form form-control input-lg hcheckin']");
	By CheckOutDate = By.xpath("//input[@name='checkout']");
	By Guests = By.xpath("//input[@id='htravellersInput']");
	By AddAdults = By.xpath("//input[@id='hadultInput']");
	By AddChildren = By.xpath("//input[@name='child']");
	By SubmitBtn = By.xpath("//button[@class='btn btn-lg btn-block btn-primary pfb0 loader']");
	
	
	public void SuccessHotelSearch() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\New folder\\PHPTravels1\\src\\main\\java\\TravelsData\\data.properties");
		prop.load(fis);
		
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.findElement(Cookie).click();
		driver.findElement(HotelBtn).click();
		driver.findElement(SearchHotelorCity).click();
		driver.findElement(SearchHotelorCityType).sendKeys(prop.getProperty("HotelOrCityName"));
		driver.findElement(CitySelect).click();
		driver.findElement(CheckInDate).click();
		
		
		//for selecting check in date
		while(!driver.findElement(By.xpath("//div[14]//div[1]//tr[1]//th[2]")).getText().contains("November 2019"))
		{
			driver.findElement(By.xpath("//div[14]//div[1]//tr[1]//th[3]")).click();
		}
		int count = driver.findElements(By.className("day")).size();
		for(int i=0;i<count;i++)
		{
			String text = driver.findElements(By.className("day")).get(i).getText();
			if(text.equalsIgnoreCase("22"))
			{
				driver.findElements(By.className("day")).get(i).click();
			}
		}
		
		driver.findElement(CheckOutDate).click();
		while(!driver.findElement(By.xpath("//div[15]//div[1]//tr[1]//th[2]")).getText().contains("November 2019"))
		{
			driver.findElement(By.xpath("//div[15]//div[1]//tr[1]//th[3]")).click();
		}
		
		int count1 = driver.findElements(By.className("day")).size();
		for(int i=0;i<count1;i++)
		{
			String text = driver.findElements(By.className("day")).get(i).getText();
			if(text.equalsIgnoreCase("25"))
			{
				driver.findElements(By.className("day")).get(i).click();
			}
		}
		
		driver.findElement(Guests).click();
		driver.findElement(AddAdults).clear();
		driver.findElement(AddAdults).sendKeys("1");
		driver.findElement(AddChildren).clear();
		driver.findElement(AddChildren).sendKeys("2");
		driver.findElement(SubmitBtn).click();
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\PHP\\Hotel"));
		 
		
		
	}
	
}
