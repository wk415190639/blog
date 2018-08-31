package com.example.test.threadlocal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    String TAG = "CustomThread";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ThreadLocal<RefObj> threadLocal = new ThreadLocal();

        threadLocal.set(new RefObj(100));

        new CustomThread(threadLocal).start();

        new CustomThread(threadLocal).start();


        try {
            Thread.sleep(10);
        }
        catch (Exception e){

        }
        Log.i(TAG, "MAIN run: refObj.flag:"+threadLocal.get().flag);

    }
}
