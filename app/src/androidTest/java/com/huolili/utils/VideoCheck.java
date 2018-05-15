package com.huolili.utils;
//import java.io.IOException;

//import android.view.KeyEvent;

import java.io.IOException;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.view.KeyEvent;



public class VideoCheck {
	String List;
	UiObject wasuHome= new UiObject(new UiSelector().resourceId("cn.com.wasu.main:id/tab_box"));
	
	UiObject dataError=new UiObject(new UiSelector().
			className("android.widget.TextView").textContains("资产数据失败"));
	UiObject xiaxian=new UiObject(new UiSelector().
			resourceId("cn.com.wasu.main:id/tvContent").textContains("资产已下线"));
	UiObject playerError=new UiObject(new UiSelector().
			resourceId("cn.com.wasu.main:id/tvContent").textContains("播放器错误"));
	UiObject errorNull=new UiObject(new UiSelector().
			resourceId("cn.com.wasu.main:id/tvContent").textContains("null"));
	UiDevice device=UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
	
	public void videoPagePlayCheck() throws Exception{
		
		if(prepareForCheck()){
			videoPlayCheck();
			videoPlayBack();
		}else{
			videoPlayBack();
		}						
	}
	//异常存在与否
	public boolean isExceptionExists() throws InterruptedException, IOException {
		
		//不存在异常，return false
		if(!wasuHome.exists() &&  !errorNull.exists() && !dataError.exists() && !xiaxian.exists()  && !playerError.exists()){
			return false;
		}else{
			if(wasuHome.exists()){
				new DateUtil().getCurrentTime();
				System.out.println("Result: 点击海报图无响应！\n");
				Element.errorInfo="点击海报图无响应！视频信息请看图片！\n";
	        	new ScreenShotandMailUtil().screenShotandMail(Element.ALERT +Element.errorInfo);
			}
			if(errorNull.exists()){
				new DateUtil().getCurrentTime();
				System.out.println("Result: 出错了，视频点播失败！\n");
				device.pressKeyCode(KeyEvent.KEYCODE_BACK);
				Thread.sleep(2000);
				Element.errorInfo="出错了，视频点播失败，视频信息请看图片！\n";
	        	new ScreenShotandMailUtil().screenShotandMail(Element.ALERT +Element.errorInfo);
			}
			if(dataError.exists()){
				new DateUtil().getCurrentTime();
				System.out.println("Result: 出错了，提示获取资产数据失败！\n");
				device.pressKeyCode(KeyEvent.KEYCODE_BACK);
				Thread.sleep(2000);
				Element.errorInfo="出错了，提示获取资产数据失败！视频信息请看图片！\n";
	        	new ScreenShotandMailUtil().screenShotandMail(Element.ALERT +Element.errorInfo);
			}
			if(xiaxian.exists()){
				new DateUtil().getCurrentTime();
				System.out.println("Result: 出错了，提示资产下线！\n");
				device.pressKeyCode(KeyEvent.KEYCODE_BACK);
				Thread.sleep(2000);
				Element.errorInfo="出错了，提示资产下线！视频信息请看图片！\n";
	        	new ScreenShotandMailUtil().screenShotandMail(Element.ALERT +Element.errorInfo);
			}
			if(playerError.exists()){
				new DateUtil().getCurrentTime();
				System.out.println("Result: 出错了，提示播放器错误！\n");
				device.pressKeyCode(KeyEvent.KEYCODE_BACK);
				Thread.sleep(1000);
				Element.errorInfo="出错了，提示播放器错误！视频信息请看图片！\n";
	        	new ScreenShotandMailUtil().screenShotandMail(Element.ALERT +Element.errorInfo);
			}
		    return true;
		}									
	}
	//播放检测的准备工作，详情页弹窗检测（会弹出一些广告）
	public boolean prepareForCheck() throws InterruptedException, UiObjectNotFoundException, IOException{		
		//详情页-够会员的广告
		UiObject detailPage = new UiObject(new UiSelector().
				resourceId("cn.com.wasu.main:id/order"));	
		//详情页，会出现购买会员的广告
		UiObject popup_huasu=new UiObject(new UiSelector().
				className("android.widget.Button").text("立即关闭"));
		
		//如果有异常，return false
		if(isExceptionExists()){
			return false;			
		}else{
			if(popup_huasu.exists() ){	
				//消除弹框
				device.pressKeyCode(KeyEvent.KEYCODE_DPAD_RIGHT);
				Thread.sleep(2000);
				device.pressKeyCode(KeyEvent.KEYCODE_ENTER);
				Thread.sleep(2000);
			}			
			if(detailPage.exists()){
				//点击进入大窗播放，等5秒
				device.pressKeyCode(KeyEvent.KEYCODE_DPAD_LEFT);
				Thread.sleep(2000);
				device.pressKeyCode(KeyEvent.KEYCODE_ENTER);
				Thread.sleep(5000);												
				if(isExceptionExists()){
					return false;			
				}else return true;												    
			}else{
				//无详情页
				if(isExceptionExists()){
					return false;			
				}else{
					device.pressKeyCode(KeyEvent.KEYCODE_ENTER);
					Thread.sleep(5000);	
					if(detailPage.exists()){
						//点击进入大窗播放，等5秒
						device.pressKeyCode(KeyEvent.KEYCODE_DPAD_LEFT);
						Thread.sleep(2000);
						device.pressKeyCode(KeyEvent.KEYCODE_ENTER);
						Thread.sleep(3000);												
						if(isExceptionExists()){
							return false;			
						}else return true;												    
					}				
					return true;
				}								
			}	
	    }				
	}
	
