package com.huolili.utils;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.view.KeyEvent;

import android.support.test.uiautomator.*;

import java.io.IOException;


//启动华数tv，检测推荐页和vip页
public class LaunchWasuTV  {
	UiDevice device=UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

	public void launchWasutv() throws Exception {
		String List;
		UiObject app = new UiObject(new UiSelector().text("应用"));
		UiObject wasuTV = new UiObject(new UiSelector().text("华数TV"));
		UiObject mainPage = new UiObject(new UiSelector().resourceId("cn.com.wasu.main:id/tab_box"));
		UiObject error = new UiObject(new UiSelector().text("首页数据加载失败"));
		UiObject error01 = new UiObject(new UiSelector().text("我要反馈"));
		//返回到home页，找到应用桌面		
		device.pressKeyCode(KeyEvent.KEYCODE_HOME);
	    app.click();
	    Thread.sleep(3000);
	    if(!wasuTV.exists()){
	    	List="Result: 未找到华数TV！\n";
	    	System.out.println(List);
	    	Element.errorInfo="未找到华数TV！请看图片！\n";
        	new ScreenShotandMailUtil().screenShotandMail(Element.ALERT +Element.errorInfo);
	        System.exit(0);
	    }
	    device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
	    Thread.sleep(1000);
	    device.pressKeyCode(KeyEvent.KEYCODE_BACK);
	    Thread.sleep(3000);	    
	    device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
	    Thread.sleep(1000);
	    wasuTV.click();	    	 
	    while(!mainPage.exists()){
	    	Thread.sleep(2000); 
	    	if(error.exists() || error01.exists()){
	    		new DateUtil().getCurrentTime();
				System.out.println("Result: 华数TV-提示首页数据加载失败！\n");
				device.pressKeyCode(KeyEvent.KEYCODE_BACK);
				Thread.sleep(2000);
				Element.errorInfo="华数TV-首页数据加载失败！请看图片！\n";
	        	new ScreenShotandMailUtil().screenShotandMail(Element.ALERT +Element.errorInfo);
	        	System.exit(0);
	    	}
	    }	 
	    if(mainPage.exists()){
	    	new DateUtil().getCurrentTime();
	    	System.out.println("Result: 华数TV启动成功！\n");//在此认为：出现首页即启动成功
	    	mainPageCheck();
	    	vipPageCheck();	    	
	    }
	}
//华数TV-首页数据检测
	public void mainPageCheck() throws InterruptedException, IOException {
		//播放记录、海报		
		UiObject data0 = new UiObject(new UiSelector().resourceId("cn.com.wasu.main:id/histrory_focus"));
		UiObject data1 = new UiObject(new UiSelector().resourceId("cn.com.wasu.main:id/poster03"));	
      //网易新闻、专区
		UiObject data2 = new UiObject(new UiSelector().resourceId("cn.com.wasu.main:id/brand_area02"));	
		UiObject data3 = new UiObject(new UiSelector().resourceId("cn.com.wasu.main:id/area_name"));	
		if(!(data0.waitForExists(5000) && data1.waitForExists(5000) && data2.waitForExists(5000) && data3.waitForExists(5000))){
			new DateUtil().getCurrentTime();
			System.out.println("Result: 华数TV推荐页异常！\n");
			Element.errorInfo="华数TV推荐页异常！请看图片！\n";
			new ScreenShotandMailUtil().screenShotandMail(Element.ALERT +Element.errorInfo);	        
	        System.exit(0);
		}else{
	    	new DateUtil().getCurrentTime();
			System.out.println("Result: 华数TV推荐页正常！\n");	
		}	
	}

	//华数TV-VIP页面数据检测
	public void vipPageCheck() throws InterruptedException, IOException {
		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_UP);
		Thread.sleep(1000);
		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_LEFT);
		Thread.sleep(1000);
     //用户信息、大海报、专区海报
		UiObject data0 = new UiObject(new UiSelector().resourceId("cn.com.wasu.main:id/user_layout"));
		UiObject data1 = new UiObject(new UiSelector().resourceId("cn.com.wasu.main:id/banner_poster"));	
		UiObject data2 = new UiObject(new UiSelector().resourceId("cn.com.wasu.main:id/assets_postr").instance(0));
		UiObject data3 = new UiObject(new UiSelector().resourceId("cn.com.wasu.main:id/assets_postr").instance(5));
		
		if(!(data0.waitForExists(5000) && data1.waitForExists(5000) && data2.waitForExists(5000) && data3.waitForExists(5000)) ){
			new DateUtil().getCurrentTime();
			System.out.println("Result: 华数TV-VIP页异常！\n");
			Element.errorInfo="华数TV-VIP页异常！请看图片！\n";
			new ScreenShotandMailUtil().screenShotandMail(Element.ALERT +Element.errorInfo);	        
			System.exit(0);
		}else{
	    	new DateUtil().getCurrentTime();
			System.out.println("Result: 华数TV-VIP页正常！\n");
			Thread.sleep(1000);
		}	
	}

}
