package com.huolili.utils;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;

import java.io.IOException;


public class ScreenShotUtil {
//缩小图片

	
	public void screenShot() throws InterruptedException, IOException {
		UiDevice device= UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
		String filename = new DateUtil().getCurrentTime();
		String picPath = "data/local/tmp/screenshot/"+filename+".png";

        device.executeShellCommand("screencap -p "+picPath);

    }	      
}
