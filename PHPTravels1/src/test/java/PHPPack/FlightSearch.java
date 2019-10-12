package PHPPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.FileNotFoundException;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class FlightSearch extends BaseClass
{
	WebDriver driver;
	Properties prop;
	
	public FlightSearch(WebDriver driver)
	{
		this.driver=driver;
	}
	By Cookie = By.xpath("//button[@id='cookyGotItBtn']");
	By FlightBtn = By.xpath("//a[@title='Flights']");
	By FromCityEnterLocation = By.xpath("//div[@id='s2id_origin']//span[@class='select2-chosen'][contains(text(),'Enter Location')]");
	By FromEnterLocationType = By.xpath("//div[@id='s2id_origin']//a[@class='select2-choice select2-default']");
	By FromCitySelect = By.xpath("//div[contains(text(),'chester Intl (MAN)')]");
	By ToCityEnterLocation = By.xpath("//div[@id='s2id_destination']//span[@class='select2-chosen'][contains(text(),'Enter Location')]");
	By ToCityEnterLocationType = By.xpath("//div[@id='s2id_destination']//a[@class='select2-choice select2-default']");
	By ToCitySelect = By.xpath("//div[contains(text(),'lin Arpt (DUB)')]");
	
	By CheckInDate = By.xpath("//input[@placeholder='Depart']");
	By SearchBtn = By.xpath("//button[@class='btn-primary btn btn-lg btn-block pfb0']");
	
	public void SuccessFlightSearch() throws IOException, InterruptedException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\New folder\\PHPTravels1\\src\\main\\java\\TravelsData\\data.properties");
		prop.load(fis);
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(Cookie).click();
		driver.findElement(FlightBtn).click();
		driver.findElement(FromCityEnterLocation).click();
		driver.findElement(FromEnterLocationType).sendKeys(prop.getProperty("FlightFromCityName"));
		driver.findElement(FromCitySelect).click();
		
		driver.findElement(ToCityEnterLocation).click();
		driver.findElement(ToCityEnterLocationType).sendKeys(prop.getProperty("FlightToCityName"));
		driver.findElement(ToCitySelect).click();
		driver.findElement(CheckInDate).click();
		
		
		while(!driver.findElement(By.xpath("//div[16]//div[1]//tr[1]//th[2]")).getText().contains("November 2019"))
		{
			driver.findElement(By.xpath("//div[16]//div[1]//tr[1]//th[3]")).click();
		}
		Thread.sleep(1000);
		int count = driver.findElements(By.className("day")).size();
		
		for(int i=0;i<count;i++)
		{
			String text = driver.findElements(By.className("day")).get(i).getText();
			if(text.equalsIgnoreCase("9"))
			{
				driver.findElements(By.className("day")).get(i).click();
			}
		}
		driver.findElement(SearchBtn).click();
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\PHP\\Flights"));
		
		
		
	}
	
}


