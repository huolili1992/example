package com.huolili.utils;

import java.io.IOException;

public class ScreenShotandMailUtil {
	//截屏&发邮件
	public void screenShotandMail(String content) throws IOException {
		try {
			new ScreenShotUtil().screenShot();
		}  catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			new MailUtil().sendMail(content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
