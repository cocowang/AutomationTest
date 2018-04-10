// ʹ��testng��ܵĲ�����, ��Ҫ����ҳ�������,��ť�Ĳ���
package com.company.testSuites.businessA;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.company.baseFrame.UseBrowser;
import com.company.pageObject.HomePageObject;

public class baiduSearch {
    HomePageObject page =new HomePageObject();
    UseBrowser browser = new UseBrowser();
    WebDriver drivers;
    
    
  @Test
  public void test_baidu() throws Exception {
      page.click_Search_Bar(drivers);
      page.input_Search_Box(drivers,"POM���ģʽ");
      Thread.sleep(10000);
      page.click_Search_Button(drivers);
  }


  @BeforeSuite
  public void beforeSuite() {
      drivers = browser.setupChrome("http://www.baidu.com/");
      System.out.println("Before Suite success....");
  }

  @AfterSuite
  public void afterSuite() {
      browser.teardownBrowser();
      System.out.println("After Suite success....");
  }
}

/**������Ϊ
Before Suite success....
�ٶ�������Ѿ��ɹ��������������:POM���ģʽ
After Suite success....
*/