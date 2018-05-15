package com.example.leeco.mytest;


import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import android.view.KeyEvent;


import com.huolili.utils.ScreenShotandMailUtil;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import static android.content.Context.ACTIVITY_SERVICE;
import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.InstrumentationRegistry.getTargetContext;

/**
 * Package Name: com.example.leeco.mytest
 * <p>
 * Project Name: MyTest
 * <p>
 * Created by Huolili on 2018/4/18
 *
 */
@RunWith(AndroidJUnit4.class)
public class TestCase {
    UiDevice device=UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

    @Before
    public void setUp(){

        getInstrumentation().getUiAutomation().executeShellCommand( "pm grant " + getTargetContext().getPackageName()
                + " android.permission.WRITE_EXTERNAL_STORAGE");
//        Log.i("Before","------Before Test------");
    }
    @Test
    public  void pressTest() throws IOException, MessagingException, InterruptedException, ClassNotFoundException, IllegalAccessException, InstantiationException {


        device.pressHome();
        Thread.sleep(3000);

        device.pressKeyCode(KeyEvent.KEYCODE_VOLUME_UP);
        new ScreenShotandMailUtil().screenShotandMail("teeeeeyyyyy");


//        new ScreenShotUtil().screenShot();
//        device.takeScreenshot(new File("/data/local/tmp/screenshot/ss.png"));



    }
}
