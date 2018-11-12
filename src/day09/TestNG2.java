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
	//��ǰ̨��ҳ
	driver.get("http://localhost//ecshop/upload/index.php");
	//����ؼ��֣�˽�б���kw��ֵ
	driver.findElement(By.id("keyword")).sendKeys("a");
	//�����������
	driver.findElement(By.name("imageField")).click();
	Thread.sleep(3000);
	//����ͳ�Ƹ����ǣ�˽�б���count��ֵ
	//String c = driver.findElement(By.tagName("b")).getText();assertEquals("4",c);
  }
  
  @BeforeMethod
  @Parameters("browser")
  public void beforeMethod(String b) throws InterruptedException {
	  //�����ִ�Сд
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
		//IE����������
		driver = new InternetExplorerDriver();
		Thread.sleep(3000);
	}
	
	//��������
	driver.manage().window().maximize();
  }

  @AfterMethod	
  public void afterMethod() {
	  driver.quit();
  }

}
