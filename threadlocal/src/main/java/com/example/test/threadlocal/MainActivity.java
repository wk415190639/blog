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

        RefObj refObj = new RefObj();

        new CustomThread(refObj,true).start();
        new CustomThread(refObj,true).start();
        new CustomThread(refObj,false).start();
        Log.i(TAG, "MAIN run: refObj.flag:"+refObj.flag);

    }
}
