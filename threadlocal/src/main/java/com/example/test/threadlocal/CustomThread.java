package com.example.test.threadlocal;

import android.util.Log;

public class CustomThread extends Thread {

    String TAG = "CustomThread";


    ThreadLocal<RefObj> threadLocal;


    public CustomThread(ThreadLocal threadLocal) {
        this.threadLocal = threadLocal;
    }

    @Override
    public void run() {
        super.run();


        Log.i(TAG, "run: threadLocal.get():" + threadLocal.get());

        double random = Math.random()*1000;
        threadLocal.set(new RefObj(random));


        Log.i(TAG, "run: threadLocal.get().flag:" + threadLocal.get().flag);

    }

}
