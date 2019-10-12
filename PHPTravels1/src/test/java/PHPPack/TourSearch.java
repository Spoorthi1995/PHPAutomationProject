package PHPPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TourSearch extends BaseClass
{

	WebDriver driver;
	Properties prop;
	
	public TourSearch(WebDriver driver)
	{
		this.driver = driver;
	}
	By Cookie = By.xpath("//button[@id='cookyGotItBtn']");
	By TourBtn = By.xpath("//a[@title='Tours']");
	By SelectCity = By.xpath("//span[contains(text(),'Search by Listing or City Name')]");
	By SelectCityType = By.xpath("//div[@id='s2id_autogen3']//a[@class='select2-choice select2-default']");
	By SelectCityPlace = By.xpath("//*[@id=\"select2-drop\"]/ul/li[1]/ul/li[1]/div");
	By DepartureDtae = By.xpath("//div[@id='tchkin']//input[@placeholder='Check in']");
	By Guests = By.xpath("//select[@id='adults']");
	By NumberOfGuests = By.xpath("//select[@id='adults']//option[3]");
	By TypeOfTour = By.xpath("//select[@id='tourtype']");
	By TypeOfTourTitle = By.xpath("//option[contains(text(),'Holidays')]");
	By SearchBtn = By.xpath("//div[@class='col-md-2 form-group go-right col-xs-12 search-button']//button[@class='btn-primary btn btn-lg btn-block pfb0 loader'][contains(text(),'Search')]");
	
	public void SuccessTourSearch() throws IOException, InterruptedException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\New folder\\PHPTravels1\\src\\main\\java\\TravelsData\\data.properties");
		prop.load(fis);
		
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.findElement(Cookie).click();
		driver.findElement(TourBtn).click();
		driver.findElement(SelectCity).click();
		driver.findElement(SelectCityType).sendKeys(prop.getProperty("TourName"));
		driver.findElement(SelectCityType).sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		driver.findElement(SelectCityPlace).click();
		driver.findElement(DepartureDtae).click();
		
		while(!driver.findElement(By.xpath("//div[11]//div[1]//tr[1]//th[2]")).getText().contains("November 2019"))
		{
			driver.findElement(By.xpath("//div[11]//div[1]//tr[1]//th[3]")).click();
		}
		Thread.sleep(1000);
		int count = driver.findElements(By.className("day")).size();
		
		for(int i=0;i<count;i++)
		{
			String text = driver.findElements(By.className("day")).get(i).getText();
			if(text.equalsIgnoreCase("8"))
			{
				driver.findElements(By.className("day")).get(i).click();
			}
		}
		driver.findElement(Guests).click();
		driver.findElement(NumberOfGuests).click();
		driver.findElement(TypeOfTour).click();
		driver.findElement(TypeOfTourTitle).click();
		driver.findElement(SearchBtn).click();
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\PHP\\Tours"));
	}

	

}
