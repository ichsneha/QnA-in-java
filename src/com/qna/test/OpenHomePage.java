package com.qna.test;

import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;

import junit.framework.Assert;
import junit.framework.TestCase;

public class OpenHomePage extends TestCase {
	
	private DefaultSelenium defaultSelenium;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		String serverHost = "localhost";
		int serverPort= 4444;
		String browserStartCommand = "*chrome";
		String browserURL = "http://localhost:3000/";
		
		defaultSelenium = new DefaultSelenium(serverHost, serverPort, browserStartCommand , browserURL );
		defaultSelenium.start();
		defaultSelenium.open("");
		defaultSelenium.windowMaximize();
		
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		defaultSelenium.close();
		
	}
	
	@Test
	public void testOpenHomePage() throws Exception {
		
		String welcomeMsg = defaultSelenium.getText("//div[@class='header']/p");
		String twitterImg = "//img[@alt='Twitter.com']";

		
		Assert.assertEquals("hello R2D2", welcomeMsg);	

		defaultSelenium.click("//div[@class='content']/div/p/a");

		Assert.assertNotNull(twitterImg);
		
		//defaultSelenium.wait(20000);
		
		//defaultSelenium.click("//input[@id='username_or_email']");
		
		defaultSelenium.type("Username or Email:", "testmona1234");
	}
	
}
