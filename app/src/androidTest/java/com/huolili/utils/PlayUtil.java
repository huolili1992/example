package com.huolili.utils;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;
import android.view.KeyEvent;





public class PlayUtil {
	UiDevice device=UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
	public void clickAndCheck() throws Exception{
		Thread.sleep(2000);
		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_CENTER);
		//点击海报图后，等待8s
		Thread.sleep(8000);
//		

		new VideoCheck().videoPagePlayCheck();

    	
	}
	//首屏检测	
	public void testRecPageScreen1() throws Exception{
		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_RIGHT);
		Thread.sleep(1000);
		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
		for(int i=0;i<3;i++){	    		
			clickAndCheck();
			device.pressKeyCode(KeyEvent.KEYCODE_DPAD_RIGHT);
		}
		clickAndCheck();
		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
		Thread.sleep(1000);
    	device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
    	Thread.sleep(1000);
    	device.pressKeyCode(KeyEvent.KEYCODE_DPAD_LEFT);
    	for(int i=0;i<3;i++){	    		
			clickAndCheck();
			device.pressKeyCode(KeyEvent.KEYCODE_DPAD_LEFT);
		}
    	clickAndCheck();
	}	
	//检测余屏
	public void testRecPageScreen2() throws Exception{	
		
		try {
			//光标先移到第二屏
			device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
		  	//从左到右检测、中国蓝综艺
    		for(int i=0;i<3;i++){   			
    			clickAndCheck();
    			device.pressKeyCode(KeyEvent.KEYCODE_DPAD_RIGHT);
    		}
    		clickAndCheck();
    		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
    		//从右到左检测、品牌专区
    		for(int i=0;i<2;i++){   			
    			clickAndCheck();
    			device.pressKeyCode(KeyEvent.KEYCODE_DPAD_LEFT);
    		}
    		clickAndCheck();
    		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
    		Thread.sleep(1000);
    		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_LEFT);
    		//从左至右检测、这一年我们经历了什么
    		for(int i=0;i<5;i++){   			
    			clickAndCheck();
    			device.pressKeyCode(KeyEvent.KEYCODE_DPAD_RIGHT);
    		}
    		clickAndCheck();
    		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
    		//从右到左检测、再见爱情
    		for(int i=0;i<5;i++){   			
    			clickAndCheck();
    			device.pressKeyCode(KeyEvent.KEYCODE_DPAD_LEFT);
    		}
    		clickAndCheck();
    		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
    		//从左至右检测、阳光满意
    		for(int i=0;i<5;i++){   			
    			clickAndCheck();
    			device.pressKeyCode(KeyEvent.KEYCODE_DPAD_RIGHT);
    		}
    		clickAndCheck();
    		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
    		//从右到左检测、谍战
    		for(int i=0;i<5;i++){   			
    			clickAndCheck();
    			device.pressKeyCode(KeyEvent.KEYCODE_DPAD_LEFT);
    		}
    		clickAndCheck();
    		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
    		//从左至右检测、热门专题
    		for(int i=0;i<2;i++){   			
    			clickAndCheck();
    			device.pressKeyCode(KeyEvent.KEYCODE_DPAD_RIGHT);
    		}
    		clickAndCheck();
    		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
    		//从右到左检测、进入新时代开启新征程
    		for(int i=0;i<5;i++){   			
    			clickAndCheck();
    			device.pressKeyCode(KeyEvent.KEYCODE_DPAD_LEFT);
    		}
    		clickAndCheck();
    		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
    		//从左至右检测、卡通大明星
    		for(int i=0;i<5;i++){   			
    			clickAndCheck();
    			device.pressKeyCode(KeyEvent.KEYCODE_DPAD_RIGHT);
    		}
    		clickAndCheck();
    		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
    		//从右到左检测、乐宠园
    		for(int i=0;i<5;i++){   			
    			clickAndCheck();
    			device.pressKeyCode(KeyEvent.KEYCODE_DPAD_LEFT);
    		}
    		clickAndCheck();
    		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
    		//从左至右检测、个性推荐1
    		for(int i=0;i<5;i++){   			
    			clickAndCheck();
    			device.pressKeyCode(KeyEvent.KEYCODE_DPAD_RIGHT);
    		}
    		clickAndCheck();
    		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
    		//从右到左检测、个性推荐2
    		for(int i=0;i<5;i++){   			
    			clickAndCheck();
    			device.pressKeyCode(KeyEvent.KEYCODE_DPAD_LEFT);
    		}
    		clickAndCheck();
    		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
    		//从左至右检测、个性推荐3
    		for(int i=0;i<5;i++){   			
    			clickAndCheck();
    			device.pressKeyCode(KeyEvent.KEYCODE_DPAD_RIGHT);
    		}
    		clickAndCheck();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	会员页检测
	public void testVipPageScreen1() throws Exception{
		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
        // 三个焦点位和一个小图位
		for(int i=0;i<3;i++){   			
			clickAndCheck();
			Thread.sleep(3000);	 
		}
		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_RIGHT);
		Thread.sleep(1000);
		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
		clickAndCheck();
		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
		//从右到左检测、电影
		for(int i=0;i<5;i++){   			
			clickAndCheck();
			device.pressKeyCode(KeyEvent.KEYCODE_DPAD_LEFT);
		}
		clickAndCheck();
		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
		//从左至右检测、少儿
		for(int i=0;i<5;i++){   			
			clickAndCheck();
			device.pressKeyCode(KeyEvent.KEYCODE_DPAD_RIGHT);
		}
		clickAndCheck();
		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
		//从右到左检测、电影
		for(int i=0;i<5;i++){   			
			clickAndCheck();
			device.pressKeyCode(KeyEvent.KEYCODE_DPAD_LEFT);
		}
		clickAndCheck();
		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
		//从左至右检测、泰剧
		for(int i=0;i<5;i++){   			
			clickAndCheck();
			device.pressKeyCode(KeyEvent.KEYCODE_DPAD_RIGHT);
		}
		clickAndCheck();
	}		
	//退出华数TV
		public void exitApp() throws InterruptedException{
			Thread.sleep(2000);	  
			UiObject app = new UiObject(new UiSelector().resourceId("com.stv.launcher:id/launcher_tab_item_title").text("应用"));
			UiObject exit= new UiObject(new UiSelector().resourceId("cn.com.wasu.main:id/exit"));
			while(!app.exists()){
				device.pressKeyCode(KeyEvent.KEYCODE_BACK);
				Thread.sleep(1500);
				if(exit.exists()){
					device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
					Thread.sleep(1000);
					device.pressKeyCode(KeyEvent.KEYCODE_ENTER);
				}				
			}			
		}
}
	
	
		
	

	    
	
	
		