	//播放检测
	public void videoPlayCheck() throws Exception{		
		//播放中暂停，为了获取界面控件
		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_CENTER);
		Thread.sleep(1000);
//		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_CENTER);
//		Thread.sleep(2000);
//		device.pressKeyCode(KeyEvent.KEYCODE_DPAD_CENTER);
		UiObject videoTitle1=new UiObject(new UiSelector().
				resourceId("cn.com.wasu.main:id/asset_name"));		
		UiObject TIME=new UiObject(new UiSelector().
				resourceId("cn.com.wasu.main:id/current_duration"));
		String videoText1="";
		String videoText2="";
		//获取标题，进度条时间    
		try{
			UiObject videoTitle2=new UiObject(new UiSelector().
					resourceId("cn.com.wasu.main:id/asset_info"));
			videoText2=videoTitle2.getText();
		}catch (UiObjectNotFoundException e){
			new DateUtil().getCurrentTime();
			System.out.println("【请忽略此条结果】 播放界面没有集数和清晰度信息。\n"); 
		}
		try{			
			videoText1=videoTitle1.getText();
			String videoText=videoText1+" "+videoText2;    		    	
        	String currentPlayTime=TIME.getText();
        	if(videoTitle1.exists() && TIME.exists()){            	
            	if(currentPlayTime!="00:00:00" || currentPlayTime != null){
            		List ="Result: 《"+ videoText+"》 播放成功！！！\n";
            		new DateUtil().getCurrentTime();
            		System.out.println(List);                		
            	}
            }
		}catch (UiObjectNotFoundException e){
//			哎呀出错了 图片控件
			UiObject error=new UiObject(new UiSelector().
					resourceId("cn.com.wasu.main:id/tvContent").instance(0));
			if(error.waitForExists(8000)){
				List ="Result:华数TV-点播视频，详情页一直是空的，等待数秒后，提示‘哎呀出错了’！！！\n";
        		new DateUtil().getCurrentTime();
        		System.out.println(List);
        		Element.errorInfo="错误：华数TV-点播视频，详情页一直是空的，等待数秒后，提示‘哎呀出错了’！！！";
				new ScreenShotandMailUtil().screenShotandMail(Element.ALERT + Element.errorInfo);
			}else{
//				次要错误，无法判断是哪种错误且很少出现，可忽略。可手工验证。
				new DateUtil().getCurrentTime();
				System.out.println("【手验】Result:界面没有控件信息，可能是：点播视频，一直在加载中！");                  
			}
			
		}  		                		
    	      	        			
	}
	// 退出播放
	public void videoPlayBack() throws InterruptedException, UiObjectNotFoundException{
		// 退出播放
		UiObject videoExit = new UiObject(new UiSelector().textContains("退出"));
		//一直返回到华数TV主页
		while (! wasuHome.exists()){
			device.pressKeyCode(KeyEvent.KEYCODE_BACK);
			Thread.sleep(1500);
			//有退出按钮就点击
			if (videoExit.exists()) {
				device.pressKeyCode(KeyEvent.KEYCODE_DPAD_DOWN);
				Thread.sleep(1000);
				device.pressKeyCode(KeyEvent.KEYCODE_ENTER);
				Thread.sleep(2000);
			}
		}
	}
}
		