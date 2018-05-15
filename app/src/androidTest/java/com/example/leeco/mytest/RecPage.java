package com.example.leeco.mytest;

import android.support.test.runner.AndroidJUnit4;


import com.huolili.utils.*;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RecPage  {
	//检测华数TV推荐页
	@Test
	public void testRecPage() throws Exception {
		new DateUtil().getCurrentTime();
//		System.out.println("********************开始清除内存********************");
//		new ClearMemory().clearMemory();
		new DateUtil().getCurrentTime();
		System.out.println("*****************开始测试华数TV推荐页*****************");			
		new LaunchWasuTV().launchWasutv();
		new PlayUtil().testRecPageScreen1();
		new PlayUtil().testRecPageScreen2();
	    new PlayUtil().exitApp();
		new DateUtil().getCurrentTime();
		System.out.println("*****************华数TV推荐页测试完毕****************");	
		
	}
//	public static void main(String [] args){
//		String jarName="WasuTV_UiAutomator",className="com.wasutv.test.testCase.RecPage",testName="testRecPage",androidId="3";
//		new UiAutomatorHelper(jarName,className,testName,androidId);
//	}
	
}
