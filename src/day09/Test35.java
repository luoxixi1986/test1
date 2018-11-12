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

public class Test35 {
	WebDriver driver;
	
  @Test
  public void testa() {
	//��ǰ̨��ҳ
	driver.get("http://localhost//ecshop/upload/index.php");
	//����ؼ��֣�˽�б���kw��ֵ
	driver.findElement(By.id("keyword")).sendKeys("a");
	//�����������
	driver.findElement(By.name("imageField")).click();
	//����ͳ�Ƹ����ǣ�˽�б���count��ֵ
	String c = driver
		.findElement(By.tagName("b")).getText();
	//Ԥ��ֵ��4��ʵ��ֵ���ַ������͵�
	assertEquals(c,"4");
  }
  
  @BeforeMethod
  //��������������һ��������browser��������
  //��ȡTS1��xml����������
  //<parameter name="browser" value="firefox" />
  @Parameters("browser")
  //beforeMethod������ȡ�����������ǰ���˳��ֵ��
  //�в���
  public void beforeMethod(String b) {
	  //equalsIgnoreCase�Ƚ��ַ������Դ�Сд
	if (b.equalsIgnoreCase("firefox")) {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("dom.ipc.plugins.enabled", false);
		driver = new FirefoxDriver(profile);
	} else if (b.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	} else if (b.equalsIgnoreCase("ie")) {
		System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}
	
	//��������
	driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
