package com.example.test.jnitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String TAG ="JNI_TEST";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    // Example of a call to a native method
    TextView tv = (TextView) findViewById(R.id.sample_text);
    tv.setText(stringFromJNI());


    stringArray(new String[]{"Aaaa","Bbbb","C","D","E","F","G"});

    floatArray(new float[]{2.01f,1.34f,5.43f});

    callBack(this);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native void stringArray(String []strArr);
    public native void floatArray(float []fArray);
    public native void boolArray(boolean[] bArray);

    public static native void callBack(MainActivity activity);


    void onCallBack(int flag){
        Log.i(TAG, "onCallBack: "+flag);
    }



    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
