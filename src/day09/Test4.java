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
	//b��ǩ��ҳ����ֻ��һ����ҪtagName��ǩд
	String c = driver.findElement(By.tagName("b")).getText();
	assertEquals("4",c);
  }
  
  @BeforeMethod
  @Parameters("browser")
  public void beforeMethod(String b) {
	if (b.equalsIgnoreCase("firefox")) {
		//�����������������
		FirefoxProfile profile = new FirefoxProfile();
		//����һ����ѡ��dom.ipc.plugins.enabled--��ֹflashʹ�ã�false
		profile.setPreference("dom.ipc.plugins.enabled", false);
		//��driver��ֵ������һ��FirefoxDriver����profile�������ݸ�������������������
		driver = new FirefoxDriver(profile);
	} else if (b.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	} else if (b.equalsIgnoreCase("ie")) {
		System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}
	
	//��������
	//driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
