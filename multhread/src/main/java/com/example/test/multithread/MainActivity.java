package com.example.test.multithread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    static String TAG ="TEST";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startCallBack(this);

        Log.i(TAG, "MainActivity: ONCREATE");

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native void startCallBack(MainActivity mainActivity);


    void onCallBack(String tag){


        Log.i(TAG, "onCallBack: "+tag);
    }
}
