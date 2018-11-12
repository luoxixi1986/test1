package day09;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;


public class TestNgExcelPoi6 {
  WebDriver driver;
  @Test(dataProvider = "dp3")
  public void f(String kw, String count) throws InterruptedException {
	  //��ǰ̨��ҳ
	  driver.get("http://localhost/ecshop/upload/index.php");
	  Thread.sleep(3000);
	  //����ؼ��֣��βα���kw��ֵ
	  driver.findElement(By.id("keyword")).sendKeys(kw);
	  Thread.sleep(2000);
	  //�����������                   
	  driver.findElement(By.name("imageField")).click();
	  Thread.sleep(2000);
	  //����ͳ�Ƹ���:�βα���count��ֵ
	  String c = driver.findElement(By.tagName("b")).getText();
	  assertEquals(c,count);
  }
  @BeforeMethod
  public void beforeMethod() {
	  FirefoxProfile profile = new FirefoxProfile();
	  profile.setPreference("dom.ipc.plugins.enabled", false);
	  driver = new FirefoxDriver(profile);
	  //���������
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
//�Լ�ָ������������
@DataProvider(name="dp3")
//����һ����ά����
public Object[][] dp3() throws IOException {
//  return new Object[][] {
//    new Object[] { "a", "4" },
//	};
    return ReadExcelPOI.getTestData("C:\\workSpace","��������.xls","����");

}
}
