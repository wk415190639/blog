package com.example.test.threadlocal;

import android.util.Log;

public class RefObj {
    String TAG = "CustomThread";

    public int flag =1;

    public void atomic_add(){
        flag ++;
        Log.i(TAG, "atomic_add flag:"+flag);
    }


    public void atomic_add_local(){
        flag +=2;
        Log.i(TAG, "atomic_add_local flag:"+flag);
    }
}
