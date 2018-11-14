package day09;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


public class Test3 {
	WebDriver driver;
	private boolean acceptNextAlert = true;
	
	@Before
	public void setUp() throws Exception {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("dom.ipc.plugins.enabled", false);
		driver = new FirefoxDriver(profile);
		//��������
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testa() throws Exception {
//		a.��ECShopǰ̨��ҳ
		driver.get("http://localhost//ecshop/upload/index.php");
//		b.����ؼ���a
		driver.findElement(By.xpath("//input[@id='keyword']")).sendKeys("a");
//		c.�������������ť
		driver.findElement(By.xpath("//input[@name='imageField']")).click();
//		d.���������Ʒ�����һ����Ʒ��ͼƬ
		driver.findElement(By.xpath("//div[@class='goodsItem'][last()]/a[1]/img")).click();
//		e.��������빺�ﳵ��
		driver.findElement(By.xpath("//img[contains(@src,'bnt_cat')]")).click();
//		f.�ȴ�5�룬�����ﳵҳ���еġ������������޸�Ϊ3
		Thread.sleep(5000);
		WebElement gn = driver.findElement(By.xpath("//input[contains(@id,'goods_number')]"));
		//�������
		gn.clear();
		//����3
		gn.sendKeys("3");	
//		g.�ȴ�5�룬��������еġ�ɾ��������
		Thread.sleep(1000);
		//�ı���text()='ɾ��'
		driver.findElement(By.xpath("//a[text()='ɾ��']")).click();
//		����ʾ�ϵ����ȷ����
		closeAlertAndGetItsText();
		Thread.sleep(6000);
		Thread.sleep(6000);
		Thread.sleep(6000);
		Thread.sleep(6000);
	}
	  
	//�з���ֵ�ã������void���޷���ֵ��
	  private String closeAlertAndGetItsText() throws Exception {
		    try {
		    	//��ȡ�����ʾ��
		      Alert alert = driver.switchTo().alert();
		      Thread.sleep(5000);
		      //��ʾ���л�ȡ�ı�
		      String alertText = alert.getText();
		      System.out.println(alertText);
		      Thread.sleep(5000);
		      //acceptNextAlertΪtrue�����е��ȷ����ť
		      if (acceptNextAlert) {
		    	  //��� ȷ��
		        alert.accept();
		      } else {
		    	  //��� ȡ��
		        alert.dismiss();
		      }
		      return alertText;
		      //���ܳɹ�ʧ�ܶ�Ҫִ��acceptNextAlertΪ��
		    } finally {
		      acceptNextAlert = true;
		    }
		  }
}
