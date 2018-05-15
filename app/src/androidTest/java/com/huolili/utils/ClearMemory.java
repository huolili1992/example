package com.huolili.utils;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.view.KeyEvent;


public class ClearMemory {
	public void clearMemory(){
		UiDevice device=UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
		String List;
		UiObject app = new UiObject(new UiSelector().text("应用"));
		UiObject TVManager = new UiObject(new UiSelector().className("android.widget.TextView").text("电视管家"));
		UiObject speedUp=new UiObject(new UiSelector().
				resourceId("com.stv.helper.main:id/module_name").text("系统加速"));
		UiObject scanFinish = new UiObject(new UiSelector().resourceId("com.stv.helper.main:id/tv_scanning").text("扫描完成"));
		UiObject finish = new UiObject(new UiSelector().text("完成"));
		//返回到home页
		device.pressKeyCode(KeyEvent.KEYCODE_HOME);
		device.pressKeyCode(KeyEvent.KEYCODE_HOME);
		try {
			app.click();
			Thread.sleep(1000);
			if(TVManager.waitForExists(4000)){
				TVManager.click();
				device.pressKeyCode(KeyEvent.KEYCODE_ENTER);
				if(speedUp.waitForExists(8000)){
					Thread.sleep(1500);										
					speedUp.click();					
					if(scanFinish.waitForExists(8000)){
						device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
						Thread.sleep(1500);
						device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
						Thread.sleep(1500);
						device.pressKeyCode(KeyEvent.KEYCODE_ENTER);
						if(finish.waitForExists(5000)){
							Thread.sleep(1500);
							device.pressKeyCode(KeyEvent.KEYCODE_BACK);
							Thread.sleep(1500);
							device.pressKeyCode(KeyEvent.KEYCODE_HOME);
							new DateUtil().getCurrentTime();
							System.out.println("TV垃圾清理完毕！");
						}else{
//							new ScreenShotandMailUtil().screenShotandMail(Elements.ALERT+"请看图片！");
							System.exit(0);
						}
					}else{
//						new ScreenShotandMailUtil().screenShotandMail(Elements.ALERT+"请看图片！");
						System.exit(0);
					}
					
				}else{
//					new ScreenShotandMailUtil().screenShotandMail(Elements.ALERT+"请看图片！");
					System.exit(0);
				}
			}else{
				new DateUtil().getCurrentTime();
				List ="Result: 找不到电视管家！！\n";
				Element.errorInfo="找不到电视管家！！！请看图片！\n";
				System.out.println(List);
//				new ScreenShotandMailUtil().screenShotandMail(Elements.ALERT+Elements.errorInfo);
				System.exit(0);
			}			
		} catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
