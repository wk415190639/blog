package com.example.threaddemo;

import android.util.Log;

public class ThreadSub extends Thread implements TAG{

    @Override
    public void run() {
        Log.e(TAG, "run: ThreadSub" );


    }
}
