package com.examly.springapp;

import java.net.URL;

public class SpringApplicationTests<WebDriver> {

	ChromeOptions chromeOptions = new ChromeOptions();
	WebDriver driver = null;

	@BeforeTest
	public void beforeTest() throws Exception {
		
		driver = new RemoteWebDriver(new URL("http://34.85.242.216:5001"), chromeOptions);
	}

	@Test
	public void testcase_1() throws InterruptedException 
{
		driver.navigate().to("https://jqueryui.com/droppable/");
		
		
		
	}

	@Test
	public void testcase_2() throws InterruptedException 
      {
		driver.switchTo().frame(0);
	    WebElement drag= driver.findElement(By.id("draggable"));
	    WebElement drop=driver.findElement(By.id("droppable"));
		Actions a=new Actions(driver);
	    a.dragAndDrop(drag, drop).build().perform();
	}
	@Test
	public void testcase_3() throws InterruptedException 
      {
		WebElement drop=driver.findElement(By.id("droppable"));
		Assert.assertEquals(drop.getText(),"Dropped!");
	}

		
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
