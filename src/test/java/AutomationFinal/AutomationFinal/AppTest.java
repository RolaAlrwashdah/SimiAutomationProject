package AutomationFinal.AutomationFinal;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {
	WebDriver driver = new ChromeDriver();
	String Web = "https://codenboxautomationlab.com/practice/";

	Random rand = new Random();

	@BeforeTest
	public void radio() {

		driver.manage().window().maximize();
		driver.get(Web);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test(priority = 1, enabled = false)
	public void RadioButton() {

		List<WebElement> AllRadioButtons = driver.findElements(By.className("radioButton"));

		int TotalRadioButton = driver.findElements(By.className("radioButton")).size();

		int RandomRadioButtons = rand.nextInt(TotalRadioButton);

		AllRadioButtons.get(RandomRadioButtons).click();

		String NameRadioButton = AllRadioButtons.get(RandomRadioButtons).getAttribute("value");

		System.out.println(NameRadioButton);

	}

	@Test(priority = 2, enabled = false)
	public void SelectCountries() throws InterruptedException {

		WebElement SelectCountries = driver.findElement(By.id("autocomplete"));

		String[] CountriesName = { "jo", "sy", "su", "ya" };

		int Randcountries = rand.nextInt(CountriesName.length);

		SelectCountries.sendKeys(CountriesName[Randcountries]);

		System.out.println(CountriesName[Randcountries]);

		Thread.sleep(1000);

		SelectCountries.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

	}

	@Test(priority = 3, enabled = false)

	public void SelectTag() {

		WebElement select = driver.findElement(By.cssSelector("#dropdown-class-example"));

		Select mySelect = new Select(select);

		// mySelect.selectByVisibleText("Selenium");

		// mySelect.selectByIndex(2);
		mySelect.selectByValue("option3");

	}

	@Test(priority = 4, enabled = false)

	public void Checkbox() throws InterruptedException {

		WebElement Divcheckbox = driver.findElement(By.cssSelector("#checkbox-example"));

		List<WebElement> AllCheck = Divcheckbox.findElements(By.tagName("input"));

		int RandomCheck = rand.nextInt(AllCheck.size());
		int RandomCheck1 = rand.nextInt(AllCheck.size());

		AllCheck.get(RandomCheck).click();
		AllCheck.get(RandomCheck1).click();
//		for(int i=0;i<AllCheck.size();i++) {
//			
//			
//			AllCheck.get(i).click();
//			
//		}
	}

	@Test(priority = 5, enabled = false)

	public void OpenWindow() throws InterruptedException {

		WebElement MainWindow = driver.findElement(By.id("openwindow"));

		MainWindow.click();

		Set<String> handels = driver.getWindowHandles();
		List<String> WidowsList = new ArrayList<>(handels);

		driver.switchTo().window(WidowsList.get(1));

		System.out.println(driver.getTitle());

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"menu-item-9680\"]/a/span[1]")).click();

		driver.switchTo().window(WidowsList.get(0));
		Thread.sleep(2000);
		System.out.println(driver.getTitle());

	}

	@Test(priority = 6, enabled = false)
	public void OpenTab() throws InterruptedException {

		WebElement newTab = driver.findElement(By.id("opentab"));

		newTab.click();

		Set<String> handels = driver.getWindowHandles();
		List<String> TapList = new ArrayList<String>(handels);

		driver.switchTo().window(TapList.get(1));
		Thread.sleep(2000);
		System.out.println(driver.getTitle());

		driver.switchTo().window(TapList.get(0));

		Thread.sleep(2000);

		System.out.println(driver.getTitle());

	}

	@Test(priority = 7, enabled = false)
	public void AlertExample() throws InterruptedException {

		Thread.sleep(2000);

		WebElement EnterAlert = driver.findElement(By.id("name"));

		EnterAlert.sendKeys("Rola");

		WebElement Alert = driver.findElement(By.id("alertbtn"));

		Alert.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

	}

	@Test(priority = 8, enabled = false)
	public void ConfirmExample() throws InterruptedException {

		Thread.sleep(2000);

		WebElement EnterAlert = driver.findElement(By.id("name"));

		EnterAlert.sendKeys("Rola");

		WebElement Confirm = driver.findElement(By.id("confirmbtn"));

		Confirm.click();
		Thread.sleep(2000);
		// driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();

	}

	@Test(priority = 9, enabled = false)
	public void Table() {

		WebElement AllTable = driver.findElement(By.id("product"));

		List<WebElement> AllRow = AllTable.findElements(By.tagName("td"));

		// int RandData= rand.nextInt(AllRow.size());

		// System.out.println(AllRow.get(RandData).getText());

		for (int i = 2; i < AllRow.size(); i = i + 3) {

			System.out.println(AllRow.get(i).getText());

		}

	}

	@Test(priority = 10, enabled = false)
	public void hiddeshow() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 1500)");

		WebElement Hidde = driver.findElement(By.id("hide-textbox"));
		Thread.sleep(2000);
		Hidde.click();

		WebElement Show = driver.findElement(By.id("show-textbox"));

		Show.click();

	}

	@Test(priority = 11, enabled = false)
	public void EnabledDissButton() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 1600)");

		WebElement Enabled = driver.findElement(By.id("disabled-button"));
		Thread.sleep(2000);
		Enabled.click();

		WebElement Disenabled = driver.findElement(By.id("enabled-button"));

		Thread.sleep(2000);
		Disenabled.click();

		WebElement send = driver.findElement(By.id("enabled-example-input"));

		send.sendKeys("Rolass");

	}

	@Test(priority = 12, enabled = false)
	public void MouseHoverExample() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 1800)");

		WebElement MouseButton = driver.findElement(By.id("mousehover"));

		Actions action = new Actions(driver);

		action.moveToElement(MouseButton).build().perform();

		Thread.sleep(2000);
		// WebElement Top= driver.findElement(By.partialLinkText("To"));

		// WebElement Top= driver.findElement(By.linkText("Top"));
		// Top.click();

		WebElement Reload = driver.findElement(By.linkText("Reload"));

		Reload.click();

		driver.navigate().refresh();
	}

	@Test(priority = 13, enabled = false)

	public void CalenderExamle() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 1900)");
		WebElement BookApointment = driver.findElement(By.linkText("Booking Calendar"));

		BookApointment.click();
		Thread.sleep(2000);
		Set<String> handels = driver.getWindowHandles();

		List<String> widowsList = new ArrayList<String>(handels);

		driver.switchTo().window(widowsList.get(1));

		WebElement Table = driver.findElement(By.cssSelector(".datepick.wpbc_calendar"));

		List<WebElement> AllRow = Table.findElements(By.tagName("td"));

		for (int i = 0; i < AllRow.size(); i++) {

			System.out.println(AllRow.get(i).getText());

		}

	}

	@Test(priority = 14,enabled = false)

	public void iframe() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 2200)");
		Thread.sleep(2000);
		driver.switchTo().frame("iframe-name");

		WebElement burger = driver.findElement(By.cssSelector(".ct-mobile-meta-item.btn-nav-mobile.open-menu"));

		burger.click();

		Thread.sleep(2000);

		Set<String> handels = driver.getWindowHandles();

		List<String> widowsList = new ArrayList<String>(handels);

		driver.switchTo().window(widowsList.get(0));
        Thread.sleep(2000);
		
		WebElement BookApointment = driver.findElement(By.linkText("Booking Calendar"));
		BookApointment.click();
		Set<String> handels1 = driver.getWindowHandles();

		List<String> widowsList1 = new ArrayList<String>(handels1);

		driver.switchTo().window(widowsList1.get(1));
		
		System.out.println(driver.getTitle());
		
		
	}
	
	@Test(priority = 15)
	
    public void Download() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 2300)");
		WebElement down= driver.findElement(By.linkText("Download Apk files"));
		
		down.click();
   
}
}