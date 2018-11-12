package day09;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Test4 {
	WebDriver driver;
	
  @Test
  public void testa() {
	driver.get("http://localhost//ecshop/upload/index.php");
	driver.findElement(By.id("keyword")).sendKeys("a");
	driver.findElement(By.name("imageField")).click();
	//b标签在页面中只有一个就要tagName标签写
	String c = driver.findElement(By.tagName("b")).getText();
	assertEquals("4",c);
  }
  
  @BeforeMethod
  @Parameters("browser")
  public void beforeMethod(String b) {
	if (b.equalsIgnoreCase("firefox")) {
		//启动火狐游览器步骤
		FirefoxProfile profile = new FirefoxProfile();
		//设置一个首选项dom.ipc.plugins.enabled--静止flash使用，false
		profile.setPreference("dom.ipc.plugins.enabled", false);
		//给driver赋值，创建一个FirefoxDriver，将profile参数传递给它，启动游览器步骤
		driver = new FirefoxDriver(profile);
	} else if (b.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	} else if (b.equalsIgnoreCase("ie")) {
		System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}
	
	//浏览器最大化
	//driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
