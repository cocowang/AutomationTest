package com.company.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.company.elementPath.PageElementPath;

public class HomePageObject extends PageElementPath {
	// ���������
	public void click_Search_Bar(WebDriver driver) {
		driver.findElement(By.id(search_bar_id)).click();
	}

	// ����������
	public void input_Search_Box(WebDriver driver, String key_word) {
		driver.findElement(By.id(search_box_id)).clear();
		driver.findElement(By.id(search_box_id)).sendKeys(key_word);
		System.out.println("�ٶ�������Ѿ��ɹ��������������:" + key_word);
	}

	// ���������ť(�ٶ�һ��)
	public void click_Search_Button(WebDriver driver) {
		driver.findElement(By.name(search_button_name)).click();
		System.out.println("click the �ٶ�����,success...");
	}
}