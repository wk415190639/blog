package com.example.test.threadlocal;

import android.util.Log;

public class CustomThread extends Thread {

    String TAG = "CustomThread";

    private RefObj refObj;


    public CustomThread(RefObj obj) {
        this.refObj = obj;
    }

    @Override
    public void run() {
        super.run();


        ThreadLocal<RefObj> threadLocal = new ThreadLocal();
        threadLocal.set(refObj);

        threadLocal.get().atomic_add_local();

        Log.i(TAG, "run: threadLocal.get().flag:" + threadLocal.get().flag);

    }

}
