package tacobellappstep;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.internal.invokers.AbstractParallelWorker.Arguments;

import io.cucumber.java.en.*;

public class orderfoodstepdef {
	WebDriver driver;
	@Given("Launch the tacobell application")
	public void launch_the_tacobell_application() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO'\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://www.tacobell.co.in/");
	}

	@When("Navigate to Tacos option")
	public void navigate_to_tacos_option() {
		WebElement tacosbutton = driver.findElement(By.xpath("//h4[text()=\" tacos\"]/parent::a"));
		Actions act = new Actions(driver);
		act.moveToElement(tacosbutton).click().build().perform();
		
	   
	}

	@Then("Naviagte to  order food")
	public void naviagte_to_order_food() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String firstwindow = driver.getWindowHandle();
		System.out.println("Parent windwo"+firstwindow+driver.getTitle());
		WebElement soft = driver.findElement(By.cssSelector("#layer-product-list>:nth-child(5)>ol>:nth-child(1)>div>:nth-child(2)>:nth-child(4)>a"));
		
		soft.click();
		
		
		driver.switchTo().window(firstwindow);
   
  	   
	   
	   
	}

	@Then("order the food by entering credentials")
	public void order_the_food_by_entering_credentials() {
		
		WebElement text= driver.findElement(By.xpath("//input[@id=\"name\"]"));
		text.sendKeys("chanbasha");
		WebElement ph= driver.findElement(By.id("telephone"));
		ph.sendKeys("9581925563");
		WebElement ordernow = driver.findElement(By.id("swiggy"));
		ordernow.click();
		WebElement ele = driver.findElement(By.cssSelector(".hdr_logo_div+ul>li>a[class=\"our_food\"]"));
		String text2 =ele.getText();
		Assert.assertEquals(text2, "OUR FOOD");
		
	}
}
