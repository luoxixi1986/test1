package day09;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestNG2 {
	WebDriver driver;
	
  @Test
  public void testa() throws InterruptedException {
	//打开前台首页
	driver.get("http://localhost//ecshop/upload/index.php");
	//输入关键字：私有变量kw的值
	driver.findElement(By.id("keyword")).sendKeys("a");
	//点击”搜索“
	driver.findElement(By.name("imageField")).click();
	Thread.sleep(3000);
	//断言统计个数是：私有变量count的值
	//String c = driver.findElement(By.tagName("b")).getText();assertEquals("4",c);
  }
  
  @BeforeMethod
  @Parameters("browser")
  public void beforeMethod(String b) throws InterruptedException {
	  //不区分大小写
	if (b.equalsIgnoreCase("firefox")) {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("dom.ipc.plugins.enabled", false);
		driver = new FirefoxDriver(profile);
		Thread.sleep(3000);
	} else if (b.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		Thread.sleep(3000);
	} else if (b.equalsIgnoreCase("ie")) {
		System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
		//IE游览器启动
		driver = new InternetExplorerDriver();
		Thread.sleep(3000);
	}
	
	//浏览器最大化
	driver.manage().window().maximize();
  }

  @AfterMethod	
  public void afterMethod() {
	  driver.quit();
  }

}
