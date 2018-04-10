package com.company.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.company.elementPath.PageElementPath;

public class HomePageObject extends PageElementPath {
	// 点击搜索栏
	public void click_Search_Bar(WebDriver driver) {
		driver.findElement(By.id(search_bar_id)).click();
	}

	// 搜索框输入
	public void input_Search_Box(WebDriver driver, String key_word) {
		driver.findElement(By.id(search_box_id)).clear();
		driver.findElement(By.id(search_box_id)).sendKeys(key_word);
		System.out.println("百度输入框已经成功输入的搜索内容:" + key_word);
	}

	// 点击搜索按钮(百度一下)
	public void click_Search_Button(WebDriver driver) {
		driver.findElement(By.name(search_button_name)).click();
		System.out.println("click the 百度以下,success...");
	}
}