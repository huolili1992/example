package com.example.leeco.mytest;

import android.nfc.Tag;
import android.util.Log;

import java.io.IOException;

/**
 * Package Name: com.example.leeco.mytest
 * <p>
 * Project Name: MyTest
 * <p>
 * Created by Huolili on 2018/4/16
 */
public class Demo {

    public static  void main(String[] Args) throws IOException {
//        Runtime.getRuntime().exec("adb shell screencap -p data/local/tmp/screenshot/searchscreenshot.png");
        Log.i("TAG","screenshot!");
        System.out.println("Hello Java!");
        boolean a=System.getProperty("os.name").equals("Linux");
        System.out.println("c:"+a);
        System.out.println("Hello Ja");
    }
}
